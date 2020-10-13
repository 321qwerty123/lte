package com.example.lte;

import cn.dev33.satoken.SaTokenManager;
import cn.dev33.satoken.spring.SaTokenSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SaTokenSetup
@SpringBootApplication
public class LteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LteApplication.class, args);
        System.out.println("启动成功：sa-token配置如下：" + SaTokenManager.getConfig());
    }

}
