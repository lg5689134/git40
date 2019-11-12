 /**  
* @Title: Landmark.java
* @Package org.entity
* @Description: TODO该方法的主要作用：
* @author A18ccms A18ccms_gmail_com  
* @date 2018-6-8 上午10:39:01
* @blog https://blog.csdn.net/qq_34137397
* @version V1.0  
*/
package com.byzx;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

 /**   
 *    
 * 项目名称：test_face_huoti   
 * 类名称：Landmark   
 * 类描述：   关键点的实体类
 * @version    
 *    
 */
public class Landmark {
	
	private List<Double> left_eye_zhongxin = new ArrayList<Double>();	//左眼中心
	private List<Double> left_eye_top = new ArrayList<Double>();		//左眼上边
	private List<Double> right_eye_top = new ArrayList<Double>();		//右眼上边
	private List<Double> left_eye_bottom = new ArrayList<Double>();		//左眼下边
	private List<Double> right_eye_bottom = new ArrayList<Double>();	//右眼下边
	private List<Double> right_eye_zhongxin = new ArrayList<Double>();	//右眼中心
	private List<Double> nose_zhongxin = new ArrayList<Double>();		//鼻尖
	private List<Double> mouse_zhongxin = new ArrayList<Double>();		//嘴巴中心
	private List<Double> mouse__top = new ArrayList<Double>();			//嘴巴上边
	private List<Double> mouse__bottom = new ArrayList<Double>();		//嘴巴下边

	public List<Double> getLeft_eye_zhongxin() {
		return left_eye_zhongxin;
	}

	public void setLeft_eye_zhongxin(List<Double> left_eye_zhongxin) {
		this.left_eye_zhongxin = left_eye_zhongxin;
	}

	public List<Double> getRight_eye_zhongxin() {
		return right_eye_zhongxin;
	}

	public void setRight_eye_zhongxin(List<Double> right_eye_zhongxin) {
		this.right_eye_zhongxin = right_eye_zhongxin;
	}

	public List<Double> getNose_zhongxin() {
		return nose_zhongxin;
	}

	public void setNose_zhongxin(List<Double> nose_zhongxin) {
		this.nose_zhongxin = nose_zhongxin;
	}

	public List<Double> getMouse_zhongxin() {
		return mouse_zhongxin;
	}

	public void setMouse_zhongxin(List<Double> mouse_zhongxin) {
		this.mouse_zhongxin = mouse_zhongxin;
	}

	public List<Double> getLeft_eye_top() {
		return left_eye_top;
	}

	public void setLeft_eye_top(List<Double> left_eye_top) {
		this.left_eye_top = left_eye_top;
	}

	public List<Double> getRight_eye_top() {
		return right_eye_top;
	}

	public void setRight_eye_top(List<Double> right_eye_top) {
		this.right_eye_top = right_eye_top;
	}

	public List<Double> getLeft_eye_bottom() {
		return left_eye_bottom;
	}

	public void setLeft_eye_bottom(List<Double> left_eye_bottom) {
		this.left_eye_bottom = left_eye_bottom;
	}

	public List<Double> getRight_eye_bottom() {
		return right_eye_bottom;
	}

	public void setRight_eye_bottom(List<Double> right_eye_bottom) {
		this.right_eye_bottom = right_eye_bottom;
	}

	public List<Double> getMouse__top() {
		return mouse__top;
	}

	public void setMouse__top(List<Double> mouse__top) {
		this.mouse__top = mouse__top;
	}

	public List<Double> getMouse__bottom() {
		return mouse__bottom;
	}

	public void setMouse__bottom(List<Double> mouse__bottom) {
		this.mouse__bottom = mouse__bottom;
	}
	
	/**
	 * 
	* @Description: 该方法的主要作用：解析人脸检测的json数据 
	* @Title: parsingFaceJson
	* @param  @param json_str
	* @param  @return 设定文件  
	* @return  返回类型：Landmark   
	* @throws
	 */
	@SuppressWarnings("serial")
	public static Landmark  parsingFaceJson(JSONObject json_str){
		Landmark landmark = new Landmark();
		//开始解析json
		//JSONObject  dataJson=new JSONObject(json_str);
		//找到result节点
		JSONObject  response_result=json_str.getJSONObject("result");
		//继续找face_list节点
		JSONArray face_list_jsonArray=response_result.getJSONArray("face_list");
		JSONObject face_list_jsonObject=face_list_jsonArray.getJSONObject(0);
		//找到landmark（关键点）节点，4个关键点位置，左眼中心、右眼中心、鼻尖、嘴中心
		final JSONArray landmark_jsonArray=face_list_jsonObject.getJSONArray("landmark");
		//左眼中心
		landmark.setLeft_eye_zhongxin(new ArrayList<Double>(){
			{add((Double) landmark_jsonArray.getJSONObject(0).get("y")); 
			add((Double) landmark_jsonArray.getJSONObject(0).get("x"));}
			});
		//右眼中心
		landmark.setRight_eye_zhongxin(new ArrayList<Double>(){
			{add((Double) landmark_jsonArray.getJSONObject(1).get("y")); 
			add((Double) landmark_jsonArray.getJSONObject(1).get("x"));}
			});
		//鼻尖
		landmark.setNose_zhongxin(new ArrayList<Double>(){
			{add((Double) landmark_jsonArray.getJSONObject(2).get("y")); 
			add((Double) landmark_jsonArray.getJSONObject(2).get("x"));}
			});
		//嘴中心
		landmark.setMouse_zhongxin(new ArrayList<Double>(){
			{add((Double) landmark_jsonArray.getJSONObject(3).get("y")); 
			add((Double) landmark_jsonArray.getJSONObject(3).get("x"));}
			});
		//继续找landmark72节点
		final JSONArray landmark72_jsonArray=face_list_jsonObject.getJSONArray("landmark72");
		//左眼上边
		landmark.setLeft_eye_top(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(14).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(14).get("x"));}
			});
		
		//左眼下边
		landmark.setLeft_eye_bottom(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(19).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(19).get("x"));}
			});
		//右眼上边
		landmark.setRight_eye_top(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(32).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(32).get("x"));}
			});
		//右眼下边
		landmark.setRight_eye_bottom(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(36).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(36).get("x"));}
			});
		//嘴巴上边
		landmark.setMouse__top(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(60).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(60).get("x"));}
			});
		//嘴巴下边
		landmark.setMouse__bottom(new ArrayList<Double>(){
			{add((Double) landmark72_jsonArray.getJSONObject(70).get("y")); 
			add((Double) landmark72_jsonArray.getJSONObject(70).get("x"));}
			});
		return landmark;
	}
	


	
}
