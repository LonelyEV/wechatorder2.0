/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: JsonUtil
 * Author:   屈志刚
 * Date:     2018/4/25 0025 13:57
 * Description: json工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 功能描述: <br>
     * 〈对象转字符串〉
     *
     * @param object
     * @return: java.lang.String
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:14
     */
    public static String toJson(Object object) {

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 功能描述: <br>
     * 〈字符串转对象〉
     *
     * @param string
     * @param classType
     * @return: java.lang.Object
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:15
     */
    public static Object fromJson(String string, Class classType) {

        try {
            return objectMapper.readValue(string, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述: <br>
     * 〈字符串转对象〉
     *
     * @param string
     * @param typeReference
     * @return: java.lang.Object
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:15
     */
    public static Object fromJson(String string, TypeReference typeReference) {

        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
