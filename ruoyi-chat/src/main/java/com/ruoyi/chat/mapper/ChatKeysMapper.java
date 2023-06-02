package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatKeys;
import com.ruoyi.chat.domain.ChatPaymentSecrets;

/**
 * chatgpt秘钥管理Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface ChatKeysMapper extends BaseMapper<ChatKeys>
{
    /**
     * 查询chatgpt秘钥管理
     * 
     * @param id chatgpt秘钥管理主键
     * @return chatgpt秘钥管理
     */
    public ChatKeys selectChatKeysById(Long id);

    /**
     * 查询chatgpt秘钥管理列表
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return chatgpt秘钥管理集合
     */
    public List<ChatKeys> selectChatKeysList(ChatKeys chatKeys);

    /**
     * 新增chatgpt秘钥管理
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return 结果
     */
    public int insertChatKeys(ChatKeys chatKeys);

    /**
     * 修改chatgpt秘钥管理
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return 结果
     */
    public int updateChatKeys(ChatKeys chatKeys);

    /**
     * 删除chatgpt秘钥管理
     * 
     * @param id chatgpt秘钥管理主键
     * @return 结果
     */
    public int deleteChatKeysById(Long id);

    /**
     * 批量删除chatgpt秘钥管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatKeysByIds(Long[] ids);
}
