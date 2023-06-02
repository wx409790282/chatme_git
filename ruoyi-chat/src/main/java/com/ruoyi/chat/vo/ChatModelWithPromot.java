package com.ruoyi.chat.vo;

import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.domain.ChatPromotsContent;
import lombok.Data;

import java.util.List;
@Data
public class ChatModelWithPromot extends ChatModel {

    List<ChatPromotsContent> list;
}
