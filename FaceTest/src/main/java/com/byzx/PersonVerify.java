/**
 * @filename PersonVerify.java
 * @author lg
 * @date 2019年3月28日 下午1:35:40
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.byzx;
import java.util.*;

/**
* 身份验证
*/
public class PersonVerify {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String personverify() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/person/verify";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            byte[] bytes = FileUtil.readFileByBytes("d:/IMG_20180816_102245.jpg");
            String image = Base64Util.encode(bytes);
            map.put("image",image);
            map.put("image_type", "BASE64");
            map.put("id_card_number", "1234");
            map.put("liveness_control", "NONE");
            map.put("name", "张三");
            map.put("quality_control", "NORMAL");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.401ef521efdd3cef7ae47c5c6581a9a4.2592000.1556154599.282335-15826305";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        PersonVerify.personverify();
    }
}