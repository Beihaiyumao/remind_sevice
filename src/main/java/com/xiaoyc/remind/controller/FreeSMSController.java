package com.xiaoyc.remind.controller;

import com.xiaoyc.remind.pojo.vo.FreeSMSInfoListVO;
import com.xiaoyc.remind.pojo.vo.FreeSMSListVO;
import com.xiaoyc.remind.service.FreeSMSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author xiaoyc
 * @date 2021/2/24 16:27
 */
@RestController
@RequestMapping("/free/msg")
public class FreeSMSController {

    @Resource
    private FreeSMSService freeSMSService;

    @GetMapping("/list")
    private List<FreeSMSListVO> smsList() throws IOException {
        return freeSMSService.smsList();
    }

    @GetMapping("/info")
    private List<FreeSMSInfoListVO> smsInfoList(@RequestParam("number") String number) throws IOException {
        return freeSMSService.smsInfoList(number);
    }
}
