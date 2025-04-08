package com.ysh.boot003.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller @RequiredArgsConstructor
public class BoardController {
	
	// v1. @Autowired BoardService boardService;
	private final BoardService service;
	
	@GetMapping("/board/list")
	public String list(Model model){
		model.addAttribute("list", service.findAll());// 전체 리스트 뽑고
		return "board/list"; //board 폴더 안에 list파일
	}
	// http://localhost:8080/board/list
	
	@GetMapping("/board/detail/{id}")
	public String detail( @PathVariable Long id, Model model){
		model.addAttribute("dto", service.find(id)); // 조회수 올리고 /상세보기 기능
		
		return "board/detail"; 
	}
	// http://localhost:8080/board/detail/2
	
	
	@GetMapping("/board/insert")
	public String insert_Get(){
		// 글쓰기 홈
		return "board/write"; 
	}
	// http://localhost:8080/board/insert
	
	@PostMapping("/board/insert")
	public String insert_Post( Board board, @RequestParam Long member_id  ) {
		System.out.println("...."+board);
		System.out.println("...."+ member_id);
		service.insert(board, member_id);// 글쓰기 기능
		return "redirect:/board/list"; // 갱신된 리스트  
	}
	// http://localhost:8080/board/insert
	// form 테스트
	
	@GetMapping("/board/update/{id}")
	public String update_Get( @PathVariable Long id, Model model ){
		model.addAttribute("dto", service.find(id));// 수정할 글 가져오기
		return "board/update"; 
	}
	// http://localhost:8080/board/update/3
	
	@PostMapping("/board/update")
	public String update_Post(Board board) {
		service.update(board);// 글 수정기능
		return "redirect:/board/list";  
	}
	// http://localhost:8080/board/update
	
	@GetMapping("/board/delete")
	public String delete_Get(){
		// 삭제할 글 가져오기
		return "board/delete"; 
		
	}
	// http://localhost:8080/board/delete
	
	@PostMapping("/board/delete")
	public String delete_Post(Board board) {
		service.delete(board);
		return "redirect:/board/list"; // 갱신된 리스트  
	}
	// http://localhost:8080/board/delete
	
	
	
	
	
	
	
}
/** Restful Api
기존게시판 : localhost:8080/board/detail?bno=10 쿼리스트링 사용
Restful Api : localhost:8080/board/detail/bno/10 쿼리스트링 사용
	1) resultful - http url을 기반으로 자원에 접근해서 서비스를 제공하는 어플리케이션
	2) api 
	3) method ( GET: 검색 / POST: 생성 / PATCH(부분 업데이트) PUT:(전체 업데이트) / DELETE: 삭제)
	4) DATA - json,xml 
	
	
**/





