package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatUser;
import com.ruoyi.common.constant.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


/**
 * 用户余额Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface ChatUserMapper extends BaseMapper<ChatUser>
{
    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    public ChatUser selectChatUserById(Long id);

    /**
     * 查询用户余额列表
     * 
     * @param chatUser 用户余额
     * @return 用户余额集合
     */
    public List<ChatUser> selectChatUserList(ChatUser chatUser);

    @Update("update chat_user set balance=balance+ #{count} where id=#{id}")
    public int updateChatUserByPayment(@Param("id")Long id , @Param("count" )int count);
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

    /**
     * 删除用户余额
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    public int deleteChatUserById(Long id);

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatUserByIds(Long[] ids);
}
