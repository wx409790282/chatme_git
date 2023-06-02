package com.ruoyi.chat.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * chatgpt秘钥管理对象 chat_keys
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public class ChatKeys extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 秘钥 */
    @Excel(name = "秘钥")
    private String secret;

    /** 状态（0不可用 1可用） */
    @Excel(name = "状态", readConverterExp = "0=不可用,1=可用")
    private Integer status;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date optTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSecret(String secret) 
    {
        this.secret = secret;
    }

    public String getSecret() 
    {
        return secret;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setOptTime(Date optTime) 
    {
        this.optTime = optTime;
    }

    public Date getOptTime() 
    {
        return optTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("secret", getSecret())
            .append("status", getStatus())
            .append("optTime", getOptTime())
            .toString();
    }
}
