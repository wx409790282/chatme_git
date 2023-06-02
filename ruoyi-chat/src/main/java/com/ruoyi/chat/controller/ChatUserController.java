package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatAnswer;
import com.ruoyi.chat.domain.ChatUser;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.chat.service.IChatUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户余额Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@RestController
@RequestMapping("/chat/user")
public class ChatUserController extends BaseController
{
    @Autowired
    private IChatUserService chatUserService;

    /**
     * 查询用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('chat:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatUser chatUser)
    {
        startPage();
        List<ChatUser> list = chatUserService.selectChatUserList(chatUser);
        return getDataTable(list);
    }

    /**
     * 导出用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('chat:user:export')")
    @Log(title = "用户余额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatUser chatUser)
    {
        List<ChatUser> list = chatUserService.selectChatUserList(chatUser);
        ExcelUtil<ChatUser> util = new ExcelUtil<ChatUser>(ChatUser.class);
        util.exportExcel(response, list, "用户余额数据");
    }

    /**
     * 获取用户余额详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatUserService.selectChatUserById(id));
    }

    @GetMapping(value = "/balance")
    public AjaxResult getBalance()
    {
        Long username= SecurityUtils.getUserId();
        return success(chatUserService.selectChatUserByUserid(username));
    }

    /**
     * 新增用户余额
     */
    @PreAuthorize("@ss.hasPermi('chat:user:add')")
    @Log(title = "用户余额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatUser chatUser)
    {
        return toAjax(chatUserService.insertChatUser(chatUser));
    }

    /**
     * 修改用户余额
     */
    @PreAuthorize("@ss.hasPermi('chat:user:edit')")
    @Log(title = "用户余额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatUser chatUser)
    {
        return toAjax(chatUserService.updateChatUser(chatUser));
    }

    /**
     * 删除用户余额
     */
    @PreAuthorize("@ss.hasPermi('chat:user:remove')")
    @Log(title = "用户余额", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatUserService.deleteChatUserByIds(ids));
    }
}
