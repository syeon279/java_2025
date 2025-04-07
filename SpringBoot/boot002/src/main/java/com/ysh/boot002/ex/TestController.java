package com.ysh.boot002.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/ex1")
	@ResponseBody
	public String test() {
		return "springboot";
	}
	// localhost:8282/boot2/ex1
	
	@RequestMapping("/ex2")
	public String test2(Model model) {
		model.addAttribute("greeting", "ex2");
		return "ex2";
	}
	//localhost:8282/boot2/ex2
	
	@RequestMapping("/test")
	public String test0() {
		return "test";
	}
	//localhost:8282/boot2/test
}
