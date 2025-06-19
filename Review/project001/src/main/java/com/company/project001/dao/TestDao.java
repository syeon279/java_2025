package com.company.project001.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {
    @Select("SELECT NOW()")
    String readTime();
}
