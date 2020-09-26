package com.yizhan.server;

import com.yizhan.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的 post请求")
@RequestMapping("/v1")
public class MypostMethod {
    //这个变量是用来装cookie信息的
    private  static Cookie cookie;
    //用户登录成功获取到cookies,再访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,//value = "userName"前端调用时候显示的名字
                        @RequestParam(value = "passWord",required = true) String passWorld){
        if (userName.equals("merryme")&&passWorld.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);

            return "恭喜你登录成功了！";

        }

        return "用户名或密码错误";

    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
     public String getUserList(HttpServletRequest request,
                             @RequestBody  User u){
        User user;
        //获取cookies
       Cookie[] cookies = request.getCookies();
       //验证cookies是否合法
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                     && u.getUserName().equals("merryme")
                    &&  u.getPassWord().equals("123456")
                      ){

                user = new User();
                user.setName("Nmerryme");
                user.setAge("18");
                user.setSex("男");

                return  user.toString();

            }
        }

       return "参数不合法";

     }


}
