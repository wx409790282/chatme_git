package com.ruoyi.chat.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品类型对象 chat_payment
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public class ChatPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal originAmount;

    /** 现价 */
    @Excel(name = "现价")
    private BigDecimal amount;

    /** 充值数量 */
    @Excel(name = "充值数量")
    private Integer count;

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    @Excel(name = "描述")
    private String describ;
    /** 状态（0不可用 1可用） */
    @Excel(name = "状态", readConverterExp = "0=不可用,1=可用")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOriginAmount(BigDecimal originAmount) 
    {
        this.originAmount = originAmount;
    }

    public BigDecimal getOriginAmount() 
    {
        return originAmount;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setCount(Integer count) 
    {
        this.count = count;
    }

    public Integer getCount() 
    {
        return count;
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
            .append("originAmount", getOriginAmount())
            .append("amount", getAmount())
            .append("count", getCount())
            .append("status", getStatus())
            .toString();
    }
}
