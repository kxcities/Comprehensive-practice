package com.example.demo.serviceInterface;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.DealByteItem;
import com.example.demo.model.GoodsDetailByteItem;
import com.example.demo.model.GoodsListByteItem;
@Mapper
public interface TradeInterface {
	void goodsRealse(GoodsDetailByteItem item) throws Exception;
	List<GoodsListByteItem> goodsTitleSearch(String searchTitle, int pageStart, int pageSize) throws Exception;
	GoodsDetailByteItem findGoodsDetailById(String Id) throws Exception;
	List<GoodsListByteItem> goodsTagSearch(String searchTag, int pageStart, int pageSize) throws Exception;
	List<GoodsListByteItem> goodsAreaSearch(String area, int pageStart, int pageSize) throws Exception;
	List<GoodsListByteItem> goodsPriceSearch(Integer minPrice, Integer maxPrice, int pageStart,int pageSize) throws Exception;
	GoodsListByteItem findGoodsListById(String Id) throws Exception;
	void generateDeal(String dealId, String buyer, String goodsId, Timestamp dealTime, String dealPlace, Integer state) throws Exception;
	List<DealByteItem> runningDeal(String buyerName,int pageStart, int pageSize)throws Exception;
	List<DealByteItem> finishedDeal(String buyerName,int pageStart, int pageSize) throws Exception;
	void dealFinish(String dealId) throws Exception;
}
