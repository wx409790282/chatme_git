package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.service.IChatModelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模型Controller
 * 
 * @author wangxi
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/chat/model")
public class ChatModelController extends BaseController
{
    @Autowired
    private IChatModelService chatModelService;

    /**
     * 查询模型列表
     */

    @GetMapping("/list")
    public TableDataInfo list(ChatModel chatModel)
    {
        startPage();
        List<ChatModel> list = chatModelService.selectChatModelList(chatModel);
        return getDataTable(list);
    }

    /**
     * 导出模型列表
     */
    @PreAuthorize("@ss.hasPermi('chat:model:export')")
    @Log(title = "模型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatModel chatModel)
    {
        List<ChatModel> list = chatModelService.selectChatModelList(chatModel);
        ExcelUtil<ChatModel> util = new ExcelUtil<ChatModel>(ChatModel.class);
        util.exportExcel(response, list, "模型数据");
    }

    /**
     * 获取模型详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:model:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatModelService.selectChatModelById(id));
    }

    /**
     * 新增模型
     */
    @PreAuthorize("@ss.hasPermi('chat:model:add')")
    @Log(title = "模型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatModel chatModel)
    {
        return toAjax(chatModelService.insertChatModel(chatModel));
    }

    /**
     * 修改模型
     */
    @PreAuthorize("@ss.hasPermi('chat:model:edit')")
    @Log(title = "模型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatModel chatModel)
    {
        return toAjax(chatModelService.updateChatModel(chatModel));
    }

    /**
     * 删除模型
     */
    @PreAuthorize("@ss.hasPermi('chat:model:remove')")
    @Log(title = "模型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatModelService.deleteChatModelByIds(ids));
    }
}
