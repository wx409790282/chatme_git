package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.domain.ChatPaymentSecrets;

/**
 * 模型Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-10
 */
public interface ChatModelMapper extends BaseMapper<ChatModel>
{
    /**
     * 查询模型
     * 
     * @param id 模型主键
     * @return 模型
     */
    public ChatModel selectChatModelById(Long id);

    /**
     * 查询模型列表
     * 
     * @param chatModel 模型
     * @return 模型集合
     */
    public List<ChatModel> selectChatModelList(ChatModel chatModel);

    /**
     * 新增模型
     * 
     * @param chatModel 模型
     * @return 结果
     */
    public int insertChatModel(ChatModel chatModel);

    /**
     * 修改模型
     * 
     * @param chatModel 模型
     * @return 结果
     */
    public int updateChatModel(ChatModel chatModel);

    /**
     * 删除模型
     * 
     * @param id 模型主键
     * @return 结果
     */
    public int deleteChatModelById(Long id);

    /**
     * 批量删除模型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatModelByIds(Long[] ids);
}
