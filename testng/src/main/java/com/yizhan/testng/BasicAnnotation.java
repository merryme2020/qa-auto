package com.yizhan.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        System.out.print("Test这是测试用例1");

    }


    @Test
    public void testCase2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        System.out.print("Test这是测试用例2");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("BeforeMethod这是在测试方法之前运行的！");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.print("AfterMethod这是在测试方法之后运行的！！");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.print("beforeClass这是在类运行之前运行的方法");

}

    @AfterClass
    public void afterClass(){
        System.out.print("afterClass这是在类运行之后运行的方法");
    }

    @BeforeSuite
    public  void beforeSuite(){
        System.out.print("BeforeSuite测试套件");

    }

    @AfterSuite
    public void  afterSuite(){
        System.out.print("AfterSuite测试套件");
    }

}

