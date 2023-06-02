package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatPayment;

/**
 * 商品类型Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatPaymentService 
{
    /**
     * 查询商品类型
     * 
     * @param id 商品类型主键
     * @return 商品类型
     */
    public ChatPayment selectChatPaymentById(Long id);

    /**
     * 查询商品类型列表
     * 
     * @param chatPayment 商品类型
     * @return 商品类型集合
     */
    public List<ChatPayment> selectChatPaymentList(ChatPayment chatPayment);

    /**
     * 新增商品类型
     * 
     * @param chatPayment 商品类型
     * @return 结果
     */
    public int insertChatPayment(ChatPayment chatPayment);

    /**
     * 修改商品类型
     * 
     * @param chatPayment 商品类型
     * @return 结果
     */
    public int updateChatPayment(ChatPayment chatPayment);
    public boolean updateUserByPayment(Long id);

    /**
     * 批量删除商品类型
     * 
     * @param ids 需要删除的商品类型主键集合
     * @return 结果
     */
    public int deleteChatPaymentByIds(Long[] ids);

    /**
     * 删除商品类型信息
     * 
     * @param id 商品类型主键
     * @return 结果
     */
    public int deleteChatPaymentById(Long id);
}
