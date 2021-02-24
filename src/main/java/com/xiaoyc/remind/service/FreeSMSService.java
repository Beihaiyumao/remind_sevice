package com.xiaoyc.remind.service;

import com.xiaoyc.remind.pojo.vo.FreeSMSInfoListVO;
import com.xiaoyc.remind.pojo.vo.FreeSMSListVO;

import java.io.IOException;
import java.util.List;

/**
 * @author xiaoyc
 * @date 2021/2/24 15:58
 */

public interface FreeSMSService {

    /**
     * @description 免费短信列表
     *
     * @params []
     * @return java.util.List<com.xiaoyc.remind.pojo.vo.FreeSMSListVO>
     * @author xiaoyc
     * @date 2021/2/24 16:10
     **/
    List<FreeSMSListVO> smsList() throws IOException;

    /**
     * @description 短信内容列表
     *
     * @params []
     * @return java.util.List<com.xiaoyc.remind.pojo.vo.FreeSMSInfoListVO>
     * @author xiaoyc
     * @date 2021/2/24 16:14
     **/
    List<FreeSMSInfoListVO> smsInfoList(String number) throws IOException;
}
