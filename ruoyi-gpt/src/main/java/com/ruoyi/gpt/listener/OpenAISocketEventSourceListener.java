package com.ruoyi.gpt.listener;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import com.ruoyi.chat.domain.ChatAnswer;
import com.ruoyi.gpt.config.LocalCache;
import com.ruoyi.gpt.entity.ChatEntity;
import com.ruoyi.gpt.websocket.WebSocketServer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述：OpenAI流式输出Socket接收
 *
 * @author https:www.unfbx.com
 * @date 2023-03-23
 */
@Slf4j
public class OpenAISocketEventSourceListener extends EventSourceListener {

    private Session session;
    private WebSocketServer webSocketServer;
    private String msg="";
    private StringBuilder sb=new StringBuilder();

    public OpenAISocketEventSourceListener(WebSocketServer webSocketServer) {
        this.webSocketServer = webSocketServer;
        this.session=webSocketServer.getSession();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI建立sse连接...");
    }

    /**
     * {@inheritDoc}
     */
    @SneakyThrows
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI返回数据：{}", data);
        if (data.equals("[DONE]")) {
            log.info("OpenAI返回数据结束了");
            session.getBasicRemote().sendText("[DONE]");
            String messageContext = (String) LocalCache.CACHE.get(this.webSocketServer.getUid());
            List<Message> messages = new ArrayList<>();
            if (StrUtil.isNotBlank(messageContext)) {
                messages = JSONUtil.toList(messageContext, Message.class);
                Message currentMessage = Message.builder().content(sb.toString()).role(Message.Role.ASSISTANT.getValue()).build();
                messages.add(currentMessage);
            } else {
                Message currentMessage = Message.builder().content(sb.toString()).role(Message.Role.ASSISTANT.getValue()).build();
                messages.add(currentMessage);
            }
            ChatAnswer chatAnswer2=new ChatAnswer(this.webSocketServer.getUid(),this.webSocketServer.getSessionId(),sb.toString(),this.webSocketServer.getModelName());
            WebSocketServer.chatAnswerService.insertChatAnswer(chatAnswer2);
            LocalCache.CACHE.put(this.webSocketServer.getUid(), JSONUtil.toJsonStr(messages), LocalCache.TIMEOUT);
            sb=new StringBuilder();
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class); // 读取Json
        String delta = mapper.writeValueAsString(completionResponse.getChoices().get(0).getDelta());
        JSONObject jsonObject=JSON.parseObject(delta);
        if(jsonObject!=null && jsonObject.get("content")!=null && !jsonObject.get("content").equals("null")){
            sb.append(jsonObject.get("content"));
        }
        session.getBasicRemote().sendText(delta);
    }


    @Override
    public void onClosed(EventSource eventSource) {
        log.info("OpenAI关闭sse连接...");
    }


    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", body.string(), t);

        } else {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", response, t);

        }
        session.getBasicRemote().sendText(body.toString());
        eventSource.cancel();
    }
}
