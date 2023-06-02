package com.ruoyi.gpt.utils;


import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.listener.ConsoleStreamListener;
import com.plexpt.chatgpt.util.Proxys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.net.Proxy;
import java.util.Arrays;
import java.util.EventListener;

@Slf4j
@Component
public class ChatGPTUtil {
    @Value("${spring.openai.secret_key}")
    private String token;

    private ChatGPT chatGPT;
    private ChatGPTStream chatGPTStream;

    @Value("${spring.openai.ip}")
    private String proxyIp;
    @Value("${spring.openai.port}")
    private Integer proxyPort;

    @PostConstruct
    public void init(){
        if(!StringUtils.isEmpty(proxyIp)){
            //如果在国内访问，使用这个,在application.yml里面配置
            Proxy proxy = Proxys.http(proxyIp, proxyPort);
//            chatGPT = ChatGPT.builder()
//                    .apiKey(token)
//                    .timeout(600)
//                    .proxy(proxy)
//                    .apiHost("https://api.openai.com/") //代理地址
//                    .build()
//                    .init();
            chatGPTStream = ChatGPTStream.builder()
                    .timeout(600)
                    .apiKey(token)
                    .proxy(proxy)
                    .apiHost("https://api.openai.com/")
                    .build()
                    .init();
        }else{
//            chatGPT = ChatGPT.builder()
//                    .apiKey(token)
//                    .timeout(600)
//                    .apiHost("https://api.openai.com/") //代理地址
//                    .build()
//                    .init();
            chatGPTStream = ChatGPTStream.builder()
                    .timeout(600)
                    .apiKey(token)
                    .apiHost("https://api.openai.com/")
                    .build()
                    .init();
        }

    }
    public Message chat(String userMessage, String user) {
        Message message = Message.of(userMessage);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .user(user)
                .messages(Arrays.asList(message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();
        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
        return response.getChoices().get(0).getMessage();
    }

    public ChatGPTStream getChatGPTStream() {
        return chatGPTStream;
    }

    public Message chatStream(String userMessage, String user) {
        ConsoleStreamListener consoleStreamListener=new ConsoleStreamListener();
        Message message = Message.of(userMessage);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_4.getName())
                .user(user)
                .messages(Arrays.asList(message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();
        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
//        chatGPTStream.streamChatCompletion(chatCompletion, consoleStreamListener);
        return response.getChoices().get(0).getMessage();
    }
}
