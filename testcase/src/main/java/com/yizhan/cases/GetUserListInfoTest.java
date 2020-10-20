package com.yizhan.cases;

import com.yizhan.config.TestConfig;
import com.yizhan.model.GetUserInfoCase;
import com.yizhan.model.GetUserListCase;
import com.yizhan.model.InterfaceName;
import com.yizhan.model.User;
import com.yizhan.utils.ConfigFile;
import com.yizhan.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetUserListInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserListInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase",1);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        System.out.println(getUserListCase.toString());
        System.out.println(  TestConfig.getUserInfoUrl );
        //发送请求获取结果
        JSONArray resultJson = getJsonResult(getUserListCase);


        //验证
       // 当初设计case它的预期结果是一个执行的sql语句
        List<User> userList = sqlSession.selectList(getUserListCase.getExpected(),getUserListCase);
        //迭代 userList
        for (User u: userList){
            System.out.println("获取的user:"+u.toString());

        }


        JSONArray userListJson = new JSONArray(userList);//userList转换成 JSONArray

        Assert.assertEquals(userListJson.length(),resultJson.length());//判断长度是否一样

        for (int i = 0; i < resultJson.length(); i++){
            JSONObject except = (JSONObject) resultJson.get(i);
            JSONObject actual  = (JSONObject) userListJson.get(i);
            Assert.assertEquals(except.toString(),actual.toString());

        }

    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        String result;

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

       result =  EntityUtils.toString(response.getEntity(),"utf-8");

       JSONArray jsonArray = new JSONArray(result);


        return  jsonArray;
    }
}
