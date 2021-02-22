package com.xiaoyc.remind.controller;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.xiaoyc.remind.service.UserService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/jscode")
    public WxMaJscode2SessionResult getSessionInfo(String jsCode) throws WxErrorException {
        return userService.getSessionInfo(jsCode);
    }


}
