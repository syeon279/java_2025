package com.company.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.BoardDto;
import com.company.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService service;
	
	// 전체 리스트 가져오기: 전체 테이터 가져오기(selectAll) + view 
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", service.selectAll());
		return "/board/list";
	}
	
	// 글쓰기 화면   :  x +  view(board/write)
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create() {
		return "/board/write";
	}
	
	// 글쓰기 기능 : 글쓰기 기능(insert(BoardDto dto) + board/list (새로 갱신된 list)
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create_post(BoardDto dto) {
		if(dto != null) { 
			try {
				dto.setBip(InetAddress.getLocalHost().getHostAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
			service.insert(dto); // 글쓰기 기능
		}
		return "redirect:/board/list";
	}
	
	// 글 상세보기 : 조회수( UpdateHit(int bno)
	//      +  해당 번호의 글 가져오기(select(int bno) + view (board/detail)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model, int bno) {
		if(bno!=0) {
			model.addAttribute("dto", service.detail(bno));
		}
		return "/board/detail";
	}
	
	// 글 수정하기 폼 : updateForm(int bno) + view(board/update)
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, int bno) {
		model.addAttribute("dto", service.updateForm(bno));
		return "/board/update";
	}
	
	// 글 수정 기능 : update(Board dto) +  글 수정확인 - board/deatil
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update_post(BoardDto dto) {
		if(dto != null) {
			service.update(dto);
		}
		return "redirect:/board/detail?bno="+dto.getBno();
	}
	
	// 글 삭제 폼: x , view (board/delete)
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Model model, int bno) {
		model.addAttribute("dto", service.detail(bno));
		return "/board/delete";
	}
	
	// 글 삭제 기능: delete(BoardDto dto) + 갱신된 list(boar/list)
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete_post(BoardDto dto) {
		if(dto != null) {
			service.delete(dto);
		}
		return "redirect:/board/list";
	}
}