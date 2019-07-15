package com.chryl.utils;

import com.alibaba.fastjson.JSON;

/**
 * FastJson
 * <p>
 * Created By Chr on 2019/6/28.
 */
public class FastJsonUtil {
    /**
     * bean->jsonStr
     *
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj) {
        return JSON.toJSONString(obj);
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
        return JSON.parseObject(jsonStr, objClass);
    }

    /**
     * 格式化jsonStr
     *
     * @param obj
     * @return
     */
    public static String bean2JsonFormatter(Object obj) {
        return JSON.toJSONString(obj, true);
    }
}