package com.thejoa.boot008.util3_naver_mail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thejoa.boot008.util3_naver_mail.NaverMail;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired NaverMail api;
	
	@GetMapping("/mail")
	public String mail() {
		return "mail";
	}
	
	@PostMapping("/mail")
	public String mail_send(String subject, String content) {
		api.sendMail(subject, content);
		return "mail_result";
	}
}
