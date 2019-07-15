/*
package com.chryl.utils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;

import java.io.IOException;
import java.util.Map;

*/
/**
 * Created By Chr on 2019/7/15.
 *//*

public class HttpClientUtil {
    public static String postFileMultiPart(String url,Map<String,ContentBody> reqParam) throws ClientProtocolException, IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            // 创建httpget.
            HttpPost httppost = new HttpPost(url);
            //setConnectTimeout：设置连接超时时间，单位毫秒。
            //setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。
            //这个属性是新加的属性，因为目前版本是可以共享连接池的。
            //setSocketTimeout：请求获取数据的超时时间，单位毫秒。
            //如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
            RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(15000).build();
            httppost.setConfig(defaultRequestConfig);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for(Map.Entry<String,ContentBody> param : reqParam.entrySet()){
                multipartEntityBuilder.addPart(param.getKey(), param.getValue());
            }


            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);

            // 执行post请求.
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                //System.out.println("--------------------------------------");
                // 打印响应状态
                //System.out.println(response.getStatusLine());
                if (entity != null) {
                    String json = EntityUtils.toString(entity, "UTF-8");
                    return json;
                }
                //System.out.println("------------------------------------");
            } finally {
                response.close();

            }
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

*/
