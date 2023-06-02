package com.ruoyi.chat.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatModel;
import com.ruoyi.chat.domain.ChatPromotsContent;
import com.ruoyi.chat.service.IChatModelService;
import com.ruoyi.chat.vo.ChatModelWithPromot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
import com.ruoyi.chat.service.IChatPromotsContentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提示词Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */

@Api("提示词内容")
@RestController
@RequestMapping("/chat/content")
public class ChatPromotsContentController extends BaseController
{
    @Autowired
    private IChatPromotsContentService chatPromotsContentService;
    @Autowired
    private IChatModelService chatModelService;
    /**
     * 查询提示词列表
     */

    @GetMapping("/list")
    @ApiOperation("获取提示词")
    public TableDataInfo list(ChatPromotsContent chatPromotsContent)
    {
        startPage();
        List<ChatPromotsContent> list = chatPromotsContentService.selectChatPromotsContentList(chatPromotsContent);
        return getDataTable(list);
    }

    @GetMapping("/listWithModel")
    @ApiOperation("获取提示词")
    public TableDataInfo listWithModel(ChatPromotsContent chatPromotsContent)
    {
        List<ChatModelWithPromot> promots=new ArrayList<>();
        List<ChatModel> models=chatModelService.selectChatModelList(new ChatModel());
        for(ChatModel model : models){
            ChatModelWithPromot promot=new ChatModelWithPromot();
            BeanUtils.copyProperties(model,promot);
            List<ChatPromotsContent> list =chatPromotsContentService.selectChatPromotsContentByModel(model.getId());
            promot.setList(list);
            promots.add(promot);
        }
        return getDataTable(promots);
    }
    /**
     * 导出提示词列表
     */
    @PreAuthorize("@ss.hasPermi('chat:content:export')")
    @Log(title = "提示词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatPromotsContent chatPromotsContent)
    {
        List<ChatPromotsContent> list = chatPromotsContentService.selectChatPromotsContentList(chatPromotsContent);
        ExcelUtil<ChatPromotsContent> util = new ExcelUtil<ChatPromotsContent>(ChatPromotsContent.class);
        util.exportExcel(response, list, "提示词数据");
    }

    /**
     * 获取提示词详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:content:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatPromotsContentService.selectChatPromotsContentById(id));
    }

    /**
     * 新增提示词
     */
    @PreAuthorize("@ss.hasPermi('chat:content:add')")
    @Log(title = "提示词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatPromotsContent chatPromotsContent)
    {
        return toAjax(chatPromotsContentService.insertChatPromotsContent(chatPromotsContent));
    }

    /**
     * 修改提示词
     */
    @PreAuthorize("@ss.hasPermi('chat:content:edit')")
    @Log(title = "提示词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatPromotsContent chatPromotsContent)
    {
        return toAjax(chatPromotsContentService.updateChatPromotsContent(chatPromotsContent));
    }

    /**
     * 删除提示词
     */
    @PreAuthorize("@ss.hasPermi('chat:content:remove')")
    @Log(title = "提示词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatPromotsContentService.deleteChatPromotsContentByIds(ids));
    }
}
