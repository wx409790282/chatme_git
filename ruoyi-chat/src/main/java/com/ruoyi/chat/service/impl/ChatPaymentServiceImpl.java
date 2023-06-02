package com.ruoyi.chat.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.domain.ChatCharge;
import com.ruoyi.chat.domain.ChatPayment;
import com.ruoyi.chat.mapper.ChatPaymentMapper;
import com.ruoyi.chat.service.IChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatPaymentService;

/**
 * 商品类型Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatPaymentServiceImpl implements IChatPaymentService 
{
    @Autowired
    private ChatPaymentMapper chatPaymentMapper;
    @Autowired
    private IChatUserService chatUserService;
    /**
     * 查询商品类型
     * 
     * @param id 商品类型主键
     * @return 商品类型
     */
    @Override
    public ChatPayment selectChatPaymentById(Long id)
    {
        return chatPaymentMapper.selectChatPaymentById(id);
    }

    /**
     * 查询商品类型列表
     * 
     * @param chatPayment 商品类型
     * @return 商品类型
     */
    @Override
    public List<ChatPayment> selectChatPaymentList(ChatPayment chatPayment)
    {
        return chatPaymentMapper.selectChatPaymentList(chatPayment);
    }

    /**
     * 新增商品类型
     * 
     * @param chatPayment 商品类型
     * @return 结果
     */
    @Override
    public int insertChatPayment(ChatPayment chatPayment)
    {
        return chatPaymentMapper.insertChatPayment(chatPayment);
    }

    /**
     * 修改商品类型
     * 
     * @param chatPayment 商品类型
     * @return 结果
     */
    @Override
    public int updateChatPayment(ChatPayment chatPayment)
    {
        return chatPaymentMapper.updateChatPayment(chatPayment);
    }

    @Override
    public boolean updateUserByPayment(Long id)
    {
        LambdaQueryWrapper<ChatPayment> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatPayment::getId,id);
        ChatPayment payment=chatPaymentMapper.selectOne(lambdaQueryWrapper);
        if(payment==null){
            return false;
        }else{
            boolean flag=chatUserService.updateChatUserByPayment(payment.getCount());
            return flag;
        }

    }

    /**
     * 批量删除商品类型
     * 
     * @param ids 需要删除的商品类型主键
     * @return 结果
     */
    @Override
    public int deleteChatPaymentByIds(Long[] ids)
    {
        return chatPaymentMapper.deleteChatPaymentByIds(ids);
    }

    /**
     * 删除商品类型信息
     * 
     * @param id 商品类型主键
     * @return 结果
     */
    @Override
    public int deleteChatPaymentById(Long id)
    {
        return chatPaymentMapper.deleteChatPaymentById(id);
    }
}
