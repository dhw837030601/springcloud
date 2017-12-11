package dhw.utils;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

import dhw.consts.ErrorEnum;


	/**
	 * 
	 * @description 用于装配json格式的返回结果
	 * @ClassName: AssembleErrJsonUtil
	 * @version V1.0
	 * @author 赵以宝
	 * @Date 2016年7月15日 下午2:41:40
	 * Copyright(c) 2015 www.wallet.com  All rights reserved
	 *
	 */
	public class AssembleErrJsonUtil {
    	
   
	  	/**
	  	 * 
	  	 * @description 装配错误信息成JSON格式，支持JSONP, 并带有附加的信息，附加的信息在adata中
	  	 * @param err
	  	 * @param success_register_callback 
	  	 * @param appendData
	  	 * @return   
	  	 * @return String    返回类型 
	  	 * @throws 
	  	 * @author 赵以宝
	  	 * @date 2016年7月15日 下午2:55:16
	  	 */
    	public static String AssembleErr2Json(ErrorEnum err, String success_register_callback, JSONObject appendData ){
    		String jsonString = "";
    		try {
    			JSONObject json=new JSONObject();
    			json.put("ecode", err.getEcode());
    			json.put("emsg",err.getEmsg());
    			if(appendData != null) {
                    json.put("adata", appendData);
                }
    			
    			if (!StringUtils.isBlank(success_register_callback)) {
                    jsonString = success_register_callback + "(";
                }
    				
    			jsonString += json.toString();
    			
    			if (!StringUtils.isBlank(success_register_callback)) {
                    jsonString += ")";
                }
			 } catch (Exception e) {
				// TODO: 封装jsonError异常
				e.printStackTrace();
			 }
    		return jsonString;
    	}

    	
    	/**
    	 * 
    	 * @description 装配错误信息成JSON格式
    	 * @param @param err
    	 * @param @param success_register_callback
    	 * @param @return   
    	 * @return String    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2015年12月8日 下午5:54:39
    	 */
    	public static String AssembleErr2Json(ErrorEnum err, String success_register_callback){
    		return AssembleErr2Json(err,success_register_callback, (JSONObject)null);
    	}

    	/**
    	 * 
    	 * @description 装配错误信息成JSON格式, 返回referer
    	 * @param err
    	 * @param success_register_callback
    	 * @param referer
    	 * @return   
    	 * @return String    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2016年7月15日 下午3:31:20
    	 */
    	public static String AssembleErr2Json(ErrorEnum err, String success_register_callback, String referer){
    		JSONObject json = new JSONObject();
    		json.put("referer", referer);
    		return AssembleErr2Json(err,success_register_callback, json);
    	}

    	/**
    	 * 
    	 * @description 装配错误信息成JSON格式
    	 * @param err
    	 * @param appendData
    	 * @return   
    	 * @return String    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2016年7月15日 下午3:01:16
    	 */
    	public static String AssembleErr2Json(ErrorEnum err, JSONObject appendData ){
    		return AssembleErr2Json(err,null, appendData);
    	}

    	
    	/**
    	 * 
    	 * @description 给客户端返回错误信息
    	 * @param err
    	 * @return   
    	 * @return String    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2016年7月15日 下午3:01:33
    	 */
    	public static String AssembleErr2Json(ErrorEnum err){
    		return AssembleErr2Json(err,(String)null, (JSONObject)null);
    	}

    	
    	/**
    	 * 
    	 * @description 用ErrorEnum创建一个给客户端返回信息的JSONObject
    	 * @param restCode
    	 * @return   
    	 * @return JSONObject    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2016年7月15日 下午3:01:33
    	 */
    	public static JSONObject assembleJSON(ErrorEnum restCode) {
    		JSONObject object = new JSONObject();
    		object.put("ecode", restCode.getEcode());
    		object.put("emsg", restCode.getEmsg());
    		return object;
    	}
    	
    	/**
    	 * 
    	 * @description 创建一个给客户端成功的返回信息的JSONObject
    	 * @param restCode
    	 * @return   
    	 * @return JSONObject    返回类型 
    	 * @throws 
    	 * @author 赵以宝
    	 * @date 2016年7月15日 下午3:01:33
    	 */	
    	public static JSONObject assembleSuccessJSON() {
    		JSONObject object = new JSONObject();
    		object.put("ecode", ErrorEnum.SUCCESS.getEcode());
    		object.put("emsg", ErrorEnum.SUCCESS.getEmsg());
    		return object;
    	}
    
		/**
		 * 
		 * @description 往response写一个JSON
		 * @param msg
		 * @param response   
		 * @return void    返回类型 
		 * @throws 
		 * @author 赵以宝
		 * @date 2016年7月15日 下午2:47:12
		 */
		public static void writerJson2Response(HttpServletResponse response, JSONObject json){
			try {
				response.setContentType("text/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(json.toString());
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 
		 * @description 往response写一个json string
		 * @param msg
		 * @param response   
		 * @return void    返回类型 
		 * @throws 
		 * @author 赵以宝
		 * @date 2016年7月15日 下午2:47:12
		 */
		public static void writerJson2Response(HttpServletResponse response,String json){
			try {
				response.setContentType("text/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
	}
