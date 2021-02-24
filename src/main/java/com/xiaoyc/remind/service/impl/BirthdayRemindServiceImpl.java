package com.xiaoyc.remind.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyc.remind.dao.BirthdayRemindMapper;
import com.xiaoyc.remind.entity.BirthdayRemind;
import com.xiaoyc.remind.pojo.dto.AddBirthdayRemindDTO;
import com.xiaoyc.remind.service.BirthdayRemindService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2021-02-22
 */
@Service
public class BirthdayRemindServiceImpl extends ServiceImpl<BirthdayRemindMapper, BirthdayRemind> implements BirthdayRemindService {

    /**
     * @description 保存生日提醒
     *
     * @params [dto]
     * @return java.lang.Boolean
     * @author xiaoyc
     * @date 2021/2/22 0022 15:28
     **/
    @Override
    public Boolean save(AddBirthdayRemindDTO dto) {
        BirthdayRemind remind = new BirthdayRemind();
        BeanUtils.copyProperties(dto, remind);
        return this.save(remind);
    }
}
