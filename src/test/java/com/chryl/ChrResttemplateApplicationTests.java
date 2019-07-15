package com.chryl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chryl.model.SbProtModel;
import com.chryl.utils.GsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrResttemplateApplicationTests {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        String url = "http://127.0.0.1:8099/sb/queryAll";
        try {
            //创建
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //get请求
            HttpGet httpGetURL = new HttpGet(url);
            //
            CloseableHttpResponse httpResponse = httpClient.execute(httpGetURL);
            //得到相应entity
            HttpEntity entity = httpResponse.getEntity();
            //
            String body = EntityUtils.toString(entity, "UTF-8");
            //
            Map map1 = GsonUtil.json2Bean(body, Map.class);

            map1.forEach((k, v) -> {
                System.err.println(k);
                System.err.println(v);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //list ->map
    @Test
    public void show1() {
        String url = "http://127.0.0.1:8099/sb/queryAll";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();

        System.out.println(body);

        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);

        //
        System.out.println("===");
        JSONObject jsonObject = JSONObject.parseObject(body);
        String statusStr = jsonObject.getString("status");
        if (statusStr.equals("success")) {
            String dataStr = jsonObject.getString("data");
            List<Map<String, String>> list = JSON.parseObject(dataStr, List.class);
            System.out.println(list);
            for (Map<String, String> stringStringMap : list) {
                System.out.println(stringStringMap);
            }
        }
    }

    //list ->bean
    @Test
    public void show2() {
        String url = "http://127.0.0.1:8099/sb/queryAll";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();

        System.out.println(body);

        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);
        //
        System.out.println("======");
        JSONObject jsonObject = JSONObject.parseObject(body);
        String statusStr = jsonObject.getString("status");
        if (statusStr.equals("success")) {
            String dataStr = jsonObject.getString("data");
            //第一次转换
            List list = JSON.parseObject(dataStr, List.class);
            for (Object object : list) {
                //第二次转化
                SbProtModel sbProtModel = JSON.parseObject(object.toString(), SbProtModel.class);
                System.out.println(sbProtModel);
//                System.out.println(object);
            }
        }
    }



}
