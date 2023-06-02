package com.ruoyi.chat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 礼包兑换码对象 chat_charge
 * 
 * @author wangxi
 * @date 2023-05-10
 */
public class ChatCharge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long payId;

    /** 秘钥 */
    @Excel(name = "秘钥")
    private String secret;

    /** 状态（0为可用 1为已用） */
    @Excel(name = "状态", readConverterExp = "0=为可用,1=为已用")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPayId(Long payId)
    {
        this.payId = payId;
    }

    public Long getPayId()
    {
        return payId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("payId", getPayId())
            .append("secret", getSecret())
            .append("status", getStatus())
            .toString();
    }
}
