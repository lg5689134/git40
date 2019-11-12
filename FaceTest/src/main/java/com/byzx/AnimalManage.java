/**
 * @filename animalManage.java
 * @author lg
 * @date 2019年3月30日 下午3:26:35
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.byzx;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;

public class AnimalManage {
	
	/*使用SDK方式调用百度云接口*/
	private static AipImageClassify client = new AipImageClassify("15871052", "tqDlru9AERM5USZGQTkle6Xu", "Wp51Aa8Fl6TbgXNmdNtZAk8EpSw6428C");

    /**
     * sdk方式
     * @comment 
     * @throws IOException
     * @version 1.0
     */
	public static void animalSDK() throws IOException {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("baike_num", "0");//返回百科结果
	    
	    
	    // 参数为本地路径
	    //String image = "D:/my-phone照片/IMG_20171209_130300.jpg";
	    String image = "D:/animal/6.jpg";
	    //String image = "D:/my-phone照片/IMG_20161126_180117.jpg";
	   // String image = "D:/my-phone照片/2019家中/IMG_20180930_110226_1543267800566.jpg";
	   // String image = "D:/my-phone照片/柞水溶洞20180806/IMG_20180816_143424.jpg";
	    JSONObject res = client.advancedGeneral(image, options);
	    System.out.println(res.toString(2));

	    // 参数为二进制数组
	    /*byte[] file =  FileUtil.readFileByBytes(image);
	    res = client.advancedGeneral(file, options);
	    System.out.println(res.toString(2));*/
	}
	/**
	 * @comment rest-api方式,相对比较准确
	 * @return
	 * @version 1.0
	 */
	public static String animalAPI() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            // 本地文件路径
        	//  String image = "D:/my-phone照片/IMG_20171209_130300.jpg";
    	   // String image = "D:/my-phone照片/IMG_20161126_180117.jpg";
    	   // String image = "D:/my-phone照片/2019家中/IMG_20180930_110226_1543267800566.jpg";
    	   // String image = "D:/my-phone照片/柞水溶洞20180806/IMG_20180816_143424.jpg";
           String image = "D:/animal/2.jpg";
        	  byte[] imgData = FileUtil.readFileByBytes(image);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&top_num=" + 6+"&baike_num=0";

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.c05b0953c14ff1694d5a814bfdf6be00.2592000.1556526823.282335-15871052";
           //AuthService.getAuth("tqDlru9AERM5USZGQTkle6Xu", "Wp51Aa8Fl6TbgXNmdNtZAk8EpSw6428C");
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


	
	public static void main(String[] args) throws IOException {
		//animalSDK();
		animalAPI();
	}
}
