package com.ruoyi.chat.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.chat.domain.ChatCharge;

/**
 * 礼包兑换码Mapper接口
 * 
 * @author wangxi
 * @date 2023-05-10
 */
public interface ChatChargeMapper extends BaseMapper<ChatCharge>
{
    /**
     * 查询礼包兑换码
     * 
     * @param id 礼包兑换码主键
     * @return 礼包兑换码
     */
    public ChatCharge selectChatChargeById(Long id);

    /**
     * 查询礼包兑换码列表
     * 
     * @param chatCharge 礼包兑换码
     * @return 礼包兑换码集合
     */
    public List<ChatCharge> selectChatChargeList(ChatCharge chatCharge);

    /**
     * 新增礼包兑换码
     * 
     * @param chatCharge 礼包兑换码
     * @return 结果
     */
    public int insertChatCharge(ChatCharge chatCharge);

    /**
     * 修改礼包兑换码
     * 
     * @param chatCharge 礼包兑换码
     * @return 结果
     */
    public int updateChatCharge(ChatCharge chatCharge);

    /**
     * 删除礼包兑换码
     * 
     * @param id 礼包兑换码主键
     * @return 结果
     */
    public int deleteChatChargeById(Long id);

    /**
     * 批量删除礼包兑换码
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatChargeByIds(Long[] ids);
}
