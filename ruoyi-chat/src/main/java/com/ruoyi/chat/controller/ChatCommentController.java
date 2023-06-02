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
import com.ruoyi.chat.domain.ChatComment;
import com.ruoyi.chat.service.IChatCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 意见反馈Controller
 * 
 * @author wangxi
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/chat/comment")
public class ChatCommentController extends BaseController
{
    @Autowired
    private IChatCommentService chatCommentService;

    /**
     * 查询意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('chat:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatComment chatComment)
    {
        startPage();
        List<ChatComment> list = chatCommentService.selectChatCommentList(chatComment);
        return getDataTable(list);
    }

    /**
     * 导出意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('chat:comment:export')")
    @Log(title = "意见反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatComment chatComment)
    {
        List<ChatComment> list = chatCommentService.selectChatCommentList(chatComment);
        ExcelUtil<ChatComment> util = new ExcelUtil<ChatComment>(ChatComment.class);
        util.exportExcel(response, list, "意见反馈数据");
    }

    /**
     * 获取意见反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatCommentService.selectChatCommentById(id));
    }

    /**
     * 新增意见反馈
     */
    @Log(title = "意见反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatComment chatComment)
    {
        return toAjax(chatCommentService.insertChatComment(chatComment));
    }

    /**
     * 修改意见反馈
     */
    @PreAuthorize("@ss.hasPermi('chat:comment:edit')")
    @Log(title = "意见反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatComment chatComment)
    {
        return toAjax(chatCommentService.updateChatComment(chatComment));
    }

    /**
     * 删除意见反馈
     */
    @PreAuthorize("@ss.hasPermi('chat:comment:remove')")
    @Log(title = "意见反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatCommentService.deleteChatCommentByIds(ids));
    }
}
