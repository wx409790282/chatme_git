package com.ruoyi.chat.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.service.IChatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.mapper.ChatChargeMapper;
import com.ruoyi.chat.domain.ChatCharge;
import com.ruoyi.chat.service.IChatChargeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 礼包兑换码Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-10
 */
@Service
public class ChatChargeServiceImpl implements IChatChargeService 
{
    @Autowired
    private ChatChargeMapper chatChargeMapper;
    @Autowired
    private IChatPaymentService chatPaymentService;
    /**
     * 查询礼包兑换码
     * 
     * @param id 礼包兑换码主键
     * @return 礼包兑换码
     */
    @Override
    public ChatCharge selectChatChargeById(Long id)
    {
        return chatChargeMapper.selectChatChargeById(id);
    }

    /**
     * 查询礼包兑换码列表
     * 
     * @param chatCharge 礼包兑换码
     * @return 礼包兑换码
     */
    @Override
    public List<ChatCharge> selectChatChargeList(ChatCharge chatCharge)
    {
        return chatChargeMapper.selectChatChargeList(chatCharge);
    }

    /**
     * 新增礼包兑换码
     * 
     * @param chatCharge 礼包兑换码
     * @return 结果
     */
    @Override
    public int insertChatCharge(ChatCharge chatCharge)
    {
        return chatChargeMapper.insertChatCharge(chatCharge);
    }

    /**
     * 修改礼包兑换码
     * 
     * @param chatCharge 礼包兑换码
     * @return 结果
     */
    @Override
    public int updateChatCharge(ChatCharge chatCharge)
    {
        return chatChargeMapper.updateChatCharge(chatCharge);
    }

    @Transactional
    @Override
    public int useCharge(ChatCharge chatCharge)
    {
        LambdaQueryWrapper<ChatCharge> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatCharge::getSecret,chatCharge.getSecret()).eq(ChatCharge::getStatus,0);
        ChatCharge chatCharge1=chatChargeMapper.selectOne(lambdaQueryWrapper);
        if(chatCharge1==null){
            return 0;
        }else{
            if(chatPaymentService.updateUserByPayment(chatCharge1.getPayId())){
                chatCharge1.setStatus(1);
                chatChargeMapper.updateChatCharge(chatCharge1);
                return 1;
            }
        }
        return 0;
    }

    /**
     * 批量删除礼包兑换码
     * 
     * @param ids 需要删除的礼包兑换码主键
     * @return 结果
     */
    @Override
    public int deleteChatChargeByIds(Long[] ids)
    {
        return chatChargeMapper.deleteChatChargeByIds(ids);
    }

    /**
     * 删除礼包兑换码信息
     * 
     * @param id 礼包兑换码主键
     * @return 结果
     */
    @Override
    public int deleteChatChargeById(Long id)
    {
        return chatChargeMapper.deleteChatChargeById(id);
    }
}
