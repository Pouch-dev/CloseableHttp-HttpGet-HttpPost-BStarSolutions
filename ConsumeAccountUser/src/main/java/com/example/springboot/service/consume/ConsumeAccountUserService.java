package com.example.springboot.service.consume;

import com.example.springboot.entity.ConsumeAccountUser;
import com.example.springboot.entity.payload.CsAccountUser;
import com.example.springboot.service.AccountUserService;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ConsumeAccountUserService {

    @Autowired
    private AccountUserService userService;

    private static String URL = "http://localhost:9090/api/account";


    public Object callGet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);

        String us = "admin";    String pw = "123";
        String encoding = Base64.getEncoder().encodeToString((us+":"+pw).getBytes("UTF-8"));
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Basic "+ encoding);

        httpGet.addHeader("Content-Type", "Application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        Gson gson = new Gson();
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);
        //CsAccountUser userGET = gson.fromJson(responseString, CsAccountUser.class);
        //ConsumeAccountUser userGET = gson.fromJson(responseString, ConsumeAccountUser.class);
        Object userGET = gson.fromJson(responseString, Object.class);

        System.out.println("Status: "+ httpResponse.getStatusLine().getStatusCode());
        httpClient.close();

        //userService.save(userGET);
        //userService.saveAll(userGET.getAccountUserList());

        return userGET;
    }


    public Object callPost(ConsumeAccountUser user) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);

        Gson gson = new Gson();
        // set body (jsonString) to httpPost
        String bodyString = gson.toJson(user);
        httpPost.setEntity(new StringEntity(bodyString));

        String us = "admin";    String pw = "123";
        String encoding = Base64.getEncoder().encodeToString((us+":"+pw).getBytes("UTF-8"));
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic "+ encoding);

        httpPost.addHeader("Content-Type","Application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);
        ConsumeAccountUser userPost = gson.fromJson(responseString, ConsumeAccountUser.class);

        System.out.println("Status: "+ httpResponse.getStatusLine().getStatusCode());
        httpClient.close();

        userService.save(userPost);
        return  userPost;
    }
}
