package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatKeys;
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
import com.ruoyi.chat.service.IChatKeysService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * chatgpt秘钥管理Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@RestController
@RequestMapping("/chat/keys")
public class ChatKeysController extends BaseController
{
    @Autowired
    private IChatKeysService chatKeysService;

    /**
     * 查询chatgpt秘钥管理列表
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatKeys chatKeys)
    {
        startPage();
        List<ChatKeys> list = chatKeysService.selectChatKeysList(chatKeys);
        return getDataTable(list);
    }

    /**
     * 导出chatgpt秘钥管理列表
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:export')")
    @Log(title = "chatgpt秘钥管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatKeys chatKeys)
    {
        List<ChatKeys> list = chatKeysService.selectChatKeysList(chatKeys);
        ExcelUtil<ChatKeys> util = new ExcelUtil<ChatKeys>(ChatKeys.class);
        util.exportExcel(response, list, "chatgpt秘钥管理数据");
    }

    /**
     * 获取chatgpt秘钥管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatKeysService.selectChatKeysById(id));
    }

    /**
     * 新增chatgpt秘钥管理
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:add')")
    @Log(title = "chatgpt秘钥管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatKeys chatKeys)
    {
        return toAjax(chatKeysService.insertChatKeys(chatKeys));
    }

    /**
     * 修改chatgpt秘钥管理
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:edit')")
    @Log(title = "chatgpt秘钥管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatKeys chatKeys)
    {
        return toAjax(chatKeysService.updateChatKeys(chatKeys));
    }

    /**
     * 删除chatgpt秘钥管理
     */
    @PreAuthorize("@ss.hasPermi('chat:keys:remove')")
    @Log(title = "chatgpt秘钥管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatKeysService.deleteChatKeysByIds(ids));
    }
}
