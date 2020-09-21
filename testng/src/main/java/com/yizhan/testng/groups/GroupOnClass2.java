package com.yizhan.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {



    public void stu1(){
        System.out.println("GroupOnClass222中的  stu1运行");

    }



    public void stu2(){
        System.out.println("GroupOnClass222中的 stu2运行");

    }

}
