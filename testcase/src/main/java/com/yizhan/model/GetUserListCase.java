package com.yizhan.model;

import lombok.Data;

@Data
public class GetUserListCase {

    private int id;//可省略
    private String userName;
    private int age;
    private  String sex;
    private  String expected;
}
