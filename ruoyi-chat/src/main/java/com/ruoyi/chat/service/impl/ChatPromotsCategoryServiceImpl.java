package com.ruoyi.chat.service.impl;

import java.util.List;

import com.ruoyi.chat.domain.ChatPromotsCategory;
import com.ruoyi.chat.mapper.ChatPromotsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatPromotsCategoryService;

/**
 * 提示词种类Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatPromotsCategoryServiceImpl implements IChatPromotsCategoryService 
{
    @Autowired
    private ChatPromotsCategoryMapper chatPromotsCategoryMapper;

    /**
     * 查询提示词种类
     * 
     * @param id 提示词种类主键
     * @return 提示词种类
     */
    @Override
    public ChatPromotsCategory selectChatPromotsCategoryById(Long id)
    {
        return chatPromotsCategoryMapper.selectChatPromotsCategoryById(id);
    }

    /**
     * 查询提示词种类列表
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 提示词种类
     */
    @Override
    public List<ChatPromotsCategory> selectChatPromotsCategoryList(ChatPromotsCategory chatPromotsCategory)
    {
        return chatPromotsCategoryMapper.selectChatPromotsCategoryList(chatPromotsCategory);
    }

    /**
     * 新增提示词种类
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 结果
     */
    @Override
    public int insertChatPromotsCategory(ChatPromotsCategory chatPromotsCategory)
    {
        return chatPromotsCategoryMapper.insertChatPromotsCategory(chatPromotsCategory);
    }

    /**
     * 修改提示词种类
     * 
     * @param chatPromotsCategory 提示词种类
     * @return 结果
     */
    @Override
    public int updateChatPromotsCategory(ChatPromotsCategory chatPromotsCategory)
    {
        return chatPromotsCategoryMapper.updateChatPromotsCategory(chatPromotsCategory);
    }

    /**
     * 批量删除提示词种类
     * 
     * @param ids 需要删除的提示词种类主键
     * @return 结果
     */
    @Override
    public int deleteChatPromotsCategoryByIds(Long[] ids)
    {
        return chatPromotsCategoryMapper.deleteChatPromotsCategoryByIds(ids);
    }

    /**
     * 删除提示词种类信息
     * 
     * @param id 提示词种类主键
     * @return 结果
     */
    @Override
    public int deleteChatPromotsCategoryById(Long id)
    {
        return chatPromotsCategoryMapper.deleteChatPromotsCategoryById(id);
    }
}
