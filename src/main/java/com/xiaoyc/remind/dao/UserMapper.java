package com.xiaoyc.remind.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `user` VALUES ('2') ")
    void add(Integer id);
}
