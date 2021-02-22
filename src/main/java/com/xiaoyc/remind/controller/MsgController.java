package com.xiaoyc.remind.controller;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.xiaoyc.remind.service.WxAppService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaoyc
 * @date 2021/2/22 0022 11:03
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Resource
    private WxAppService wxService;

    @GetMapping("/wx")
    public void  sendSubscribeMsg() throws WxErrorException {
        wxService.sendSubscribeMsg(null);
    }
}
