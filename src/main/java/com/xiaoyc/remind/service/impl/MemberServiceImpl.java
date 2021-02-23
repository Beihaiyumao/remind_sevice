package com.xiaoyc.remind.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.api.impl.WxMaUserServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyc.remind.dao.MemberMapper;
import com.xiaoyc.remind.entity.Member;
import com.xiaoyc.remind.pojo.dto.WxLoginDTO;
import com.xiaoyc.remind.service.MemberService;
import com.xiaoyc.remind.util.WxUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2021-02-23
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    private WxUtil wxUtil;

    /**
     * @description 登录
     *
     * @params [encryptedData, code, iv]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/23 0023 11:18
     **/
    @Override
    public Boolean wxLogin(WxLoginDTO dto) throws WxErrorException {
        WxMaUserService userService = new WxMaUserServiceImpl(wxUtil.getWxMaService());
        WxMaJscode2SessionResult sessionInfo = userService.getSessionInfo(dto.getCode());
        WxMaUserInfo userInfo = userService.getUserInfo(sessionInfo.getSessionKey(), dto.getEncryptedData(), dto.getIv());
        Member member = new Member();
        BeanUtils.copyProperties(userInfo, member);
        return this.save(member);
    }

    /**
     * @description 获取会员手机号
     *
     * @params [dto]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/23 0023 14:05
     *
     * @param dto*/
    @Override
    public Boolean getMemberPhoneNum(WxLoginDTO dto) throws WxErrorException {
        WxMaUserService userService = new WxMaUserServiceImpl(wxUtil.getWxMaService());
        WxMaJscode2SessionResult sessionInfo = userService.getSessionInfo(dto.getCode());
        WxMaPhoneNumberInfo phoneNoInfo = userService.getPhoneNoInfo(sessionInfo.getSessionKey(), dto.getEncryptedData(), dto.getIv());
        return this.update(new Member().setMobile(phoneNoInfo.getPhoneNumber()),
                new LambdaQueryWrapper<Member>().eq(Member::getOpenId, sessionInfo.getOpenid()));
    }
}
