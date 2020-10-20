package com.yizhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
/***
 * 入库程序不用写扫描组件和包
 */
import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;
    public static void main(String[] args) {

        Application.context = SpringApplication.run(Application.class,args);

    }
    @PreDestroy
    public  void close(){
        Application.context.close();

    }
}
