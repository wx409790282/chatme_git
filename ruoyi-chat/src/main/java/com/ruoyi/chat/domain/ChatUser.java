package com.ruoyi.chat.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户余额对象 chat_user
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public class ChatUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 累计充值 */
    @Excel(name = "累计充值")
    private BigDecimal totalCharge;

    /** 上次充值时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次充值时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastCharge;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setTotalCharge(BigDecimal totalCharge) 
    {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalCharge() 
    {
        return totalCharge;
    }
    public void setLastCharge(Date lastCharge) 
    {
        this.lastCharge = lastCharge;
    }

    public Date getLastCharge() 
    {
        return lastCharge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("balance", getBalance())
            .append("totalCharge", getTotalCharge())
            .append("lastCharge", getLastCharge())
            .toString();
    }
}
