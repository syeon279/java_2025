package com.thejoa.boot008.util9_sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class SmsController {
	
	@Autowired
	private SmsService service;
	
	@GetMapping("/coolsms")
	public String coolsms() {
		return "coolsms";
	}
	
	@GetMapping("/coolsmsapi")
	@ResponseBody
	public String coolsmsapi(String to) throws CoolsmsException {
		return service.phoneNumberCheck(to);
	}
	
	
}
