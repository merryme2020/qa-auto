package com.yizhan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//加载配置文件
@EnableSwagger2
public class SwaggerConfig {

    //固定写法

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")//配置整个访问的路径，根路径
                .select()
                .paths(PathSelectors.regex("/.*"))//选择器  正则匹配server里哪些需要访问的方法
                .build();

    }

    private ApiInfo apiInfo() {

        return  new ApiInfoBuilder().title("我的接口文档")
                .contact(new Contact("merryme","","757204311@qq.com"))
                .description("这是我的swagger-ui生成的接口文档") //注释
                .version("V1.0") //版本
                .build();


    }

}
