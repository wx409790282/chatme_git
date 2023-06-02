package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatPayment;
import com.ruoyi.chat.domain.ChatUser;

/**
 * 用户余额Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatUserService 
{
    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    public ChatUser selectChatUserById(Long id);
    public ChatUser selectChatUserByUserid(Long username);

    /**
     * 查询用户余额列表
     * 
     * @param chatUser 用户余额
     * @return 用户余额集合
     */
    public List<ChatUser> selectChatUserList(ChatUser chatUser);

    /**
     * 新增用户余额
     * 
     * @param chatUser 用户余额
     * @return 结果
     */
    public int insertChatUser(ChatUser chatUser);

    /**
     * 修改用户余额
     * 
     * @param chatUser 用户余额
     * @return 结果
     */
    public int updateChatUser(ChatUser chatUser);
    public boolean updateChatUserByPayment(int count);

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的用户余额主键集合
     * @return 结果
     */
    public int deleteChatUserByIds(Long[] ids);

    /**
     * 删除用户余额信息
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    public int deleteChatUserById(Long id);
}
