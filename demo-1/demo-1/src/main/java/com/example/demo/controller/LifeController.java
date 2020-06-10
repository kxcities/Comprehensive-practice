package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.LifeShareByteItem;
import com.example.demo.model.LifeShareItem;
import com.example.demo.service.LifeService;
import com.example.demo.tool.PicTool;
import com.google.common.collect.ImmutableMap;

@RestController
public class LifeController extends BaseController{
	@Resource
	LifeService lifeService;
	@PostMapping(value = "home/life/lifeUpload")
	public String friendsFindUpload(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			
			String text = inputParam.get("A_text");
			String picture = inputParam.get("A_url");
			LifeShareByteItem item = new LifeShareByteItem();
			item.setPicture(PicTool.base64Decode(picture));
			item.setText(text);
			item.setUserName("dssd");
			String result = lifeService.LifeShareUpload(item);
			jsonMap = ImmutableMap.of("result", result);
		}catch(Exception ex) {
			ex.printStackTrace();
			jsonMap = ImmutableMap.of("result", "fail");
		}
		return passRespond(jsonMap);
	}
	@PostMapping(value = "home/life/lifeShareDownload")
	public String friendsFindDownload(HttpSession session, @RequestBody Map<String, String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			Integer curPage = Integer.parseInt(inputParam.get(""));
			List<LifeShareItem> items = lifeService.LifeShareDownload(curPage);
			jsonMap = ImmutableMap.of("items",items);
			return passRespond(jsonMap);
		} catch (Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
	}
}
