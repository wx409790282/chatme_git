package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatPayment;
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
import com.ruoyi.chat.service.IChatPaymentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品类型Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Api("充值类型")
@RestController
@RequestMapping("/chat/payment")
public class ChatPaymentController extends BaseController
{
    @Autowired
    private IChatPaymentService chatPaymentService;

    /**
     * 查询商品类型列表
     */

    @ApiOperation("获取商品类型")
    @GetMapping("/list")
    public TableDataInfo list(ChatPayment chatPayment)
    {
        startPage();
        List<ChatPayment> list = chatPaymentService.selectChatPaymentList(chatPayment);
        return getDataTable(list);
    }

    /**
     * 导出商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('chat:payment:export')")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatPayment chatPayment)
    {
        List<ChatPayment> list = chatPaymentService.selectChatPaymentList(chatPayment);
        ExcelUtil<ChatPayment> util = new ExcelUtil<ChatPayment>(ChatPayment.class);
        util.exportExcel(response, list, "商品类型数据");
    }

    /**
     * 获取商品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:payment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatPaymentService.selectChatPaymentById(id));
    }

    /**
     * 新增商品类型
     */
    @PreAuthorize("@ss.hasPermi('chat:payment:add')")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatPayment chatPayment)
    {
        return toAjax(chatPaymentService.insertChatPayment(chatPayment));
    }

    /**
     * 修改商品类型
     */
    @PreAuthorize("@ss.hasPermi('chat:payment:edit')")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatPayment chatPayment)
    {
        return toAjax(chatPaymentService.updateChatPayment(chatPayment));
    }

    /**
     * 删除商品类型
     */
    @PreAuthorize("@ss.hasPermi('chat:payment:remove')")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatPaymentService.deleteChatPaymentByIds(ids));
    }
}
