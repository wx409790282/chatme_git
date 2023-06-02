package com.ruoyi.gpt.entity;


import cn.hutool.core.date.DateTime;
import com.plexpt.chatgpt.entity.chat.Message;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.List;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-10
 */
@Data
public class ChatEntity {

    private String questionFrom;
    private String answerFrom;
    private String sendText;
    private String createTime;
    private String updateTime;
    private int chatmState=0;
    private int TextType=0;
    private boolean status;
    private String sessionId ;
    private Long modelId ;
    private Long promotId ;
    private String modelDes;
}
