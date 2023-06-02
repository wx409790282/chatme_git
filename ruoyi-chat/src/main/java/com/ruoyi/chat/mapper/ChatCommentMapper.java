package com.ruoyi.chat.mapper;

import java.util.List;
import com.ruoyi.chat.domain.ChatComment;

/**
 * 意见反馈Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-29
 */
public interface ChatCommentMapper 
{
    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    public ChatComment selectChatCommentById(Long id);

    /**
     * 查询意见反馈列表
     * 
     * @param chatComment 意见反馈
     * @return 意见反馈集合
     */
    public List<ChatComment> selectChatCommentList(ChatComment chatComment);

    /**
     * 新增意见反馈
     * 
     * @param chatComment 意见反馈
     * @return 结果
     */
    public int insertChatComment(ChatComment chatComment);

    /**
     * 修改意见反馈
     * 
     * @param chatComment 意见反馈
     * @return 结果
     */
    public int updateChatComment(ChatComment chatComment);

    /**
     * 删除意见反馈
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    public int deleteChatCommentById(Long id);

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatCommentByIds(Long[] ids);
}
