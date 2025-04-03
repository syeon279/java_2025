package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String create() {
		return "board/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String create_post() {
		return "board/write";
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail() {
		return "board/detail";
	}
	@RequestMapping(value="/detail", method=RequestMethod.POST)
	public String detail_post() {
		return "board/detail";
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
		return "board/update";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update_post() {
		return "board/update";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete() {
		return "board/delete";
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete_post() {
		return "board/delete";
	}
}
/*
 * http://localhost:8080/spring011_ex_board/board/list
 * http://localhost:8080/spring011_ex_board/board/write
 * http://localhost:8080/spring011_ex_board/board/detail
 * http://localhost:8080/spring011_ex_board/board/update
 * http://localhost:8080/spring011_ex_board/board/delete
 * 
 * v-2
 * 
 * 	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String create() {
		return "board/write";
	}
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String create_post() {
		return "board/write";
	}
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String detail() {
		return "board/detail";
	}
	@RequestMapping(value="/board/detail", method=RequestMethod.POST)
	public String detail_post() {
		return "board/detail";
	}
	@RequestMapping(value="/board/update", method=RequestMethod.GET)
	public String update() {
		return "board/update";
	}
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update_post() {
		return "board/update";
	}
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String delete() {
		return "board/delete";
	}
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete_post() {
		return "board/delete";
	}
 * 
 * 
 * 
 * 
 * v-1
 * 	@RequestMapping("/board/list")
	public String list() {
		return "board/list";
	}
	@RequestMapping("/board/write")
	public String create() {
		return "board/write";
	}
	@RequestMapping("/board/detail")
	public String detail() {
		return "board/detail";
	}
	@RequestMapping("/board/update")
	public String update() {
		return "board/update";
	}
	@RequestMapping("/board/delete")
	public String delete() {
		return "board/delete";
	}
 * 
 */
