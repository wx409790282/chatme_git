package com.ruoyi.chat.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值记录对象 chat_bills
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public class ChatBills extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 充值商品 */
    @Excel(name = "充值商品")
    private Long paymentCategoryId;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;
    /** 状态（0未支付 1已支付 -1支付失败） */
    @Excel(name = "状态", readConverterExp = "0=未支付,1=已支付,-=1支付失败")
    private Integer status;

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
    public void setPaymentCategoryId(Long paymentCategoryId) 
    {
        this.paymentCategoryId = paymentCategoryId;
    }

    public Long getPaymentCategoryId() 
    {
        return paymentCategoryId;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
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
            .append("userId", getUserId())
            .append("paymentCategoryId", getPaymentCategoryId())
            .append("createTime", getCreateTime())
            .append("payTime", getPayTime())
            .append("status", getStatus())
            .toString();
    }
}
