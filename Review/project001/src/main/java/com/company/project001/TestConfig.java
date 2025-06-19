package com.company.project001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.company.project001.dao") // ✅ 형님의 DAO 패키지
public class TestConfig {
}
