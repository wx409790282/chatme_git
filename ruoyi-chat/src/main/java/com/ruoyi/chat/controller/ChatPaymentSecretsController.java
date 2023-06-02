package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.chat.domain.ChatPaymentSecrets;
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
import com.ruoyi.chat.service.IChatPaymentSecretsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付秘钥Controller
 * 
 * @author wangxi
 * @date 2023-05-05
 */
@RestController
@RequestMapping("/chat/secrets")
public class ChatPaymentSecretsController extends BaseController
{
    @Autowired
    private IChatPaymentSecretsService chatPaymentSecretsService;

    /**
     * 查询支付秘钥列表
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatPaymentSecrets chatPaymentSecrets)
    {
        startPage();
        List<ChatPaymentSecrets> list = chatPaymentSecretsService.selectChatPaymentSecretsList(chatPaymentSecrets);
        return getDataTable(list);
    }

    /**
     * 导出支付秘钥列表
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:export')")
    @Log(title = "支付秘钥", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatPaymentSecrets chatPaymentSecrets)
    {
        List<ChatPaymentSecrets> list = chatPaymentSecretsService.selectChatPaymentSecretsList(chatPaymentSecrets);
        ExcelUtil<ChatPaymentSecrets> util = new ExcelUtil<ChatPaymentSecrets>(ChatPaymentSecrets.class);
        util.exportExcel(response, list, "支付秘钥数据");
    }

    /**
     * 获取支付秘钥详细信息
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatPaymentSecretsService.selectChatPaymentSecretsById(id));
    }

    /**
     * 新增支付秘钥
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:add')")
    @Log(title = "支付秘钥", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatPaymentSecrets chatPaymentSecrets)
    {
        return toAjax(chatPaymentSecretsService.insertChatPaymentSecrets(chatPaymentSecrets));
    }

    /**
     * 修改支付秘钥
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:edit')")
    @Log(title = "支付秘钥", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatPaymentSecrets chatPaymentSecrets)
    {
        return toAjax(chatPaymentSecretsService.updateChatPaymentSecrets(chatPaymentSecrets));
    }

    /**
     * 删除支付秘钥
     */
    @PreAuthorize("@ss.hasPermi('chat:secrets:remove')")
    @Log(title = "支付秘钥", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatPaymentSecretsService.deleteChatPaymentSecretsByIds(ids));
    }
}
