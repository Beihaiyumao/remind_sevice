package com.xiaoyc.remind.service;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import me.chanjar.weixin.common.error.WxErrorException;

public interface WxAppService {

    void sendSubscribeMsg(WxMaSubscribeMessage subscribeMessage) throws WxErrorException;
}
