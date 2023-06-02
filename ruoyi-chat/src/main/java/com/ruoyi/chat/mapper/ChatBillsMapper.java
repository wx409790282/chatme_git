package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatBills;
import com.ruoyi.chat.vo.ChatBillsWithPayment;

/**
 * 充值记录Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface ChatBillsMapper extends BaseMapper<ChatBills>
{
    /**
     * 查询充值记录
     * 
     * @param id 充值记录主键
     * @return 充值记录
     */
    public ChatBills selectChatBillsById(Long id);

    /**
     * 查询充值记录列表
     * 
     * @param chatBills 充值记录
     * @return 充值记录集合
     */
    public List<ChatBills> selectChatBillsList(ChatBills chatBills);

    public List<ChatBillsWithPayment> selectChatBillsWithPaymentList(Long userId);

    /**
     * 新增充值记录
     * 
     * @param chatBills 充值记录
     * @return 结果
     */
    public int insertChatBills(ChatBills chatBills);

    /**
     * 修改充值记录
     * 
     * @param chatBills 充值记录
     * @return 结果
     */
    public int updateChatBills(ChatBills chatBills);

    /**
     * 删除充值记录
     * 
     * @param id 充值记录主键
     * @return 结果
     */
    public int deleteChatBillsById(Long id);

    /**
     * 批量删除充值记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatBillsByIds(Long[] ids);
}
