package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/*
	 * @RequestMapping("/hello") public String hello() { return "hello"; }
	 */
	@RequestMapping("/hello")
	public void hello() {
	} // 자체가 파일명이 됨. 
	
}
