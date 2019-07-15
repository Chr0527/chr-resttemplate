package com.chryl.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created By Chr on 2019/6/28.
 */
public class GsonUtil {
    //1.第一种gson:
    private static Gson gson = new GsonBuilder().create();

    /*

    //2.第二种gson:格式化输出、日期时间及其它(比较全)
    private static  Gson gson = new GsonBuilder()
            //序列化null,null值可以显示
            .serializeNulls()
            // 设置日期时间格式，另有2个重载方法
            // 在序列化和反序化时均生效
            .setDateFormat("yyyy-MM-dd")//yyyy-MM-dd HH:mm:ss
            // 禁此序列化内部类
            .disableInnerClassSerialization()
            //生成不可执行的Json（多了 )]}' 这4个字符）:生成不可以用的Json字符串
            .generateNonExecutableJson()
            //禁止转义html标签
            .disableHtmlEscaping()
            //格式化输出
            .setPrettyPrinting()
            //在序列化和反序列化时，要不要将该字段接入操作:是否序列化/反序列化
            .excludeFieldsWithoutExposeAnnotation()
            //new Instance
            .create();

    */

    //3.第三章gson:序列化null,null值可以显示
    //Gson gson = new GsonBuilder().serializeNulls().create();


    /**
     * bean->jsonStr
     *
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * jsonStr->bean
     *
     * @param jsonStr
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    /**
     * 格式化jsonStr
     *
     * @param uglyJsonStr
     * @return
     */
    public static String jsonFormatter(String uglyJsonStr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonStr);
        return gson.toJson(je);
    }
}
