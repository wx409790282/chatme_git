package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatAnswer;

/**
 * 问答Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatAnswerService 
{
    /**
     * 查询问答
     * 
     * @param id 问答主键
     * @return 问答
     */
    public ChatAnswer selectChatAnswerById(Long id);
    public ChatAnswer selectRecentChatAnswerBySession(String sessionId);

    /**
     * 查询问答列表
     * 
     * @param chatAnswer 问答
     * @return 问答集合
     */
    public List<ChatAnswer> selectChatAnswerList(ChatAnswer chatAnswer);
    public List<ChatAnswer> selectChatAnswerByUserId(Long UserId);
    public List<ChatAnswer> selectChatAnswerBySessionId(String sessionId);

    /**
     * 新增问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    public int insertChatAnswer(ChatAnswer chatAnswer);

    /**
     * 修改问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    public int updateChatAnswer(ChatAnswer chatAnswer);

    /**
     * 批量删除问答
     * 
     * @param ids 需要删除的问答主键集合
     * @return 结果
     */
    public int deleteChatAnswerByIds(Long[] ids);

    /**
     * 删除问答信息
     * 
     * @param id 问答主键
     * @return 结果
     */
    public int deleteChatAnswerById(Long id);
}
