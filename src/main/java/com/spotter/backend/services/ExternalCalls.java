package com.spotter.backend.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class ExternalCalls {
    CloseableHttpClient httpclient = HttpClients.createDefault();

    public String postToImgUr(String body) throws Exception {
        HttpPost httpPost = new HttpPost("https://api.imgur.com/3/image");
        httpPost.setEntity(new StringEntity(body));
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "Application/json");
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer f4d4ad23bda72a670b426d7b2efaad793613f101");
        HttpEntity response =  httpclient.execute(httpPost).getEntity();
        return EntityUtils.toString(response);
    }

}