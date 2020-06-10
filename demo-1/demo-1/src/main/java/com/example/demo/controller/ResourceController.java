package com.example.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookInfoItem;
import com.example.demo.service.ResourceService;
import com.google.common.collect.ImmutableMap;

@RestController
public class ResourceController extends BaseController {
	@Autowired
	ResourceService resourceService;
	@PostMapping("/resource/bookSearch")
	public String bookSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		String searchText = inputParam.get("strText");
		Map<String,Object> jsonMap = null;
		if(searchText != null) {
			try {
				List<BookInfoItem> items = resourceService.bookSearch(URLEncoder.encode(searchText,"UTF-8"));
				jsonMap = ImmutableMap.of("items",items);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return passRespond(jsonMap);
		}
		return errorRespond();
	}
}
