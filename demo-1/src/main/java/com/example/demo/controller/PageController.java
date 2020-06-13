package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController extends BaseController {
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	@RequestMapping(value="/index_")
	public String index_() {
		return "index_";
	}
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="/register")
	public String returnIndex() {
		return "register";
	}
	@RequestMapping(value="/second_hand")
	public String returnIndex1() {
		return "second_hand";
	}
	@RequestMapping(value="/upload_goods")
	public String returnIndex2() {
		return "upload_goods";
	}
	@RequestMapping(value="/shop_car")
	public String returnIndex3() {
		return "shop_car";
	}
	@RequestMapping(value="/friend_index")
	public String returnIndex4() {
		return "friend_index";
	}
	@RequestMapping(value="/friend_upload")
	public String friend_upload() {
		return "friend_upload";
	}
	@RequestMapping(value="/friend_page1")
	public String returnIndex5() {
		return "friend_page1";
	}
	@RequestMapping(value="/friend_page2")
	public String returnIndex6() {
		return "friend_page2";
	}
	@RequestMapping(value="/friend_page3")
	public String returnIndex7() {
		return "friend_page3";
	}
	@RequestMapping(value="/notify")
	public String returnIndex8() {
		return "notify";
	}
	@RequestMapping(value="/feedback")
	public String returnIndex9() {
		return "feedback";
	}
	@RequestMapping(value="/search_book")
	public String returnIndex10() {
		return "search_book";
	}
	@RequestMapping(value="/free_talk")
	public String returnIndex11() {
		return "free_talk";
	}
	@RequestMapping(value="/talk_upload")
	public String talk_upload() {
		return "talk_upload";
	}
	@RequestMapping(value="/talk_search")
	public String talk_search() {
		return "talk_search";
	}
}
