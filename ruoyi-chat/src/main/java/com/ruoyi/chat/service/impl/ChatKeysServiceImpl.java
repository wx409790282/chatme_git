package com.ruoyi.chat.service.impl;

import java.util.List;

import com.ruoyi.chat.domain.ChatKeys;
import com.ruoyi.chat.mapper.ChatKeysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatKeysService;

/**
 * chatgpt秘钥管理Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatKeysServiceImpl implements IChatKeysService 
{
    @Autowired
    private ChatKeysMapper chatKeysMapper;

    /**
     * 查询chatgpt秘钥管理
     * 
     * @param id chatgpt秘钥管理主键
     * @return chatgpt秘钥管理
     */
    @Override
    public ChatKeys selectChatKeysById(Long id)
    {
        return chatKeysMapper.selectChatKeysById(id);
    }

    /**
     * 查询chatgpt秘钥管理列表
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return chatgpt秘钥管理
     */
    @Override
    public List<ChatKeys> selectChatKeysList(ChatKeys chatKeys)
    {
        return chatKeysMapper.selectChatKeysList(chatKeys);
    }

    /**
     * 新增chatgpt秘钥管理
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return 结果
     */
    @Override
    public int insertChatKeys(ChatKeys chatKeys)
    {
        return chatKeysMapper.insertChatKeys(chatKeys);
    }

    /**
     * 修改chatgpt秘钥管理
     * 
     * @param chatKeys chatgpt秘钥管理
     * @return 结果
     */
    @Override
    public int updateChatKeys(ChatKeys chatKeys)
    {
        return chatKeysMapper.updateChatKeys(chatKeys);
    }

    /**
     * 批量删除chatgpt秘钥管理
     * 
     * @param ids 需要删除的chatgpt秘钥管理主键
     * @return 结果
     */
    @Override
    public int deleteChatKeysByIds(Long[] ids)
    {
        return chatKeysMapper.deleteChatKeysByIds(ids);
    }

    /**
     * 删除chatgpt秘钥管理信息
     * 
     * @param id chatgpt秘钥管理主键
     * @return 结果
     */
    @Override
    public int deleteChatKeysById(Long id)
    {
        return chatKeysMapper.deleteChatKeysById(id);
    }
}
