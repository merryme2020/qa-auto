package com.yizhan.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController//告诉Controller,我是需要被你扫描的这个类
@Api(value = "/",description ="这是我全部的get方法" )

public class MyGetMethod {

    @RequestMapping(value = "/getCookies" ,method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")

    public String getCookies(HttpServletResponse response){
        //HttpserverletRequest  装请求信息的类
        //HttpserverletRequest  装响应信息的类
        Cookie cookie = new Cookie("longin","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";

    }

    /****
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
      Cookie[] cookies =   request.getCookies();
      //判断一个对象为空，if (cookies==null)
      if (Objects.isNull(cookies)){
          return "你必须携带cookies信息来";
      }
      for (Cookie cookie: cookies){
          if (cookie.getName().equals("login")  &&
                  cookie.getValue().equals("true")){
              return  "这是一个需要携带cookies信息才能访问的get请求";

          }
      }

        return "你必须携带cookies信息来";
    }

    /*******
     * 第一种需要携带参数才能访问的get请求
     * 第一种实现方式  url=key=value&key=value
     * 我们来模拟获取商品列表的接口
     */
@RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
@ApiOperation(value = "需要携带参数才能访问的get请求方法1",httpMethod = "GET")
public Map<String,Integer>  getList(@RequestParam Integer start,
                                                              @RequestParam Integer end){
    Map<String,Integer> myList = new HashMap<>();
    myList.put("鞋",400);
    myList.put("干脆面",1);
    myList.put("衬衫",300);

return  myList;

}

/******
 * 第二种需要携带参数才能访问的get请求
 * url:ip/get/with./param/10/20
 */
@RequestMapping(value ="/get/with/param/{start}/{end}")
@ApiOperation(value = "需要携带参数才能访问的get请求方法2",httpMethod = "GET")
public Map<String,Integer> myGetList(@PathVariable Integer start,
                                                                @PathVariable Integer end){
          Map<String,Integer> myList = new HashMap<>();
          myList.put("鞋",400);
          myList.put("干脆面",1);
          myList.put("衬衫",300);

    return  myList;
}
}