package com.xiaoyc.remind.task;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaoyc.remind.entity.BirthdayRemind;
import com.xiaoyc.remind.service.BirthdayRemindService;
import com.xiaoyc.remind.service.WxAppMsgService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.ibatis.annotations.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author xiaoyinchuan
 * @date 2020/10/26 0026 10:55
 */

@Component
public class TaskService {

    @Resource
    private BirthdayRemindService birthdayRemindService;

    @Resource
    private WxAppMsgService appMsgService;

    /**
     * @description 每天7点执行 生日通知
     *
     * @params []
     * @return void
     * @author xiaoyinchuan
     * @date 2020/10/26 0026 11:02
     **/
    @Scheduled(cron = "0 0 7 * * ?")
    public void birthdayRemind() {

        List<BirthdayRemind> list = birthdayRemindService.list(new LambdaQueryWrapper<BirthdayRemind>()
                .ge(BirthdayRemind::getGmtRemind, LocalDateTime.now()));

        list.forEach(x -> {
            WxMaSubscribeMessage message = new WxMaSubscribeMessage();
            message.setTemplateId("qjQPnre4KBKETmfyNtbhxKK-72j2qt9o9lLktszTpq0");
            message.setToUser(x.getOpenId());
            WxMaSubscribeMessage.Data name1 = new WxMaSubscribeMessage.Data();
            name1.setName("name1");
            name1.setValue(x.getBirthdayName());

            WxMaSubscribeMessage.Data date2 = new WxMaSubscribeMessage.Data();
            date2.setName("date2");
            date2.setValue(x.getGmtRemind());

            WxMaSubscribeMessage.Data thing3 = new WxMaSubscribeMessage.Data();
            thing3.setName("thing3");
            thing3.setValue(x.getRemarks());
            try {
                System.out.println("发送**************");
                appMsgService.sendSubscribeMsg(message);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                System.out.println("休息一下***************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}
