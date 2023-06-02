package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatBills;
import com.ruoyi.chat.vo.ChatSessionWithModel;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.chat.domain.ChatSession;
import com.ruoyi.chat.service.IChatSessionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会话Controller
 * 
 * @author wangxi
 * @date 2023-05-11
 */
@RestController
@RequestMapping("/chat/session")
public class ChatSessionController extends BaseController
{
    @Autowired
    private IChatSessionService chatSessionService;

    /**
     * 查询会话列表
     */
    @PreAuthorize("@ss.hasPermi('chat:session:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatSession chatSession)
    {
        startPage();
        List<ChatSession> list = chatSessionService.selectChatSessionList(chatSession);
        return getDataTable(list);
    }

    @GetMapping("/listByMe")
    @ApiOperation("获取用户会话记录")
    public TableDataInfo listByMe()
    {
        String userName= SecurityUtils.getUsername();
        startPage();
        List<ChatSessionWithModel> list = chatSessionService.selectChatSessionsListByUserName(userName);
        return getDataTable(list);
    }

    /**
     * 导出会话列表
     */
    @PreAuthorize("@ss.hasPermi('chat:session:export')")
    @Log(title = "会话", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatSession chatSession)
    {
        List<ChatSession> list = chatSessionService.selectChatSessionList(chatSession);
        ExcelUtil<ChatSession> util = new ExcelUtil<ChatSession>(ChatSession.class);
        util.exportExcel(response, list, "会话数据");
    }

    /**
     * 获取会话详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:session:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatSessionService.selectChatSessionById(id));
    }

    /**
     * 新增会话
     */
    @PreAuthorize("@ss.hasPermi('chat:session:add')")
    @Log(title = "会话", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatSession chatSession)
    {
        return toAjax(chatSessionService.insertChatSession(chatSession));
    }

    /**
     * 修改会话
     */
    @PreAuthorize("@ss.hasPermi('chat:session:edit')")
    @Log(title = "会话", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatSession chatSession)
    {
        return toAjax(chatSessionService.updateChatSession(chatSession));
    }

    /**
     * 删除会话
     */
    @PreAuthorize("@ss.hasPermi('chat:session:remove')")
    @Log(title = "会话", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatSessionService.deleteChatSessionByIds(ids));
    }
}
