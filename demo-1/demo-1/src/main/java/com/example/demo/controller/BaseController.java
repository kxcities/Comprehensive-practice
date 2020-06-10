package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.example.demo.model.User;

public class BaseController {
	static SerializeConfig CONFIG = new SerializeConfig();
	static {
		String dateFormat = "yyyy-MM-dd HH:mm";
		CONFIG.put(Timestamp.class, new SimpleDateFormatSerializer(dateFormat));
	}
	@Autowired
	protected  ServletContext SEEVLET_CONTEXT;
	protected String sessionFailureRespond() {
		return httpPackage(httpFailureDataPackage());
	}
	protected String errorRespond() {
		return httpPackage(httpErrorDataPackage());
	}
	protected String passRespond(Map<String,Object> jsonMap) {
		return httpPackage(httpPassDataPackage(jsonMap));
	}
	protected String httpPackage(Object httpdata) {
		Map<String, Object> http = new HashMap<String, Object>();
		http.put("code", 0);
		http.put("msg", "");
		http.put("data", httpdata);
		return JSON.toJSONString(http,CONFIG);
	}
	protected Object httpPassDataPackage(Map<String,Object> jsonValue) {
		Map<String, Object> dataValue = new HashMap<String, Object>(jsonValue);
		dataValue.put("state", "Pass");
		return JSONObject.toJSON(dataValue);
	}
	protected Object httpErrorDataPackage() {
		Map<String, Object> dataValue = new HashMap<String, Object>();
		dataValue.put("state", "Error");
		return JSONObject.toJSON(dataValue);
	}
	protected Object httpFailureDataPackage() {
		Map<String, Object> dataValue = new HashMap<String, Object>();
		dataValue.put("state", "Failure");
		return JSONObject.toJSON(dataValue);
	}
	protected boolean sessionCheck(HttpSession session) {
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return false;
		}
		String sessionId= session.getId();
		String userId = user.getUserName();
		String oldsessionId = (String)SEEVLET_CONTEXT.getAttribute(userId);
		if(oldsessionId != null && oldsessionId.equals(sessionId)) {
			return true;
		}
		else {
			return false;
		}
	} 
}
