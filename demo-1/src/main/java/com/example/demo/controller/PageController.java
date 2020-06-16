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
	public String register() {
		return "register";
	}
	@RequestMapping(value="/second_hand")
	public String second_hand() {
		return "second_hand";
	}
	@RequestMapping(value="/upload_goods")
	public String upload_goods() {
		return "upload_goods";
	}
	@RequestMapping(value="/shop_car")
	public String shop_car() {
		return "shop_car";
	}
	@RequestMapping(value="/friend_index")
	public String friend_index() {
		return "friend_index";
	}
	@RequestMapping(value="/friend_upload")
	public String friend_upload() {
		return "friend_upload";
	}
	@RequestMapping(value="/friend_page1")
	public String friend_page1() {
		return "friend_page1";
	}
	@RequestMapping(value="/friend_page2")
	public String friend_page2() {
		return "friend_page2";
	}
	@RequestMapping(value="/friend_page3")
	public String friend_page3() {
		return "friend_page3";
	}
	@RequestMapping(value="/notify")
	public String returnIndex8() {
		return "notify";
	}
	@RequestMapping(value="/feedback")
	public String feedback() {
		return "feedback";
	}
	@RequestMapping(value="/search_book")
	public String search_book() {
		return "search_book";
	}
	@RequestMapping(value="/talk_index")
	public String talk_index() {
		return "talk_index";
	}
	@RequestMapping(value="/talk_page1")
	public String talk_page1() {
		return "talk_page1";
	}
	@RequestMapping(value="/talk_page2")
	public String talk_page2() {
		return "talk_page2";
	}
	@RequestMapping(value="/talk_page3")
	public String talk_page3() {
		return "talk_page3";
	}
	@RequestMapping(value="/talk_upload")
	public String talk_upload() {
		return "talk_upload";
	}
	@RequestMapping(value="/talk_search")
	public String talk_search() {
		return "talk_search";
	}
	@RequestMapping(value="/personal_info")
	public String personal_info() {
		return "personal_info";
	}
}
