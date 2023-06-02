package com.ruoyi.chat.vo;

import com.ruoyi.chat.domain.ChatBills;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChatBillsWithPayment extends ChatBills {
    @Excel(name = "现价")
    private BigDecimal amount;

    /** 充值数量 */
    @Excel(name = "充值数量")
    private Integer count;
    private String describ;
}
