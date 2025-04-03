package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.UserDto;
import com.company.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

//	@RequestMapping(value = "/list.user", method=RequestMethod.GET)
	@RequestMapping("/list.user")
//	@GetMapping("/list.user")
	public String list(Model model) {
		model.addAttribute("list", service.selectAll()); // 처리하고
		return "users/list"; // 화면
	}

	@RequestMapping("/detail.user")
	public String detail(Model model, int no) {
		// http://localhost:8080/spring012_useful/detail.user?no=1
		model.addAttribute("dto", service.selectOne(no));
		System.out.println(no);
		return "users/select";
	}

	@RequestMapping(value =  "/insert.user", method = RequestMethod.POST) 
	public String insert(UserDto dto) {  //UserDto 안에 속성이 name, age + getter/setter
		if(dto != null) {
			service.insert(dto);
		}
		return "redirect:/list.user";
	}
	
	@RequestMapping(value = "/update.user", method = RequestMethod.POST) 
	public String update(UserDto dto, int no) {
		if(dto != null && no != 0) {
			System.out.println(dto);
			System.out.println(no);
			service.update(dto);
		}
		return "redirect:/list.user";
		
	}
	@RequestMapping("/delete.user") 
	public String delete(int no) {
		if( no != 0) {
			System.out.println(no);
			service.delete(no);
		}
		return "redirect:/list.user";
		
	}

	// detail.user - Get 방식 해당번호의 사용자정보 users/select.jsp 파일
	// insert.user - Post 방식 글쓰기기능 , list.user
	// update.user - Post 방식 글수정기능 , list.user
	// delete.user - Get 방식 삭제기능 , list.user

}
