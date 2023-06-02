package com.ruoyi.chat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.mapper.ChatCommentMapper;
import com.ruoyi.chat.domain.ChatComment;
import com.ruoyi.chat.service.IChatCommentService;

/**
 * 意见反馈Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-29
 */
@Service
public class ChatCommentServiceImpl implements IChatCommentService 
{
    @Autowired
    private ChatCommentMapper chatCommentMapper;

    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    @Override
    public ChatComment selectChatCommentById(Long id)
    {
        return chatCommentMapper.selectChatCommentById(id);
    }

    /**
     * 查询意见反馈列表
     * 
     * @param chatComment 意见反馈
     * @return 意见反馈
     */
    @Override
    public List<ChatComment> selectChatCommentList(ChatComment chatComment)
    {
        return chatCommentMapper.selectChatCommentList(chatComment);
    }

    /**
     * 新增意见反馈
     * 
     * @param chatComment 意见反馈
     * @return 结果
     */
    @Override
    public int insertChatComment(ChatComment chatComment)
    {
        return chatCommentMapper.insertChatComment(chatComment);
    }

    /**
     * 修改意见反馈
     * 
     * @param chatComment 意见反馈
     * @return 结果
     */
    @Override
    public int updateChatComment(ChatComment chatComment)
    {
        return chatCommentMapper.updateChatComment(chatComment);
    }

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteChatCommentByIds(Long[] ids)
    {
        return chatCommentMapper.deleteChatCommentByIds(ids);
    }

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteChatCommentById(Long id)
    {
        return chatCommentMapper.deleteChatCommentById(id);
    }
}
