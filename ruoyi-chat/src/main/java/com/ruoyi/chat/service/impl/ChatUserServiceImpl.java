package com.ruoyi.chat.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.chat.domain.ChatPayment;
import com.ruoyi.chat.domain.ChatUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.mapper.ChatUserMapper;
import com.ruoyi.chat.service.IChatUserService;

/**
 * 用户余额Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatUserServiceImpl implements IChatUserService 
{
    @Autowired
    private ChatUserMapper chatUserMapper;

    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    @Override
    public ChatUser selectChatUserById(Long id)
    {
        return chatUserMapper.selectChatUserById(id);
    }

    @Override
    public ChatUser selectChatUserByUserid(Long username)
    {
        LambdaQueryWrapper<ChatUser> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatUser::getUserId,username);
        ChatUser user=chatUserMapper.selectOne(lambdaQueryWrapper);
        if(user==null){
            ChatUser chatUser=new ChatUser();
            chatUser.setUserId(username);
            chatUserMapper.insertChatUser(chatUser);
            return chatUser;
        }else{
            return user;
        }
    }

    /**
     * 查询用户余额列表
     * 
     * @param chatUser 用户余额
     * @return 用户余额
     */
    @Override
    public List<ChatUser> selectChatUserList(ChatUser chatUser)
    {
        return chatUserMapper.selectChatUserList(chatUser);
    }

    /**
     * 新增用户余额
     * 
     * @param chatUser 用户余额
     * @return 结果
     */
    @Override
    public int insertChatUser(ChatUser chatUser)
    {
        return chatUserMapper.insertChatUser(chatUser);
    }

    /**
     * 修改用户余额
     * 
     * @param chatUser 用户余额
     * @return 结果
     */
    @Override
    public int updateChatUser(ChatUser chatUser)
    {
        return chatUserMapper.updateChatUser(chatUser);
    }
    @Override
    public boolean updateChatUserByPayment(int count)
    {
        Long userId= SecurityUtils.getUserId();
        LambdaQueryWrapper<ChatUser> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatUser::getUserId,userId);
        ChatUser user=chatUserMapper.selectOne(lambdaQueryWrapper);
        if(user==null){
            return false;
        }else{
            if(chatUserMapper.updateChatUserByPayment(user.getId(),count)==1){
                return true;
            }
            return false;
        }
    }

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的用户余额主键
     * @return 结果
     */
    @Override
    public int deleteChatUserByIds(Long[] ids)
    {
        return chatUserMapper.deleteChatUserByIds(ids);
    }

    /**
     * 删除用户余额信息
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    @Override
    public int deleteChatUserById(Long id)
    {
        return chatUserMapper.deleteChatUserById(id);
    }
}
