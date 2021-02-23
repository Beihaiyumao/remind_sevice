package com.xiaoyc.remind.pojo.dto;

import lombok.Data;

/**
 * @author xiaoyc
 * @date 2021/2/23 0023 13:50
 */
@Data
public class WxLoginDTO {

    private String encryptedData;
    private String code;
    private String iv;
}
