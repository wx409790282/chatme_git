package com.ruoyi.chat.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会话对象 chat_session
 * 
 * @author wangxi
 * @date 2023-05-22
 */
public class ChatSession extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户 */
    @Excel(name = "用户")
    private String userId;

    /** 问题序号 */
    @Excel(name = "问题序号")
    private String seq;

    /** 对应模型 */
    @Excel(name = "对应模型")
    private Long modelId;
    public ChatSession(){

    }
    public ChatSession(String userId, String seq, Long modelId) {
        this.userId = userId;
        this.seq = seq;
        this.modelId = modelId;
    }

    /** 提问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提问时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 回答时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回答时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setSeq(String seq) 
    {
        this.seq = seq;
    }

    public String getSeq() 
    {
        return seq;
    }
    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("seq", getSeq())
            .append("modelId", getModelId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
