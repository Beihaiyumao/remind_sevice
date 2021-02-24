package com.xiaoyc.remind.controller;

import com.xiaoyc.remind.pojo.dto.AddBirthdayRemindDTO;
import com.xiaoyc.remind.service.BirthdayRemindService;
import com.xiaoyc.remind.service.WxAppMsgService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiaoyc
 * @date 2021/2/22 0022 11:03
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Resource
    private WxAppMsgService wxService;
    @Resource
    private BirthdayRemindService birthdayRemindService;

    @GetMapping("/wx")
    public void sendSubscribeMsg() throws WxErrorException {
        wxService.sendSubscribeMsg(null);
    }

    @PostMapping("/birthday")
    public Boolean saveBirthday(@RequestBody AddBirthdayRemindDTO dto) {
        return birthdayRemindService.save(dto);
    }
}
