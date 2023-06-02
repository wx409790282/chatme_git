package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatPromotsContent;

/**
 * 提示词Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatPromotsContentService 
{
    /**
     * 查询提示词
     * 
     * @param id 提示词主键
     * @return 提示词
     */
    public ChatPromotsContent selectChatPromotsContentById(Long id);

    /**
     * 查询提示词列表
     * 
     * @param chatPromotsContent 提示词
     * @return 提示词集合
     */
    public List<ChatPromotsContent> selectChatPromotsContentList(ChatPromotsContent chatPromotsContent);

    public List<ChatPromotsContent> selectChatPromotsContentByModel(Long id);

    /**
     * 新增提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    public int insertChatPromotsContent(ChatPromotsContent chatPromotsContent);

    /**
     * 修改提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    public int updateChatPromotsContent(ChatPromotsContent chatPromotsContent);

    /**
     * 批量删除提示词
     * 
     * @param ids 需要删除的提示词主键集合
     * @return 结果
     */
    public int deleteChatPromotsContentByIds(Long[] ids);

    /**
     * 删除提示词信息
     * 
     * @param id 提示词主键
     * @return 结果
     */
    public int deleteChatPromotsContentById(Long id);
}
