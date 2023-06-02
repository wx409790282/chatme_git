package com.ruoyi.chat.service;

import java.util.List;

import com.ruoyi.chat.domain.ChatPaymentSecrets;

/**
 * 支付秘钥Service接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface IChatPaymentSecretsService 
{
    /**
     * 查询支付秘钥
     * 
     * @param id 支付秘钥主键
     * @return 支付秘钥
     */
    public ChatPaymentSecrets selectChatPaymentSecretsById(Long id);

    /**
     * 查询支付秘钥列表
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 支付秘钥集合
     */
    public List<ChatPaymentSecrets> selectChatPaymentSecretsList(ChatPaymentSecrets chatPaymentSecrets);

    /**
     * 新增支付秘钥
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 结果
     */
    public int insertChatPaymentSecrets(ChatPaymentSecrets chatPaymentSecrets);

    /**
     * 修改支付秘钥
     * 
     * @param chatPaymentSecrets 支付秘钥
     * @return 结果
     */
    public int updateChatPaymentSecrets(ChatPaymentSecrets chatPaymentSecrets);

    /**
     * 批量删除支付秘钥
     * 
     * @param ids 需要删除的支付秘钥主键集合
     * @return 结果
     */
    public int deleteChatPaymentSecretsByIds(Long[] ids);

    /**
     * 删除支付秘钥信息
     * 
     * @param id 支付秘钥主键
     * @return 结果
     */
    public int deleteChatPaymentSecretsById(Long id);
}
