package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatAnswer;

/**
 * 问答Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-11
 */
public interface ChatAnswerMapper extends BaseMapper<ChatAnswer>
{
    /**
     * 查询问答
     * 
     * @param id 问答主键
     * @return 问答
     */
    public ChatAnswer selectChatAnswerById(Long id);

    /**
     * 查询问答列表
     * 
     * @param chatAnswer 问答
     * @return 问答集合
     */
    public List<ChatAnswer> selectChatAnswerList(ChatAnswer chatAnswer);

    /**
     * 新增问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    public int insertChatAnswer(ChatAnswer chatAnswer);

    /**
     * 修改问答
     * 
     * @param chatAnswer 问答
     * @return 结果
     */
    public int updateChatAnswer(ChatAnswer chatAnswer);

    /**
     * 删除问答
     * 
     * @param id 问答主键
     * @return 结果
     */
    public int deleteChatAnswerById(Long id);

    /**
     * 批量删除问答
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatAnswerByIds(Long[] ids);
}
