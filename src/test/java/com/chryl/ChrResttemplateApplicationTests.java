package com.chryl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chryl.model.SbProtModel;
import com.chryl.response.ReturnResult;
import com.chryl.response.UserInfo;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

/*
    //(1)
    Map<String, String> params = new HashMap<>();
        params.put("tableName", "emp");
        params.put("objId", "7788");
    ResponseEntity<String> forEntity2 = new RestTemplate().getForEntity("http://localhost:8085/Inter-Manage2/im/pms?tableName={tableName}&objId={objId}", String.class, params);


    String body = forEntity2.getBody();
    //rest接受的http文本转为javaBean
    TaotaoResult taotaoResult = JSON.parseObject(body, TaotaoResult.class);
    //javaBean转为json文本
    String s = JSON.toJSONString(taotaoResult);
    //json文本转为javaBean
    TaotaoResult taotaoResult1 = JSON.parseObject(s, TaotaoResult.class);


        System.out.println(taotaoResult.getData());
        System.out.println("=" + body);
        System.out.println("==" + taotaoResult.getData());
        System.out.println("===" + s);


//        System.err.println(forEntity2.getStatusCode() + "=2");
//        System.err.println(forEntity2.getStatusCodeValue() + "=3");
//        System.err.println(forEntity2.getHeaders() + "=4");
//        System.err.println(forEntity2.getClass() + "=5");



    //======================================================
    //======================================================
    //map(2):使用MultiValueMap（spring的map）可以传单传url不带？传值，直接在MultiValueMap里封装key=value（只在postForEntity中的第二个参数）
    //直接用map也可以
    MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("tableName", "emp");
        request.add("objId", "7788");
    ResponseEntity<String> stringResponseEntity = new RestTemplate().postForEntity("http://localhost:8085/Inter-Manage2/im/pms", request, String.class);

    TaotaoResult taotaoResult2 = JSON.parseObject(stringResponseEntity.getBody(), TaotaoResult.class);
        System.out.println("ces:" + taotaoResult2.getData());

    //map(3):url拼接{？}占位符
    ResponseEntity<String> stringResponseEntity2 = new RestTemplate().postForEntity("http://localhost:8085/Inter-Manage2/im/pms?tableName={？}&objId={？}", null, String.class, "emp", "7788");

    TaotaoResult taotaoResult3 = JSON.parseObject(stringResponseEntity2.getBody(), TaotaoResult.class);
        System.out.println("ces2:" + taotaoResult3.getData());
*/


    @Test
    public void sho10() {
        String url = "http://127.0.0.1:8099/user/login";
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("userName", "nanc");
        request.add("userPassword", "1234");
        List<Map<String, Object>> mapList = new ArrayList<>();
        ResponseEntity<String> resp = restTemplate.postForEntity(url, request, String.class);
        System.out.println(resp.getBody());
    }

    //Post,@RequestParam------postForEntity
    @Test
    public void sho11() {
        String url = "http://127.0.0.1:8099/rest/testm";
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("id", "12324");
        request.add("name", "nanc");

        ResponseEntity<ReturnResult> resp = restTemplate.postForEntity(url, request, ReturnResult.class);
        ReturnResult body = resp.getBody();
        UserInfo data = body.getData();
        System.err.println(data.getUserId());
        System.out.println(data);
    }

    //Get ,@RequestParam-----getForObject
    @Test
    public void sho12() {
        String url = "http://127.0.0.1:8099/rest/testp?name={name}&age={age}&clazz={clazz}";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "nanc");
        map.put("age", 34);
        map.put("clazz", "12");
        ReturnResult forObject = restTemplate.getForObject(url, ReturnResult.class, map);
        UserInfo data = forObject.getData();
        System.out.println(data);
    }

}
