package com.example.demo.serviceInterface;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.LifeShareByteItem;

@Mapper
public interface LifeInterface {
	void LifeShareUpload(LifeShareByteItem byteItem);
	List<LifeShareByteItem> LifeShareDownload(int pageStart, int pageSize);
}
