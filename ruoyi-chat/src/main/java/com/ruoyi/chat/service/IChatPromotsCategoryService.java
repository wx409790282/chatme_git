package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatPromotsCategory;

/**
 * 提示词种类Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatPromotsCategoryService 
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
     * 批量删除提示词种类
     * 
     * @param ids 需要删除的提示词种类主键集合
     * @return 结果
     */
    public int deleteChatPromotsCategoryByIds(Long[] ids);

    /**
     * 删除提示词种类信息
     * 
     * @param id 提示词种类主键
     * @return 结果
     */
    public int deleteChatPromotsCategoryById(Long id);
}
