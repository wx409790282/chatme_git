package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatSession;
import com.ruoyi.chat.vo.ChatSessionWithModel;

/**
 * 会话Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-11
 */
public interface ChatSessionMapper extends BaseMapper<ChatSession>
{
    /**
     * 查询会话
     * 
     * @param id 会话主键
     * @return 会话
     */
    public ChatSession selectChatSessionById(Long id);

    /**
     * 查询会话列表
     * 
     * @param chatSession 会话
     * @return 会话集合
     */
    public List<ChatSession> selectChatSessionList(ChatSession chatSession);
    public List<ChatSessionWithModel> selectChatSessionsListByUserName(String username);

    /**
     * 新增会话
     * 
     * @param chatSession 会话
     * @return 结果
     */
    public int insertChatSession(ChatSession chatSession);

    /**
     * 修改会话
     * 
     * @param chatSession 会话
     * @return 结果
     */
    public int updateChatSession(ChatSession chatSession);

    /**
     * 删除会话
     * 
     * @param id 会话主键
     * @return 结果
     */
    public int deleteChatSessionById(Long id);

    /**
     * 批量删除会话
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatSessionByIds(Long[] ids);
}
