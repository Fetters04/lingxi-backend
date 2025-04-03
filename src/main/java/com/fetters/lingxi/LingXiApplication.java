package com.fetters.lingxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 灵犀伙伴匹配系统启动
 *
 * @author Fetters
 */
@SpringBootApplication
@MapperScan("com.fetters.lingxi.mapper")
@EnableScheduling
public class LingXiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LingXiApplication.class, args);
    }

}
