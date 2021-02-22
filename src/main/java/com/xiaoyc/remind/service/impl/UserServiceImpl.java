package com.xiaoyc.remind.service.impl;


import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.api.impl.WxMaUserServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.xiaoyc.remind.service.UserService;
import com.xiaoyc.remind.util.WxUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private WxUtil wxUtil;

    @Override
    public WxMaJscode2SessionResult getSessionInfo(String jsCode) throws WxErrorException {
        WxMaUserService userService = new WxMaUserServiceImpl(wxUtil.getWxMaService());

        WxMaJscode2SessionResult sessionInfo = userService.getSessionInfo(jsCode);

        return sessionInfo;
    }
}
