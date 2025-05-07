package com.ysh.board.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/")
	public String list(Model model) {
		List<Board> list = boardService.findAllBoard();
		model.addAttribute("list", list);
		return "board/list";
	}

	@GetMapping("/board/list")
	public String list_get(Model model) {
		List<Board> list = boardService.findAllBoard();
		model.addAttribute("list", list);
		return "board/list";
	}

	@GetMapping("/board/detail/{id}")
	public String detail_get(@PathVariable("id") long id, Model model) {
		Board findBoard = boardService.findById(id).orElseThrow(() -> new RuntimeException("Board를 찾지 못했습니다."));
		model.addAttribute("board", findBoard);
		boardService.updateBhit(id);
		return "board/detail";
	}

	@GetMapping("/board/insert")
	public String insert_get() {
		return "board/write";
	}

	@PostMapping("/board/insert")
	public String insert_post(Board board) {
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("/board/update/{id}")
	public String update_get(@PathVariable("id") long id, Model model) {
		Board findBoard = boardService.findById(id).orElseThrow();
		model.addAttribute("board", findBoard);
		return "board/edit";
	}

	@PostMapping("/board/update")
	public String update_post(@RequestParam String btitle, @RequestParam String bcontent, @RequestParam long id,
			@RequestParam String bpass) {
		boardService.updateByIdAndPass(btitle, bcontent, id, bpass);
		return "redirect:/board/detail/" + id;
	}

	@GetMapping("/board/delete/{id}")
	public String delete_get(@PathVariable("id") Long id, Model model) {
		Board findBoard = boardService.findById(id).orElseThrow();
		model.addAttribute("board", findBoard);
		return "board/delete";
	}

	@PostMapping("/board/delete")
	public String delete_post(Long id, @RequestParam String bpass) {
		boardService.deleteByIdAndPass(id, bpass);
		return "redirect:/board/list";
	}

}
