package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatAnswer;
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
import com.ruoyi.chat.service.IChatAnswerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问答Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@Api("问答记录")
@RestController
@RequestMapping("/chat/answer")
public class ChatAnswerController extends BaseController
{
    @Autowired
    private IChatAnswerService chatAnswerService;

    /**
     * 查询问答列表
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatAnswer chatAnswer)
    {
        startPage();
        List<ChatAnswer> list = chatAnswerService.selectChatAnswerList(chatAnswer);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('chat:answer:list')")
    @GetMapping("/listAll")
    public TableDataInfo listAll(ChatAnswer chatAnswer)
    {
        List<ChatAnswer> list = chatAnswerService.selectChatAnswerList(chatAnswer);
        return getDataTable(list);
    }

    @GetMapping("/listByMe")
    @ApiOperation("获取用户回答记录")
    public TableDataInfo listByMe(ChatAnswer chatAnswer)
    {
        Long userId=SecurityUtils.getUserId();
        startPage();
        List<ChatAnswer> list = chatAnswerService.selectChatAnswerByUserId(userId);
        return getDataTable(list);
    }
    /**
     * 导出问答列表
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:export')")
    @Log(title = "问答", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatAnswer chatAnswer)
    {
        List<ChatAnswer> list = chatAnswerService.selectChatAnswerList(chatAnswer);
        ExcelUtil<ChatAnswer> util = new ExcelUtil<ChatAnswer>(ChatAnswer.class);
        util.exportExcel(response, list, "问答数据");
    }

    /**
     * 获取问答详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatAnswerService.selectChatAnswerById(id));
    }

    /**
     * 新增问答
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:add')")
    @Log(title = "问答", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatAnswer chatAnswer)
    {
        return toAjax(chatAnswerService.insertChatAnswer(chatAnswer));
    }

    /**
     * 修改问答
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:edit')")
    @Log(title = "问答", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatAnswer chatAnswer)
    {
        return toAjax(chatAnswerService.updateChatAnswer(chatAnswer));
    }

    /**
     * 删除问答
     */
    @PreAuthorize("@ss.hasPermi('chat:answer:remove')")
    @Log(title = "问答", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatAnswerService.deleteChatAnswerByIds(ids));
    }
}
