package com.xiaoyc.remind.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyc.remind.entity.Member;
import com.xiaoyc.remind.pojo.dto.WxLoginDTO;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoyc
 * @since 2021-02-23
 */
public interface MemberService extends IService<Member> {

    /**
     * @description 登录
     *
     * @params [encryptedData, code, iv]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/23 0023 11:19
     **/
    Boolean wxLogin(WxLoginDTO dto) throws WxErrorException;

    /**
     * @description 获取会员手机号
     *
     * @params [dto]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/23 0023 14:05
     **/
    Boolean getMemberPhoneNum(WxLoginDTO dto) throws WxErrorException;
}
