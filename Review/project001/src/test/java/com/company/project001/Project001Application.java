package com.company.project001;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.company.project001.service.TestService;

@SpringBootTest
@Import(TestConfig.class) // ✅ 이거 추가
class Project001ApplicationTests {

    @Autowired
    TestService service;

    @Test
    void contextLoads() {
        System.out.println("🟢 결과: " + service.test());
    }
}
