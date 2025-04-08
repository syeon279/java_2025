package com.ysh.boot003.board;

import java.util.List;

public interface BoardService {
	public List<Board> findAll(); // 전체 리스트
	public Board find(Long id); // 조회수 올리고 / 상세보기
	
	public void insert(Board board, Long id); // 글쓰기 기능
	
	public Board update_view(Long id); // 수정하기 폼
	public void update(Board board); //수정하기 기능
	
	public void delete(Board board); // 글 삭제 기능 
}
