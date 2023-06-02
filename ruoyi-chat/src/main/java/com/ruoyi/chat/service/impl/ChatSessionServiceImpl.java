package com.ruoyi.chat.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.domain.ChatAnswer;
import com.ruoyi.chat.service.IChatAnswerService;
import com.ruoyi.chat.vo.ChatSessionWithModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.mapper.ChatSessionMapper;
import com.ruoyi.chat.domain.ChatSession;
import com.ruoyi.chat.service.IChatSessionService;

/**
 * 会话Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-11
 */
@Service
public class ChatSessionServiceImpl implements IChatSessionService 
{
    @Autowired
    private ChatSessionMapper chatSessionMapper;
    @Autowired
    private IChatAnswerService chatAnswerService;

    /**
     * 查询会话
     * 
     * @param id 会话主键
     * @return 会话
     */
    @Override
    public ChatSession selectChatSessionById(Long id)
    {
        return chatSessionMapper.selectChatSessionById(id);
    }

    /**
     * 查询会话列表
     * 
     * @param chatSession 会话
     * @return 会话
     */
    @Override
    public List<ChatSession> selectChatSessionList(ChatSession chatSession)
    {
        return chatSessionMapper.selectChatSessionList(chatSession);
    }@Override
    public List<ChatSessionWithModel> selectChatSessionsListByUserName(String userName)
    {
        List<ChatSessionWithModel> sessions=chatSessionMapper.selectChatSessionsListByUserName(userName);
        for (ChatSessionWithModel s:sessions
             ) {
            ChatAnswer answer=chatAnswerService.selectRecentChatAnswerBySession(s.getSeq());
            if(answer!=null){
                s.setQuestion(answer.getQuestion());
            }
        }
        return sessions;
    }

    /**
     * 新增会话
     * 
     * @param chatSession 会话
     * @return 结果
     */
    @Override
    public int insertChatSession(ChatSession chatSession)
    {
        return chatSessionMapper.insertChatSession(chatSession);
    }

    /**
     * 修改会话
     * 
     * @param chatSession 会话
     * @return 结果
     */
    @Override
    public int updateChatSession(ChatSession chatSession)
    {
        return chatSessionMapper.updateChatSession(chatSession);
    }

    /**
     * 批量删除会话
     * 
     * @param ids 需要删除的会话主键
     * @return 结果
     */
    @Override
    public int deleteChatSessionByIds(Long[] ids)
    {
        return chatSessionMapper.deleteChatSessionByIds(ids);
    }

    /**
     * 删除会话信息
     * 
     * @param id 会话主键
     * @return 结果
     */
    @Override
    public int deleteChatSessionById(Long id)
    {
        return chatSessionMapper.deleteChatSessionById(id);
    }
}
