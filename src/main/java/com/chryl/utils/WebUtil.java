package com.chryl.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * httpclient
 * <p>
 * Created By Chr on 2019/7/15.
 */
public class WebUtil {

    /**
     * httpclient ---get
     *
     * @param url
     * @return
     */
    public static Map<String, Object> sendGet(String url) {
        Map<String, Object> map = new HashMap<>();
        try {
            //创建
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //get请求
            HttpGet httpGetURL = new HttpGet(url);
            //
            CloseableHttpResponse httpResponse = httpClient.execute(httpGetURL);
            //得到相应entity
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                return null;
            }
            //
            String json = EntityUtils.toString(entity, "UTF-8");
            //
            map = GsonUtil.json2Bean(json, Map.class);

            System.out.println(entity);
            System.err.println(json);
            System.out.println(map);
            System.out.println("===");

            //map
            map.forEach((k, v) -> {
                System.err.println(k);
                System.err.println(v);
            });
            //List 遍历
//            list.stream().forEach(System.out::println);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
