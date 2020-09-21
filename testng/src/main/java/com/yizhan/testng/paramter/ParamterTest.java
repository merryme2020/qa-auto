package com.yizhan.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
  @Test
  @Parameters({"name","age"})
    public void paramtest1(String name, int age){
      System.out.println("name = " + name + " , age =" + age);

    }
}
