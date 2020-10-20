package com.yizhan.model;

import lombok.Data;

@Data
public class LonginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;
}
