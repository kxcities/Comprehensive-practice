package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;

public class BaseController {
	@Autowired
	protected  ServletContext servletContext;
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
		return JSON.toJSONString(http);
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
		String oldsessionId = (String)servletContext.getAttribute(userId);
		if(oldsessionId != null && oldsessionId.equals(sessionId)) {
			return true;
		}
		else {
			return false;
		}
	}

}
