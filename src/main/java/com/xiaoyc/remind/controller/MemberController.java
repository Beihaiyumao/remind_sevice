package com.xiaoyc.remind.controller;

import com.xiaoyc.remind.pojo.dto.WxLoginDTO;
import com.xiaoyc.remind.service.MemberService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiaoyc
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @PostMapping("/login")
    public Boolean wxLogin(@RequestBody WxLoginDTO dto) throws WxErrorException {
        return memberService.wxLogin(dto);
    }


}
