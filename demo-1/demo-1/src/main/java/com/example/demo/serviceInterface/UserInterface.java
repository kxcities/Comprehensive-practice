package com.example.demo.serviceInterface;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserInterface {
	Integer userLogin(User user);
	Integer userCreate(User user);
	Integer userFind(String userName);
}
