package com.exampl.communt.provide;

import com.alibaba.fastjson.JSON;
import com.exampl.communt.dto.GitHubOauthDto;
import com.exampl.communt.dto.GitHubUserDto;
import okhttp3.*;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class GitHubProvide {
    /**
     * 获取token
     * @param gitHubOauthDto
     * @return
     */
    public String getGitHubToken(GitHubOauthDto gitHubOauthDto){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(gitHubOauthDto));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {

//                access_token=98fa5b95d0208bb3037afef5a32f1be0f8bfacac&scope=&token_type=bearer
                String respon=response.body().string();
                String[]split=respon.split("&");
                Map<String,String>mapKey=new HashMap<>();
                for (int i=0;i<split.length;i++){
                    String[] su=split[i].split("=");
                    mapKey.put(su[0],su[1]);
                }
                if (mapKey.containsKey("access_token")){
                    return mapKey.get("access_token");
                }else {
                    return "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "";
    }
    /**
     * 获取用户信息
     * @param token
     * @return
     */
    public String getGitHubUser(String token){
        System.out.println("getGitHubToken>>>>"+token);
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?token="+token)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                System.out.println("getGitHubToken>>>>"+response.body().string());
                GitHubUserDto gitHubUserDto=JSON.parseObject(response.body().string(), GitHubUserDto.class);
//                return response.body().string();
        } catch (IOException e) {
                e.printStackTrace();
            }
        return "";
    }
}
