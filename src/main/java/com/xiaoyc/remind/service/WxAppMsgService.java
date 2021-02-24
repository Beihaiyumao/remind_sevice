package com.xiaoyc.remind.service;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.xiaoyc.remind.pojo.dto.AddBirthdayRemindDTO;
import me.chanjar.weixin.common.error.WxErrorException;

public interface WxAppMsgService {

    void sendSubscribeMsg(WxMaSubscribeMessage subscribeMessage) throws WxErrorException;

    Boolean saveBirthdayRemind(AddBirthdayRemindDTO dto);
}
