package com.xiaoyc.remind;

import com.xiaoyc.remind.dao.UserMapper;
import com.xiaoyc.remind.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RemindApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void add(){

    }

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void redisTest(){
        redisUtil.set("xyc","ts");
    }
}
