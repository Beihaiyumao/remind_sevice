package com.xiaoyc.remind;

import com.xiaoyc.remind.dao.UserMapper;
import com.xiaoyc.remind.entity.BirthdayRemind;
import com.xiaoyc.remind.service.BirthdayRemindService;
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
    public void add() {

    }

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void redisTest() {
        redisUtil.set("xyc", "ts");
    }

    @Resource
    private BirthdayRemindService birthdayRemindService;

    @Test
    public void addBirthday() {
        BirthdayRemind remind = new BirthdayRemind();
        remind.setGmtRemind("2021年2月22日14:49:43");
        remind.setOpenId("oIQBN5T9rmovZ-nH-BO4-b109_2A");
        remind.setTmplId("qjQPnre4KBKETmfyNtbhxKK-72j2qt9o9lLktszTpq0");
        remind.setRemarks("生日提醒测试");
        birthdayRemindService.save(remind);
    }
}
