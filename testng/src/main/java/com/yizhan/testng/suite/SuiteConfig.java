package com.yizhan.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/******
 * 所有测试套件配置类，写测试套件之前需要运行的方法、共有的东西
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite运行了");

    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite运行了");

    }

    @BeforeTest

    public void beforeTest(){
        System.out.println("beforeTest");
    }


    @AfterTest
    public void  afterTest(){
        System.out.println("afterTest");
    }
}
