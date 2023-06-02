package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.RepeatSubmit;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.chat.domain.ChatCharge;
import com.ruoyi.chat.service.IChatChargeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 礼包兑换码Controller
 * 
 * @author wangxi
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/chat/charge")
public class ChatChargeController extends BaseController
{
    @Autowired
    private IChatChargeService chatChargeService;

    /**
     * 查询礼包兑换码列表
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatCharge chatCharge)
    {
        startPage();
        List<ChatCharge> list = chatChargeService.selectChatChargeList(chatCharge);
        return getDataTable(list);
    }

    /**
     * 导出礼包兑换码列表
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:export')")
    @Log(title = "礼包兑换码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatCharge chatCharge)
    {
        List<ChatCharge> list = chatChargeService.selectChatChargeList(chatCharge);
        ExcelUtil<ChatCharge> util = new ExcelUtil<ChatCharge>(ChatCharge.class);
        util.exportExcel(response, list, "礼包兑换码数据");
    }

    /**
     * 获取礼包兑换码详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatChargeService.selectChatChargeById(id));
    }


    /**
     * 新增礼包兑换码
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:add')")
    @Log(title = "礼包兑换码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatCharge chatCharge)
    {
        return toAjax(chatChargeService.insertChatCharge(chatCharge));
    }

    /**
     * 修改礼包兑换码
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:edit')")
    @Log(title = "礼包兑换码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatCharge chatCharge)
    {
        return toAjax(chatChargeService.updateChatCharge(chatCharge));
    }

    @RepeatSubmit(interval = 2000, message = "请求过于频繁")
    @Log(title = "礼包兑换码", businessType = BusinessType.UPDATE)
    @PostMapping("/use")
    public AjaxResult use(@RequestBody ChatCharge chatCharge)
    {
        if(chatCharge==null || chatCharge.getSecret()==null){
            return error("数据格式不正确");
        }
        int i=chatChargeService.useCharge(chatCharge);
        if(i==0){
            return error("找不到对应秘钥或秘钥已兑换");
        }
        return toAjax(i);
    }
    /**
     * 删除礼包兑换码
     */
    @PreAuthorize("@ss.hasPermi('chat:charge:remove')")
    @Log(title = "礼包兑换码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatChargeService.deleteChatChargeByIds(ids));
    }
}
