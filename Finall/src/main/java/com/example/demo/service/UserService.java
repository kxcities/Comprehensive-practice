package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.serviceInterface.UserInterface;

@Service
public class UserService {
	@Resource
	private UserInterface userInterface;
	public String userLogin(User user) throws Exception {
		Integer i = userInterface.userLogin(user);
		if(i == 1) {
			return "success";
		}
		return "fail";
	}

	public String userCreate(User user) throws Exception{
		Integer i = null;
	i = userInterface.userFind(user.getUserName());
	if(i == 0) {
		userInterface.userCreate(user);
		return "success";
	}
		return "fail";
	}
}
