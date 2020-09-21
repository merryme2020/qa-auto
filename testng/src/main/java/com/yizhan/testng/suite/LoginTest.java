package com.yizhan.testng.suite;

import org.testng.annotations.Test;


/******
 * 逻辑控制的一个类，写<test>标签包含的那些方法
 */

public class LoginTest {

    @Test
    public void  loginTaobao(){
        System.out.println("登录淘宝成功");

    }
}
