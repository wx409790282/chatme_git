package com.ruoyi.chat.service.impl;

import java.util.List;

import com.ruoyi.chat.domain.ChatAnswer;
import com.ruoyi.chat.mapper.ChatAnswerMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatAnswerService;

/**
 * 问答Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatAnswerServiceImpl implements IChatAnswerService 
{
    @Autowired
    private ChatAnswerMapper chatAnswerMapper;

    /**
     * 查询问答
     * 
     * @param id 问答主键
     * @return 问答
     */
    @Override
    public ChatAnswer selectChatAnswerById(Long id)
    {
        return chatAnswerMapper.selectChatAnswerById(id);
    }
    @Override
    public ChatAnswer selectRecentChatAnswerBySession(String sessionId)
    {
        LambdaQueryWrapper<ChatAnswer> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatAnswer::getSessionId,sessionId).orderByDesc(ChatAnswer::getQuestionTime);
        lambdaQueryWrapper.last(" limit 1 ");
        return chatAnswerMapper.selectOne(lambdaQueryWrapper);
    }

    /**
     * 查询问答列表
     * 
     * @param chatAnswer 问答
     * @return 问答
     */
    @Override
    public List<ChatAnswer> selectChatAnswerList(ChatAnswer chatAnswer)
    {
        return chatAnswerMapper.selectChatAnswerList(chatAnswer);
    }
    @Override
    public List<ChatAnswer> selectChatAnswerByUserId(Long userId)
    {
        LambdaQueryWrapper<ChatAnswer> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatAnswer::getUserId,userId).orderByDesc(ChatAnswer::getQuestionTime);
        return chatAnswerMapper.selectList(lambdaQueryWrapper);
    }
    @Override
    public List<ChatAnswer> selectChatAnswerBySessionId(String sessionId)
    {
        LambdaQueryWrapper<ChatAnswer> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatAnswer::getSessionId,sessionId).orderByDesc(ChatAnswer::getQuestionTime);
        return chatAnswerMapper.selectList(lambdaQueryWrapper);
    }

    /**
     * 新增问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    @Override
    public int insertChatAnswer(ChatAnswer chatAnswer)
    {
        return chatAnswerMapper.insertChatAnswer(chatAnswer);
    }

    /**
     * 修改问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    @Override
    public int updateChatAnswer(ChatAnswer chatAnswer)
    {
        return chatAnswerMapper.updateChatAnswer(chatAnswer);
    }

    /**
     * 批量删除问答
     * 
     * @param ids 需要删除的问答主键
     * @return 结果
     */
    @Override
    public int deleteChatAnswerByIds(Long[] ids)
    {
        return chatAnswerMapper.deleteChatAnswerByIds(ids);
    }

    /**
     * 删除问答信息
     * 
     * @param id 问答主键
     * @return 结果
     */
    @Override
    public int deleteChatAnswerById(Long id)
    {
        return chatAnswerMapper.deleteChatAnswerById(id);
    }
}
