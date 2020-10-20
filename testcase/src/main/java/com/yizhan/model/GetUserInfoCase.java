package com.yizhan.model;

import lombok.Data;

@Data
public class GetUserInfoCase {

    private int id;  //可省略
    private String userId;
    private String expected;


}
