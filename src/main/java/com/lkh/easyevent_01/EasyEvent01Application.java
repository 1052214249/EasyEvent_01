package com.lkh.easyevent_01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lkh.easyevent_01.mapper")
public class EasyEvent01Application {

    public static void main(String[] args) {
        SpringApplication.run(EasyEvent01Application.class, args);
    }

}
