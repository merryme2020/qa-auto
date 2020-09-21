package com.yizhan.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass1 {

    public void stu1(){
        System.out.println("GroupOnClass1中的 stu1111运行");

    }

    public void stu2(){
        System.out.println("GroupOnClass1中的 stu222运行");

    }
}
