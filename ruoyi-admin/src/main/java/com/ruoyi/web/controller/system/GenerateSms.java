package com.ruoyi.web.controller.system;

import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.ruoyi.chat.utils.AliSMSUtil;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.uuid.IdUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api("短信登录")
@Controller
public class GenerateSms {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    AliSMSUtil aliSMSUtil;
    private Logger logger = LoggerFactory.getLogger(getClass());


    @ApiOperation("生成验证码")
    @ApiImplicitParam(name = "mobile",value = "手机号码",required = true,dataType = "String",paramType = "query")
    @PostMapping("/sms/code")
    @ResponseBody
    public AjaxResult sms(@RequestBody LoginBody loginBody) {


        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

}
