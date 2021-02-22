package com.xiaoyc.remind.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyc.remind.entity.BirthdayRemind;
import com.xiaoyc.remind.pojo.AddBrithdayRemindDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoyc
 * @since 2021-02-22
 */
public interface BirthdayRemindService extends IService<BirthdayRemind> {
    
    /**
     * @description 保存生日提醒
     *
     * @params [dto]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/22 0022 15:27
     **/
    Boolean save(AddBrithdayRemindDTO dto);
}
