package com.xiaoyc.remind.entity;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
}
