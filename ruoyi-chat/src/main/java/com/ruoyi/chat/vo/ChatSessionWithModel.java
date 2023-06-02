package com.ruoyi.chat.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.chat.domain.ChatSession;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 会话对象 chat_session
 * 
 * @author wangxi
 * @date 2023-05-22
 */
@Data
public class ChatSessionWithModel extends ChatSession
{
    private String name;

    /** 图片 */
    @Excel(name = "图片")
    private String img;
    private String question;
}
