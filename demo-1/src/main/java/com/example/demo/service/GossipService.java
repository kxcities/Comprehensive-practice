package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.serviceInterface.GossipInterface;

@Service
public class GossipService {
	@Resource
	GossipInterface gossipInterface;
	public String gossipUpload(String gossipBlock, String gossipText) {
		// TODO Auto-generated method stub
		try {
			gossipInterface.gossipUpload(gossipBlock,gossipText);
		}catch(Exception ex) {
			ex.printStackTrace();
			return "fail";
		}
		return "success";
	}
	public List<String> gossipBlockSearch(String searchBlock, int pageCur) throws Exception{
		return gossipInterface.gossipBlockSearch(searchBlock, (pageCur - 1) * PAGE_NUM , PAGE_NUM);
	}
	public List<String> gossipStatusSearch(int searchStatus, int pageCur ) throws Exception{
		return gossipInterface.gossipStatusSearch(searchStatus, (pageCur - 1) * PAGE_NUM, PAGE_NUM);
	}
	public String gossipUpdateStatus(String gossipText, int status) {
		try {
			gossipInterface.gossipUpdateStatus(gossipText, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
	}
	final int PAGE_NUM = 10;
}
