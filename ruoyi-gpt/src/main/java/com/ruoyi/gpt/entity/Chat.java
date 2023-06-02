package com.ruoyi.gpt.entity;


import com.plexpt.chatgpt.entity.chat.Message;
import lombok.Data;

import java.util.List;
/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-10
 */
@Data
public class Chat {

    private String uid;

    private List<Message> message;
}
