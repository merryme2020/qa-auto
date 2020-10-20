package com.yizhan.utils;

import com.yizhan.model.InterfaceName;

import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application");
    //拼接URL
    public static String getUrl(InterfaceName name ){
        String address = bundle.getString("test.url");
        String uri ="";//依次判断赋值的 uri
        String testUrl ;
       if (name==InterfaceName.GETUSERLIST){
           uri = bundle.getString("test.getUserList.uri");
       }
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("test.login.uri");

        }
        if (name==InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("test.updateUserInfo.uri");

        }
        if (name==InterfaceName.GETUSERINFO){
            uri = bundle.getString("test.getUserInfo.uri");

        }

        if (name==InterfaceName.ADDUSERINFO){
            uri = bundle.getString("test.addUser.uri");
        }


        testUrl = address+uri;


     return  testUrl;


    }


}
