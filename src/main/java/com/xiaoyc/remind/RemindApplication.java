package com.xiaoyc.remind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.xiaoyc.remind.dao")
@EnableScheduling
public class RemindApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemindApplication.class, args);
    }

}
