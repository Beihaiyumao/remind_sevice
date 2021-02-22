package com.xiaoyc.remind.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;


public interface UserService {

    WxMaJscode2SessionResult getSessionInfo(String jsCode) throws WxErrorException;

}
