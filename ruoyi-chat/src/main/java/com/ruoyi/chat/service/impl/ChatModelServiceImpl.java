package com.ruoyi.chat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chat.mapper.ChatModelMapper;
import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.service.IChatModelService;

/**
 * 模型Service业务层处理
 * 
 * @author wangxi
 * @date 2023-05-10
 */
@Service
public class ChatModelServiceImpl implements IChatModelService 
{
    @Autowired
    private ChatModelMapper chatModelMapper;

    /**
     * 查询模型
     * 
     * @param id 模型主键
     * @return 模型
     */
    @Override
    public ChatModel selectChatModelById(Long id)
    {
        return chatModelMapper.selectChatModelById(id);
    }

    /**
     * 查询模型列表
     * 
     * @param chatModel 模型
     * @return 模型
     */
    @Override
    public List<ChatModel> selectChatModelList(ChatModel chatModel)
    {
        return chatModelMapper.selectChatModelList(chatModel);
    }

    /**
     * 新增模型
     * 
     * @param chatModel 模型
     * @return 结果
     */
    @Override
    public int insertChatModel(ChatModel chatModel)
    {
        return chatModelMapper.insertChatModel(chatModel);
    }

    /**
     * 修改模型
     * 
     * @param chatModel 模型
     * @return 结果
     */
    @Override
    public int updateChatModel(ChatModel chatModel)
    {
        return chatModelMapper.updateChatModel(chatModel);
    }

    /**
     * 批量删除模型
     * 
     * @param ids 需要删除的模型主键
     * @return 结果
     */
    @Override
    public int deleteChatModelByIds(Long[] ids)
    {
        return chatModelMapper.deleteChatModelByIds(ids);
    }

    /**
     * 删除模型信息
     * 
     * @param id 模型主键
     * @return 结果
     */
    @Override
    public int deleteChatModelById(Long id)
    {
        return chatModelMapper.deleteChatModelById(id);
    }
}
