package com.yizhan.cases;

import com.yizhan.config.TestConfig;
import com.yizhan.model.GetUserInfoCase;
import com.yizhan.model.InterfaceName;
import com.yizhan.model.UpdateUserInfoCase;
import com.yizhan.model.User;
import com.yizhan.utils.ConfigFile;
import com.yizhan.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
public class UpdateUserInfoTest {



    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        TestConfig.updateUserInfoUrl= ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        System.out.println(updateUserInfoCase.toString());
        System.out.println( TestConfig.updateUserInfoUrl);
        
        int result = getResult(updateUserInfoCase);
        System.out.println("打印"+result);

        Thread.sleep(3000);
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        System.out.println("打印"+user.toString());

        Assert.assertNotNull(user);
        Assert.assertNotNull(result);


    }


    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",2);
        TestConfig.updateUserInfoUrl= ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        System.out.println(updateUserInfoCase.toString());
        System.out.println( TestConfig.updateUserInfoUrl);

        int result = getResult(updateUserInfoCase);
        System.out.println("打印"+result);

        Thread.sleep(3000);
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        System.out.println("打印"+user.toString());

        Assert.assertNotNull(user);
        Assert.assertNotNull(result);

    }

        private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
            HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
            JSONObject param = new JSONObject();
            param.put("id",updateUserInfoCase.getUserId());
            param.put("userName",updateUserInfoCase.getUserName());
            param.put("sex",updateUserInfoCase.getSex());
            param.put("age",updateUserInfoCase.getAge());
            param.put("permission",updateUserInfoCase.getPermission());
            param.put("isDelete",updateUserInfoCase.getIsDelete());


        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String  reslut;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
       reslut =  EntityUtils.toString(response.getEntity(),"utf-8");



        return Integer.parseInt(reslut);

    }

}
