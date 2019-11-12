/**
 * @filename FruitManage.java
 * @author lg
 * @date 2019年3月30日 下午3:27:27
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.byzx;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;

public class FruitManage {
	
	/*使用SDK方式调用百度云接口*/
	private static AipImageClassify client = new AipImageClassify("15871052", "tqDlru9AERM5USZGQTkle6Xu", "Wp51Aa8Fl6TbgXNmdNtZAk8EpSw6428C");	
	
	public static void fruitSDK() throws IOException {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("top_num", "5");
	    options.put("filter_threshold", "0.7");
	    options.put("baike_num", "0");
	    // 参数为本地路径
	    String image = "D:/fruit/3.jpg";
	    JSONObject res = client.dishDetect(image, options);
	    System.out.println(res.toString(2));

	    // 参数为二进制数组
	   /* byte[] file =  FileUtil.readFileByBytes(image);
	    JSONObject res = client.dishDetect(file, options);
	    System.out.println(res.toString(2));*/
	}


	    public static String fruitAPI() {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/classify/ingredient";
	        try {
	            // 本地文件路径
	        	String image = "D:/fruit/3.jpg";
	            byte[] imgData = FileUtil.readFileByBytes(image);
	            String imgStr = Base64Util.encode(imgData);
	            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
	            String param = "image=" + imgParam;
	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = "24.c05b0953c14ff1694d5a814bfdf6be00.2592000.1556526823.282335-15871052";
	            //AuthService.getAuth("tqDlru9AERM5USZGQTkle6Xu", "Wp51Aa8Fl6TbgXNmdNtZAk8EpSw6428C");

	            String result = HttpUtil.post(url, accessToken, param);
	            System.out.println("...."+result);
	            JSONObject jsonObject = new JSONObject(result);
	            JSONObject json= (JSONObject)jsonObject.getJSONArray("result").get(0); 
	            System.out.println("name..........."+json.get("name"));
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


	
	public static void main(String[] args) throws IOException {
		//fruitSDK();
		fruitAPI();
	}
}
