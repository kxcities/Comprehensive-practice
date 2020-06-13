package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.model.LifeShareByteItem;
import com.example.demo.model.LifeShareItem;
import com.example.demo.serviceInterface.LifeInterface;

@Service
public class LifeService {
	@Resource
	LifeInterface lifeInterface;
	public String LifeShareUpload(LifeShareByteItem byteItem) throws Exception{
		
			lifeInterface.LifeShareUpload(byteItem);
			return "success";
		
	}
	public List<LifeShareItem> LifeShareDownload(Integer curPage) {
		List<LifeShareByteItem> byteItems = lifeInterface.LifeShareDownload((curPage- 1) * PAGE_NUM, PAGE_NUM);
		List<LifeShareItem> items = new ArrayList<LifeShareItem>();
		for(LifeShareByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	static int PAGE_NUM = 10;
}
