package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GossipService;
import com.google.common.collect.ImmutableMap;
@RestController
public class GossipController  extends BaseController{
	@Resource
	GossipService gossipService;
	
	@PostMapping(path = "/gossip/gossipUpload")
	public String gossipUpload(@RequestBody Map<String,String> inputParam) {
		String gossipText = inputParam.get("T_text");
		String gossipBlock = inputParam.get("T_block");
		String result = gossipService.gossipUpload(gossipBlock,gossipText);
		Map<String,Object> jsonMap = ImmutableMap.of("result", result);
		return passRespond(jsonMap);
	}
	
	@PostMapping(path = "gossip/gossipBlockSearch")
	public String gossipBlockSearch(@RequestBody Map<String,String> inputParam) {	
		Map<String,Object> jsonMap = null;
		String searchBlock = inputParam.get("T_block"); 
		try {
			Integer pageCur = Integer.parseInt(inputParam.get(""));
			List<String> gossipText = gossipService.gossipBlockSearch(searchBlock, pageCur);
			jsonMap = ImmutableMap.of("result", gossipText);
		}catch(Exception ex){
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(path = "gossip/gossipStatusSearch")
	public String gossipStatusSearch(@RequestBody Map<String,String> inputParam) {	
		Map<String,Object> jsonMap = null;
		try {
			Integer pageCur = Integer.parseInt(inputParam.get(""));
			Integer searchStatus = Integer.parseInt(inputParam.get("T_status"));
			List<String> gossipText = gossipService.gossipStatusSearch(searchStatus, pageCur);
			jsonMap = ImmutableMap.of("result", gossipText);
		}catch(Exception ex){
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(path = "gossip/gossipStatusUpdate")
	public String gossipStatusUpdate(@RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			String gossipText = inputParam.get("T_text");
			int status = Integer.parseInt(inputParam.get("T_status"));
			String result = gossipService.gossipUpdateStatus(gossipText, status);
			jsonMap = ImmutableMap.of("result", result);
			return passRespond(jsonMap);	
		}catch(Exception ex) {
			return errorRespond();
		}
	}
}
