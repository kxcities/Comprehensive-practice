package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.google.common.collect.ImmutableMap;

@RestController
public class UserController extends BaseController{
	@Resource
	UserService userService;
	@PostMapping(path = "/login/loginService")
	public String userLogin(HttpServletRequest request, HttpServletResponse respond,HttpSession session ,@RequestBody Map<String,String> inputParam) {
		String userName = inputParam.get("U_keyword");
		String password = inputParam.get("U_password");
		User user = new User(userName,password);
		String allow = null;
		try {
			allow = userService.userLogin(user);
		} catch (Exception e) {
			System.out.print("Exception");
			return errorRespond();
		}
		if(allow.equals("success")) {
			String sessionId = session.getId();
			SEEVLET_CONTEXT.setAttribute(user.getUserName(),sessionId);
			Cookie session_id= new Cookie("JSESSIONID",sessionId);
			session_id.setPath("/");
			Cookie cookie_user = new Cookie("username",user.getUserName());
			cookie_user.setPath("/");
			respond.addCookie(session_id);
			respond.addCookie(cookie_user);
		}
		Map<String,Object> jsonMap= ImmutableMap.of("result",allow);
		return passRespond(jsonMap);
	}
	@PostMapping(path = "/login/createService")
	public String userCreate(@RequestBody Map<String,String> inputParam) {
		String userName = inputParam.get("U_keyword");
		String password = inputParam.get("U_password");
		String allow = null ;
		try {
			allow = userService.userCreate(new User(userName,password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String,Object> jsonMap = ImmutableMap.of("result", allow);
		return passRespond(jsonMap);
	}
	
	@PostMapping(path = "/home/exitService")
	public String userExit(HttpSession session,@RequestBody Map<String,String> inputParam) {
		if(false== sessionCheck(session)) {
			return sessionFailureRespond();
		}
		String result = "success";
		SEEVLET_CONTEXT.removeAttribute(session.getId());
		session.removeAttribute("loginUser");
		Map<String,Object> jsonMap = ImmutableMap.of("result", result);
		return passRespond(jsonMap);
	}
	
}
