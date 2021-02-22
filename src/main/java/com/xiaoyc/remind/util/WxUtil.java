package com.xiaoyc.remind.util;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaRedisConfigImpl;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @author xiaoyc
 * @date 2021/2/22 0022 10:25
 */
@Component
public class WxUtil {
    private static final String APP_ID = "wx5c5b501bd0c53171";

    private static final String SECRET = "f8ea79047376335ead7672e8114c98f6";

    private static final String REDIS_HOST = "182.92.229.1";


    /**
     * @description 基本配置
     *
     * @params []
     * @return cn.binarywang.wx.miniapp.api.WxMaMediaService
     * @author xiaoyinchuan
     * @date 2021/1/20 0020 10:26
     **/
    public WxMaService getWxMaService() {
        WxMaService wxMaService = new WxMaServiceImpl();
        WxMaRedisConfigImpl redisConfig = new WxMaRedisConfigImpl(new JedisPool(REDIS_HOST));
        redisConfig.setAppid(APP_ID);
        redisConfig.setSecret(SECRET);
        wxMaService.setWxMaConfig(redisConfig);
        return wxMaService;
    }

}
