package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatPromotsContent;

/**
 * 提示词Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-05
 */
public interface ChatPromotsContentMapper extends BaseMapper<ChatPromotsContent>
{
    /**
     * 查询提示词
     * 
     * @param id 提示词主键
     * @return 提示词
     */
    public ChatPromotsContent selectChatPromotsContentById(Long id);

    /**
     * 查询提示词列表
     * 
     * @param chatPromotsContent 提示词
     * @return 提示词集合
     */
    public List<ChatPromotsContent> selectChatPromotsContentList(ChatPromotsContent chatPromotsContent);

    /**
     * 新增提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    public int insertChatPromotsContent(ChatPromotsContent chatPromotsContent);

    /**
     * 修改提示词
     * 
     * @param chatPromotsContent 提示词
     * @return 结果
     */
    public int updateChatPromotsContent(ChatPromotsContent chatPromotsContent);

    /**
     * 删除提示词
     * 
     * @param id 提示词主键
     * @return 结果
     */
    public int deleteChatPromotsContentById(Long id);

    /**
     * 批量删除提示词
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatPromotsContentByIds(Long[] ids);
}
