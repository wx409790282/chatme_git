package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatPaymentSecrets;
import com.ruoyi.chat.domain.ChatPromotsCategory;

/**
 * 提示词种类Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface ChatPromotsCategoryMapper extends BaseMapper<ChatPromotsCategory>
{
    /**
     * 查询提示词种类
     * 
     * @param id 提示词种类主键
     * @return 提示词种类
     */
    public ChatPromotsCategory selectChatPromotsCategoryById(Long id);

    /**
     * 查询提示词种类列表
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 提示词种类集合
     */
    public List<ChatPromotsCategory> selectChatPromotsCategoryList(ChatPromotsCategory chatPromotsCategory);

    /**
     * 新增提示词种类
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 结果
     */
    public int insertChatPromotsCategory(ChatPromotsCategory chatPromotsCategory);

    /**
     * 修改提示词种类
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 结果
     */
    public int updateChatPromotsCategory(ChatPromotsCategory chatPromotsCategory);

    /**
     * 删除提示词种类
     * 
     * @param id 提示词种类主键
     * @return 结果
     */
    public int deleteChatPromotsCategoryById(Long id);

    /**
     * 批量删除提示词种类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatPromotsCategoryByIds(Long[] ids);
}
