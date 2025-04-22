package com.thejoa.boot008.util7_iddouble;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyUserController {
	
	@Autowired
	MyUserService service;
	
	@GetMapping(value="/idByUsername/{username}", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> myuser( @PathVariable  String username) {
		Map<String, Object> result = new HashMap<>();
		String msg = "사용 불가능합니다.";
		try {
			service.selectUsername(username);
		} catch(Exception e) {
			e.printStackTrace();
			msg = "사용 가능합니다.";
		}
		
		result.put("result", msg);
		return result;
	}
	
	@GetMapping(value="/idByEmail", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> myuserEmail( @RequestParam String email) {
		Map<String, Object> result = new HashMap<>();
		result.put("result", service.selectUsername(email));
		return result;
	}
	
	@GetMapping("/iddouble")
	public String myuser() {
		return "/iddouble";
	}
	
	
	// Username?username=first
}
