package com.yaohui.caij;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.yaohui.caij.dao")
@SpringBootApplication
public class CaijApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaijApplication.class, args);
    }

}
