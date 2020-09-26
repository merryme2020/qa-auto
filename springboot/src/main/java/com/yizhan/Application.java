package com.yizhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication  //意味着给它托管了
@ComponentScan("com.yizhan.*")  //你要扫描哪些组件-扫描哪个包下的类，你托管给我，让我进行管理

public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);//固定写法 args参数，叫什么都可以
    }

}