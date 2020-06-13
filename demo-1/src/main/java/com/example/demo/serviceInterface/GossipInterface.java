package com.example.demo.serviceInterface;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GossipInterface {
	List<String> gossipDownload();
	void gossipUpload(String gossipBlock, String gossipText) throws Exception;
	List<String> gossipBlockSearch(String searchBlock ,int pageStart ,int pageSize ) throws Exception;
	List<String> gossipStatusSearch(Integer searchStatus ,int pageStart, int pageSize) throws Exception;
	void gossipUpdateStatus(String gossipText, int status) throws Exception;
}
