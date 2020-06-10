package com.example.demo.controller;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DealItem;
import com.example.demo.model.GoodsDetailByteItem;
import com.example.demo.model.GoodsDetailItem;
import com.example.demo.model.GoodsListItem;
import com.example.demo.model.User;
import com.example.demo.service.TradeService;
import com.example.demo.tool.IdGeneratorTool;
import com.example.demo.tool.PicTool;
import com.google.common.collect.ImmutableMap;
@RestController
public class TradeController  extends BaseController{
	
	@Resource
	TradeService tradeService;
	@PostMapping(path = "home/trade/goodsRealse")
	public String goodsRealse(HttpSession session,@RequestBody Map<String,String> inputParam){
		Map<String,Object> jsonMap = null;
		Integer expectedPrice = null;
		try {
			expectedPrice = Integer.parseInt(inputParam.get("P_price"));
			String goodsPic = inputParam.get("P_url");
			User owner = (User)session.getAttribute("loginUser");
			String ownerName = owner.getUserName();
			String tag = inputParam.get("P_tag");
			String goodsTitle = inputParam.get("P_title");
			String detailText = inputParam.get("P_text");
			String area = inputParam.get("P_area");
			GoodsDetailByteItem item = new GoodsDetailByteItem();
			item.setGoodsId(IdGeneratorTool.goodsIdGenerate());
			item.setIcoPicture(PicTool.produceIcoPicByte(goodsPic));
			item.setOwnerName(ownerName);
			item.setOriPicture(PicTool.base64Decode(goodsPic));
			item.setTag(tag);
			item.setGoodsTitle(goodsTitle);
			item.setExpectedPrice(expectedPrice);
			item.setDetailText(detailText);
			item.setArea(area);
			String result = tradeService.goodsRealse(item);
			jsonMap = ImmutableMap.of("result", result);
			return passRespond(jsonMap);
		}catch(Exception e) {
			jsonMap = ImmutableMap.of("result", "fail");
			return passRespond(jsonMap);
		}
	}
	
	@PostMapping(value = "home/trade/goodsTitleSearch")
	public String goodsTitleSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			String keyTitle = inputParam.get("Search_title");
			Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<GoodsListItem> items = tradeService.goodsTitleSearch(keyTitle,curPage);
			jsonMap = ImmutableMap.of("items",items);
		} catch (Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(value = "home/trade/goodsAreaSearch")
	public String goodsAreaSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			String keyArea = inputParam.get("F_area");
			Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<GoodsListItem> items = tradeService.goodsAreaSearch(keyArea, curPage);
			jsonMap = ImmutableMap.of("items",items);
		} catch (Exception e) {
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(value = "home/trade/goodsPriceSearch")
	public String goodsPriceSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		Integer minPrice = null;
		Integer maxPrice = null;
		if(inputParam.containsKey("F_minPrice")) {
			minPrice = Integer.parseInt(inputParam.get("F_minPrice"));
		}
		if(inputParam.containsKey("F_maxPrice")) {
			maxPrice = Integer.parseInt(inputParam.get("F_maxPrice"));
		}
		System.out.print(maxPrice);
		try {
			Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<GoodsListItem> items = tradeService.goodsPriceSearch(minPrice, maxPrice, curPage);
			jsonMap = ImmutableMap.of("items",items);
		} catch (Exception e) {
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(value = "home/trade/goodsTagSearch")
	public String goodsTagSearch(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			String keyTag = inputParam.get("Search_tag");
			Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<GoodsListItem> items = tradeService.goodsTagSearch(keyTag,curPage);
			jsonMap = ImmutableMap.of("items",items);
		} catch (Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
		return passRespond(jsonMap);
	}
	@PostMapping(value = "home/trade/goodsDetail")
	public String goodsDetail(HttpSession session,  @RequestBody Map<String,String> inputParam) {
		/*if(false == sessionCheck(session)) {
			return sessionFailureRespond();
		}*/
		Map<String,Object> jsonMap = null;
		GoodsDetailItem item = null;
		String goodsId = inputParam.get("P_id");
		try {
			item = tradeService.findGoodsDetailById(goodsId);
		} catch (Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
		jsonMap = ImmutableMap.of("item",item);
		return passRespond(jsonMap);
	}
	
	@PostMapping(value = "home/trade/generateDeal")
	public String generateDeal(HttpSession session,  @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		String goodsId = inputParam.get("P_id");
		String buyer = inputParam.get("U_keyword");
		Timestamp dealTime = Timestamp.valueOf(inputParam.get("time"));
		String dealPlace = inputParam.get("place");
		try {
			String result  = tradeService.generateDeal(buyer,goodsId,dealTime,dealPlace);
			jsonMap = ImmutableMap.of("result", result);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap = ImmutableMap.of("result", "fail");
		}
		return passRespond(jsonMap);
	}
    @PostMapping(value = "home/trade/runningDeals")
    public String runningDeal(HttpSession session,  @RequestBody Map<String,String> inputParam) {
    	Map<String,Object> jsonMap = null;
    	String buyerName = inputParam.get("buyer");
    	try {
    		Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<DealItem> deals = tradeService.runningDeal(buyerName,curPage);
			jsonMap = ImmutableMap.of("deals", deals);
		} catch (Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
    	return passRespond(jsonMap);
    }
    @PostMapping(value = "home/trade/finishedDeals")
    public String finishedDeal(HttpSession session,  @RequestBody Map<String,String> inputParam) {
    	Map<String,Object> jsonMap = null;
    	String buyerName = inputParam.get("buyer");
    	try {
    		Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			List<DealItem> deals = tradeService.finishedDeal(buyerName,curPage);
			jsonMap = ImmutableMap.of("deals", deals);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return passRespond(jsonMap);
    }
    @PostMapping(value = "home/trade/dealFinish")
    public String dealFinish(HttpSession session, @RequestBody Map<String,String> inputParam) {
    	Map<String,Object> jsonMap = null;
    	String dealId =  inputParam.get("deal_id");
    	String result = "fail";
    	result = tradeService.dealFinish(dealId);
    	jsonMap = ImmutableMap.of("result", result);
    	return passRespond(jsonMap);
    }
}
