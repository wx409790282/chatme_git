package com.ruoyi.chat.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.domain.ChatPromotsContent;
import com.ruoyi.chat.mapper.ChatPromotsContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatPromotsContentService;

/**
 * 提示词Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatPromotsContentServiceImpl implements IChatPromotsContentService 
{
    @Autowired
    private ChatPromotsContentMapper chatPromotsContentMapper;

    /**
     * 查询提示词
     * 
     * @param id 提示词主键
     * @return 提示词
     */
    @Override
    public ChatPromotsContent selectChatPromotsContentById(Long id)
    {
        return chatPromotsContentMapper.selectChatPromotsContentById(id);
    }

    /**
     * 查询提示词列表
     * 
     * @param chatPromotsContent 提示词
     * @return 提示词
     */
    @Override
    public List<ChatPromotsContent> selectChatPromotsContentList(ChatPromotsContent chatPromotsContent)
    {
        return chatPromotsContentMapper.selectChatPromotsContentList(chatPromotsContent);
    }

    @Override
    public List<ChatPromotsContent> selectChatPromotsContentByModel(Long id)
    {
        LambdaQueryWrapper<ChatPromotsContent> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatPromotsContent::getCategory,id);
        return chatPromotsContentMapper.selectList(lambdaQueryWrapper);
    }

    /**
     * 新增提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    @Override
    public int insertChatPromotsContent(ChatPromotsContent chatPromotsContent)
    {
        return chatPromotsContentMapper.insertChatPromotsContent(chatPromotsContent);
    }

    /**
     * 修改提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    @Override
    public int updateChatPromotsContent(ChatPromotsContent chatPromotsContent)
    {
        return chatPromotsContentMapper.updateChatPromotsContent(chatPromotsContent);
    }

    /**
     * 批量删除提示词
     * 
     * @param ids 需要删除的提示词主键
     * @return 结果
     */
    @Override
    public int deleteChatPromotsContentByIds(Long[] ids)
    {
        return chatPromotsContentMapper.deleteChatPromotsContentByIds(ids);
    }

    /**
     * 删除提示词信息
     * 
     * @param id 提示词主键
     * @return 结果
     */
    @Override
    public int deleteChatPromotsContentById(Long id)
    {
        return chatPromotsContentMapper.deleteChatPromotsContentById(id);
    }
}
