package com.ruoyi.chat.service.impl;

import java.util.List;

import com.ruoyi.chat.domain.ChatPaymentSecrets;
import com.ruoyi.chat.mapper.ChatPaymentSecretsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.service.IChatPaymentSecretsService;

/**
 * 支付秘钥Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Service
public class ChatPaymentSecretsServiceImpl implements IChatPaymentSecretsService 
{
    @Autowired
    private ChatPaymentSecretsMapper chatPaymentSecretsMapper;

    /**
     * 查询支付秘钥
     * 
     * @param id 支付秘钥主键
     * @return 支付秘钥
     */
    @Override
    public ChatPaymentSecrets selectChatPaymentSecretsById(Long id)
    {
        return chatPaymentSecretsMapper.selectChatPaymentSecretsById(id);
    }

    /**
     * 查询支付秘钥列表
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 支付秘钥
     */
    @Override
    public List<ChatPaymentSecrets> selectChatPaymentSecretsList(ChatPaymentSecrets chatPaymentSecrets)
    {
        return chatPaymentSecretsMapper.selectChatPaymentSecretsList(chatPaymentSecrets);
    }

    /**
     * 新增支付秘钥
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 结果
     */
    @Override
    public int insertChatPaymentSecrets(ChatPaymentSecrets chatPaymentSecrets)
    {
        return chatPaymentSecretsMapper.insertChatPaymentSecrets(chatPaymentSecrets);
    }

    /**
     * 修改支付秘钥
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 结果
     */
    @Override
    public int updateChatPaymentSecrets(ChatPaymentSecrets chatPaymentSecrets)
    {
        return chatPaymentSecretsMapper.updateChatPaymentSecrets(chatPaymentSecrets);
    }

    /**
     * 批量删除支付秘钥
     * 
     * @param ids 需要删除的支付秘钥主键
     * @return 结果
     */
    @Override
    public int deleteChatPaymentSecretsByIds(Long[] ids)
    {
        return chatPaymentSecretsMapper.deleteChatPaymentSecretsByIds(ids);
    }

    /**
     * 删除支付秘钥信息
     * 
     * @param id 支付秘钥主键
     * @return 结果
     */
    @Override
    public int deleteChatPaymentSecretsById(Long id)
    {
        return chatPaymentSecretsMapper.deleteChatPaymentSecretsById(id);
    }
}
