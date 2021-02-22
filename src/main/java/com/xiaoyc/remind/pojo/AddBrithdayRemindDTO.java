package com.xiaoyc.remind.pojo;

import lombok.Data;

/**
 * @author xiaoyc
 * @date 2021/2/22 0022 14:14
 */
@Data
public class AddBrithdayRemindDTO {

    private String tmplId;

    private String gmtRemind;

    private String openId;

    private String remarks;
}
