package com.ruoyi.chat.service.impl;

import java.util.List;

import com.ruoyi.chat.domain.ChatBills;
import com.ruoyi.chat.mapper.ChatBillsMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.vo.ChatBillsWithPayment;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatBillsService;

/**
 * 充值记录Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatBillsServiceImpl implements IChatBillsService 
{
    @Autowired
    private ChatBillsMapper chatBillsMapper;

    /**
     * 查询充值记录
     * 
     * @param id 充值记录主键
     * @return 充值记录
     */
    @Override
    public ChatBills selectChatBillsById(Long id)
    {
        return chatBillsMapper.selectChatBillsById(id);
    }

    /**
     * 查询充值记录列表
     * 
     * @param chatBills 充值记录
     * @return 充值记录
     */
    @Override
    public List<ChatBills> selectChatBillsList(ChatBills chatBills)
    {
        return chatBillsMapper.selectChatBillsList(chatBills);
    }

    @Override
    public List<ChatBillsWithPayment> selectChatBillsListByUserId(Long userId)
    {
        LambdaQueryWrapper<ChatBills> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatBills::getUserId,userId).orderByDesc(ChatBills::getCreateTime);
        return chatBillsMapper.selectChatBillsWithPaymentList(userId);
    }

    /**
     * 新增充值记录
     * 
     * @param chatBills 充值记录
     * @return 结果
     */
    @Override
    public int insertChatBills(ChatBills chatBills)
    {
        chatBills.setCreateTime(DateUtils.getNowDate());
        return chatBillsMapper.insertChatBills(chatBills);
    }

    /**
     * 修改充值记录
     * 
     * @param chatBills 充值记录
     * @return 结果
     */
    @Override
    public int updateChatBills(ChatBills chatBills)
    {
        return chatBillsMapper.updateChatBills(chatBills);
    }

    /**
     * 批量删除充值记录
     * 
     * @param ids 需要删除的充值记录主键
     * @return 结果
     */
    @Override
    public int deleteChatBillsByIds(Long[] ids)
    {
        return chatBillsMapper.deleteChatBillsByIds(ids);
    }

    /**
     * 删除充值记录信息
     * 
     * @param id 充值记录主键
     * @return 结果
     */
    @Override
    public int deleteChatBillsById(Long id)
    {
        return chatBillsMapper.deleteChatBillsById(id);
    }
}
