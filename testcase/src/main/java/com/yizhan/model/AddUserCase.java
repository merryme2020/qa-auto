package com.yizhan.model;

import lombok.Data;
@Data
public class AddUserCase {
    private int id;//id自增，可省略
    private String userName;
    private String passWord;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
