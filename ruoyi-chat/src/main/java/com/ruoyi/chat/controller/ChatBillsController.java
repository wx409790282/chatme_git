package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatBills;
import com.ruoyi.chat.vo.ChatBillsWithPayment;
import com.ruoyi.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.chat.service.IChatBillsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充值记录Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Api("充值记录")
@RestController
@RequestMapping("/chat/bills")
public class ChatBillsController extends BaseController
{
    @Autowired
    private IChatBillsService chatBillsService;

    /**
     * 查询充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatBills chatBills)
    {
        startPage();
        List<ChatBills> list = chatBillsService.selectChatBillsList(chatBills);
        return getDataTable(list);
    }

    @GetMapping("/listByMe")
    @ApiOperation("获取用户充值记录")
    public TableDataInfo listByMe()
    {
        Long userId= SecurityUtils.getUserId();
        startPage();
        List<ChatBillsWithPayment> list = chatBillsService.selectChatBillsListByUserId(userId);
        return getDataTable(list);
    }

    /**
     * 导出充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:export')")
    @Log(title = "充值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatBills chatBills)
    {
        List<ChatBills> list = chatBillsService.selectChatBillsList(chatBills);
        ExcelUtil<ChatBills> util = new ExcelUtil<ChatBills>(ChatBills.class);
        util.exportExcel(response, list, "充值记录数据");
    }

    /**
     * 获取充值记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatBillsService.selectChatBillsById(id));
    }

    /**
     * 新增充值记录
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:add')")
    @Log(title = "充值记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatBills chatBills)
    {
        return toAjax(chatBillsService.insertChatBills(chatBills));
    }

    /**
     * 修改充值记录
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:edit')")
    @Log(title = "充值记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatBills chatBills)
    {
        return toAjax(chatBillsService.updateChatBills(chatBills));
    }

    /**
     * 删除充值记录
     */
    @PreAuthorize("@ss.hasPermi('chat:bills:remove')")
    @Log(title = "充值记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatBillsService.deleteChatBillsByIds(ids));
    }
}
