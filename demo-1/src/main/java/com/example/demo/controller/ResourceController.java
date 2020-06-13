package com.example.demo.controller;


import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.BookInfoItem;
import com.example.demo.service.ResourceService;
import com.google.common.collect.ImmutableMap;
import com.sun.tools.javac.util.Pair;

@RestController
public class ResourceController extends BaseController {
	@Autowired
	ResourceService resourceService;
	@PostMapping("/resource/bookSearch")
	public String bookSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		String searchText = inputParam.get("strText");
		Map<String,Object> jsonMap = null;
		try {
			Pair<List<BookInfoItem>,Integer> result = resourceService.bookSearch(URLEncoder.encode(searchText,"UTF-8"),inputParam.get("page"));
			Integer count = result.snd;
			Integer curPage = 1;
			if(true == inputParam.containsKey("curPage")) {
				curPage = Integer.parseInt(inputParam.get("curPage"));
			}
			Integer totalPage = count / 15;
			if(count % 15 != 0) {
				totalPage = totalPage + 1;
			}
			jsonMap = ImmutableMap.of("items",result.fst,"curPage",curPage,"totalPage",totalPage);
		} catch (Exception e) {
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
}
