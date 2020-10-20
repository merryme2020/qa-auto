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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取userid为1的用户信息")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase", 1);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        JSONArray resultJson = getJsonResult( getUserInfoCase);

        User user = sqlSession.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);

        List userList = new ArrayList<>();
        userList.add(user);//把查询出的user对象放入List当中
        JSONArray jsonArray = new JSONArray(userList);//把userList转换成JSONArray
        JSONArray jsonArray1 = new JSONArray(resultJson.getString(0));

        Assert.assertEquals(jsonArray.toString(),jsonArray1.toString());


    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserId());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);


        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result =EntityUtils.toString(response.getEntity(),"utf-8");

        List reslutList = Arrays.asList(result);
        JSONArray array = new JSONArray( reslutList);


        return array;

    }
}
