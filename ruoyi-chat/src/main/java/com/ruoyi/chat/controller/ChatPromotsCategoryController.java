package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatPromotsCategory;
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
import com.ruoyi.chat.service.IChatPromotsCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提示词种类Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Api("提示词种类")
@RestController
@RequestMapping("/chat/category")
public class ChatPromotsCategoryController extends BaseController
{
    @Autowired
    private IChatPromotsCategoryService chatPromotsCategoryService;

    /**
     * 查询提示词种类列表
     */

    @GetMapping("/list")
    @ApiOperation("获取提示词种类")
    public TableDataInfo list(ChatPromotsCategory chatPromotsCategory)
    {
        startPage();
        List<ChatPromotsCategory> list = chatPromotsCategoryService.selectChatPromotsCategoryList(chatPromotsCategory);
        return getDataTable(list);
    }

    /**
     * 导出提示词种类列表
     */
    @PreAuthorize("@ss.hasPermi('chat:category:export')")
    @Log(title = "提示词种类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatPromotsCategory chatPromotsCategory)
    {
        List<ChatPromotsCategory> list = chatPromotsCategoryService.selectChatPromotsCategoryList(chatPromotsCategory);
        ExcelUtil<ChatPromotsCategory> util = new ExcelUtil<ChatPromotsCategory>(ChatPromotsCategory.class);
        util.exportExcel(response, list, "提示词种类数据");
    }

    /**
     * 获取提示词种类详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatPromotsCategoryService.selectChatPromotsCategoryById(id));
    }

    /**
     * 新增提示词种类
     */
    @PreAuthorize("@ss.hasPermi('chat:category:add')")
    @Log(title = "提示词种类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatPromotsCategory chatPromotsCategory)
    {
        return toAjax(chatPromotsCategoryService.insertChatPromotsCategory(chatPromotsCategory));
    }

    /**
     * 修改提示词种类
     */
    @PreAuthorize("@ss.hasPermi('chat:category:edit')")
    @Log(title = "提示词种类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatPromotsCategory chatPromotsCategory)
    {
        return toAjax(chatPromotsCategoryService.updateChatPromotsCategory(chatPromotsCategory));
    }

    /**
     * 删除提示词种类
     */
    @PreAuthorize("@ss.hasPermi('chat:category:remove')")
    @Log(title = "提示词种类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatPromotsCategoryService.deleteChatPromotsCategoryByIds(ids));
    }
}
