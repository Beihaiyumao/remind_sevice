package com.xiaoyc.remind.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaMsgService;
import cn.binarywang.wx.miniapp.api.impl.WxMaMsgServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.xiaoyc.remind.pojo.dto.AddBirthdayRemindDTO;
import com.xiaoyc.remind.service.WxAppMsgService;
import com.xiaoyc.remind.util.WxUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


@Service
public class WxAppServiceImpl implements WxAppMsgService {

    @Resource
    private WxUtil wxUtil;

    @Override
    public void sendSubscribeMsg(WxMaSubscribeMessage subscribeMessage) throws WxErrorException {

        WxMaMsgService msgService = new WxMaMsgServiceImpl(wxUtil.getWxMaService());
        WxMaSubscribeMessage message = new WxMaSubscribeMessage();
        message.setToUser("oIQBN5T9rmovZ-nH-BO4-b109_2A");
        message.setTemplateId("qjQPnre4KBKETmfyNtbhxKK-72j2qt9o9lLktszTpq0");
        WxMaSubscribeMessage.Data name1 = new WxMaSubscribeMessage.Data();
        name1.setName("name1");
        name1.setValue("xioayc");

        WxMaSubscribeMessage.Data date2 = new WxMaSubscribeMessage.Data();
        date2.setName("date2");
        date2.setValue("2021-2-22 11:15:15");

        WxMaSubscribeMessage.Data thing3 = new WxMaSubscribeMessage.Data();
        thing3.setName("thing3");
        thing3.setValue("测试订阅");

        List<WxMaSubscribeMessage.Data> list = new LinkedList<>();
        list.add(name1);
        list.add(date2);
        list.add(thing3);

        message.setData(list);
        msgService.sendSubscribeMsg(message);

    }

    @Override
    public Boolean saveBirthdayRemind(AddBirthdayRemindDTO dto) {
        return null;
    }
}
