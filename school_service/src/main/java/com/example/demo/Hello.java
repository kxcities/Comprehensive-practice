package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping(value="")
	public String index() {
		return "index";
	}
	@RequestMapping(value="/second_hand")
	public String returnIndex() {
		return "second_hand";
	}
	@RequestMapping(value="/upload_goods")
	public String returnIndex10() {
		return "upload_goods";
	}
	@RequestMapping(value="/register")
	public String returnIndex1() {
		return "register";
	}
	@RequestMapping(value="/result2")
	public String returnIndex2() {
		return "result2";
	}
	@RequestMapping(value="/result3")
	public String returnIndex3() {
		return "result3";
	}
	@RequestMapping(value="/result4")
	public String returnIndex4() {
		return "result4";
	}
	@RequestMapping(value="/result5")
	public String returnIndex5() {
		return "result5";
	}
	@RequestMapping(value="/result6")
	public String returnIndex6() {
		return "result6";
	}
	@RequestMapping(value="/result7")
	public String returnIndex7() {
		return "result7";
	}
	@RequestMapping(value="/result8")
	public String returnIndex8() {
		return "result8";
	}
	@RequestMapping(value="/feedback")
	public String returnIndex9() {
		return "feedback";
	}
}
