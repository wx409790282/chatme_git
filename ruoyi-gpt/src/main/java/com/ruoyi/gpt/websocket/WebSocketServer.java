package com.ruoyi.gpt.websocket;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.Message;
import com.ruoyi.chat.domain.ChatAnswer;
import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.domain.ChatSession;
import com.ruoyi.chat.service.IChatAnswerService;
import com.ruoyi.chat.service.IChatModelService;
import com.ruoyi.chat.service.IChatSessionService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.gpt.config.LocalCache;
import com.ruoyi.gpt.entity.ChatEntity;
import com.ruoyi.gpt.listener.OpenAISessionEventSourceListener;
import com.ruoyi.gpt.listener.OpenAISocketEventSourceListener;
import com.ruoyi.gpt.utils.ChatGPTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 描述：websocket 服务端
 *
 * @author https:www.unfbx.com
 * @date 2023-03-23
 */
@Slf4j
@Component
@ServerEndpoint("/sms/message/{uid}")
public class WebSocketServer {

    private static ChatGPTUtil chatGPTUtil;
    private static IChatModelService chatModelService;
    private static IChatSessionService chatSessionService;
    public static IChatAnswerService chatAnswerService;
    private String modelName="";
    @Autowired
    public void setOrderService(ChatGPTUtil chatGPTUtil) {
        this.chatGPTUtil = chatGPTUtil;

    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
        chatGPTUtil=applicationContext.getBean(ChatGPTUtil.class);
        chatModelService=applicationContext.getBean(IChatModelService.class);
        chatSessionService=applicationContext.getBean(IChatSessionService.class);
        chatAnswerService=applicationContext.getBean(IChatAnswerService.class);
    }
    //在线总数
    private static int onlineCount;

    public Session getSession() {
        return session;
    }

    //当前会话
    private Session session;
    //用户id -目前是按浏览器随机生成
    private String uid;
    private String sessionId="";

    public String getSessionId() {
        return sessionId;
    }

    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 用来存放每个客户端对应的WebSocketServer对象
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap();

    /**
     * 为了保存在线用户信息，在方法中新建一个list存储一下【实际项目依据复杂度，可以存储到数据库或者缓存】
     */
    private final static List<Session> SESSIONS = Collections.synchronizedList(new ArrayList<>());


    /**
     * 建立连接
     * @param session
     * @param uid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;
        webSocketSet.add(this);
        SESSIONS.add(session);
        if (webSocketMap.containsKey(uid)) {
            webSocketMap.remove(uid);
            webSocketMap.put(uid, this);
        } else {
            webSocketMap.put(uid, this);
            addOnlineCount();
        }
        log.info("[连接ID:{}] 建立连接, 当前连接数:{}", this.uid, getOnlineCount());
    }

    /**
     * 断开连接
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        if (webSocketMap.containsKey(uid)) {
            webSocketMap.remove(uid);
            subOnlineCount();
        }
        log.info("[连接ID:{}] 断开连接, 当前连接数:{}", uid, getOnlineCount());
    }

    /**
     * 发送错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("[连接ID:{}] 错误原因:{}", this.uid, error.getMessage());
        error.printStackTrace();
    }

    public String getModelName() {
        return modelName;
    }

    public String getUid() {
        return uid;
    }

    /**
     * 接收到客户端消息
     * @param msg
     */
    @OnMessage
    public void onMessage(String msg) {
        log.info("[连接ID:{}] 收到消息:{}", this.uid, msg);
        ChatEntity entity = JSON.parseObject(msg, new TypeReference<ChatEntity>(){});

        //接受参数
        //OpenAISessionEventSourceListener eventSourceListener = new OpenAISessionEventSourceListener(this.session);
        OpenAISocketEventSourceListener eventSourceListener = new OpenAISocketEventSourceListener(this);
        List<Message> messages = new ArrayList<>();

        if(entity.isStatus() ){
            //创建新的会话
            if(StringUtils.isBlank(entity.getSessionId())){
                entity.setSessionId(UUID.randomUUID().toString().replace("-",""));
            }
            this.sessionId=entity.getSessionId();
            if(entity.getModelId()!=null){
                ChatModel chatModel=chatModelService.selectChatModelById(entity.getModelId());
                if(chatModel!=null){
                    Message modeMessage = Message.builder().content(chatModel.getContent()).role(Message.Role.USER.getValue()).build();
                    modelName=chatModel.getName();
                    messages.add(modeMessage);
                }
            }
            Message currentMessage = Message.builder().content(entity.getSendText()).role(Message.Role.USER.getValue()).build();
            messages.add(currentMessage);
            //
            ChatSession chatSession=new ChatSession(this.uid,entity.getSessionId(),entity.getModelId());
            chatSessionService.insertChatSession(chatSession);
        }else{
            if(StringUtils.isNotEmpty(entity.getSessionId()) &&  !this.sessionId.equals(entity.getSessionId())){
                //不是同一个sessionId，说明是从历史页面进来的，要重新加载message
                List<ChatAnswer> answers=chatAnswerService.selectChatAnswerBySessionId(entity.getSessionId());
                if(answers!=null){
                    if(answers.size()>=10){
                        answers=answers.subList(0,10);
                    }
                    for (ChatAnswer answer:answers
                    ) {
                        Message oldMessage = Message.builder().content(answer.getQuestion()).role(answer.getQuestionFrom().equals("我")?Message.Role.USER.getValue():Message.Role.ASSISTANT.getValue()).build();
                        messages.add(oldMessage);
                    }
                    LocalCache.CACHE.put(uid, JSONUtil.toJsonStr(messages), LocalCache.TIMEOUT);
                }
                this.sessionId=entity.getSessionId();
            }else{
                String messageContext = (String) LocalCache.CACHE.get(uid);
                if (StrUtil.isNotBlank(messageContext)) {
                    messages = JSONUtil.toList(messageContext, Message.class);
                    if (messages.size() >= 10) {
                        messages = messages.subList(1, 10);
                    }

                }
            }
            Message currentMessage = Message.builder().content(entity.getSendText()).role(Message.Role.USER.getValue()).build();
            messages.add(currentMessage);

        }
        ChatAnswer chatAnswer=new ChatAnswer(this.uid,this.sessionId,entity.getSendText(),entity.getQuestionFrom());
        chatAnswerService.insertChatAnswer(chatAnswer);
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(messages)
                .build();
        chatGPTUtil.getChatGPTStream().streamChatCompletion(chatCompletion, eventSourceListener);
//        ChatAnswer chatAnswer2=new ChatAnswer(this.uid,this.sessionId,messages.get(messages.size()-1).getContent(),entity.getAnswerFrom());
//        chatAnswerService.insertChatAnswer(chatAnswer2);
        LocalCache.CACHE.put(uid, JSONUtil.toJsonStr(messages), LocalCache.TIMEOUT);
        //这里要保存数据库
    }


    /**
     * 获取当前连接数
     *
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 当前连接数加一
     */
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    /**
     * 当前连接数减一
     */
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}

