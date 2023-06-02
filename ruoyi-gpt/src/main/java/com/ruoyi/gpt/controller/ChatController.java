package com.ruoyi.gpt.controller;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-03-01
 */
@Controller
@Slf4j
public class ChatController {

    @GetMapping("")
    public String index() {
        return "1.html";
    }

    @GetMapping("/websocket")
    public String websocket() {
        return "websocket.html";
    }

    /**
     * 获取uid
     *
     * @param headers
     * @return
     */
    private String getUid(Map<String, String> headers) {
        String uid = headers.get("uid");
        if (StrUtil.isBlank(uid)) {
            throw new ServiceException("访问过于频繁，请稍候再试");
        }
        return uid;
    }


}
