package com.yizhan.model;

import lombok.Data;

@Data

public class User {

    private int id;
    private String userName;;
    private String passWord;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;

}
