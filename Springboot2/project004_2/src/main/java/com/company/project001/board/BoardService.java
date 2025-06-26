package com.company.project001.board;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.company.project001.domain.Board;
import com.company.project001.domain.Member;
import com.company.project001.member.MemberMapper;
import com.company.project001.util.UtilUpload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	@Autowired final BoardMapper boardMapper;
	@Autowired private MemberMapper memberMapper;
	
	@Autowired UtilUpload upload;
	
	
	//페이징
	public List<Board> getPaging(int page){
		return boardMapper.findAllPaged(page*10, 10);
	}
	
	public List<Board> findAllPaged(int offset, int limit){
		return boardMapper.findAllPaged(offset, limit);
	}
	
	public List<Board> findAll(){
		return boardMapper.findAllByOrderedByDesc();
	}
	
	@Transactional
	public Board find(Long id) {
		// 해당하는 번호를 찾아서 조회수 올리고 리턴
		Board findBoard = boardMapper.findById(id);
		if(findBoard != null) {
			long curr = findBoard.getBhit()== null? 0L : findBoard.getBhit();
			findBoard.setBhit(curr+1);
			boardMapper.updateByIdAndBpass(findBoard);
		}
		return findBoard;
	}
	
	// 글쓰기
	public int insert(MultipartFile file, Board board) {
		// 작성자 정보 조회
		String username = board.getMember() != null? board.getMember().getUsername() : null;
		if(username != null) {
			Member member = memberMapper.findByUsername(username);
			if( member != null) {
				board.setMember(member);
			} else {
				throw new IllegalArgumentException("유효하지 않은 사용자입니다.");
			}
		}
		
		// 파일 업로드
		try {
			board.setBfile(upload.fileUpload(file));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// bhit 0L
		if(board.getBhit() == null) {
			board.setBhit(0L);
		}
		
		// ip 주소
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return boardMapper.insert(board);
	}
	
	// 수정폼
	public Board  update_view(Long id) {
		return boardMapper.findById(id);
	}
	
	// 수정하기
	public int update(MultipartFile file, Board board) {
		String save = board.getBfile();
		if(file != null && file.getOriginalFilename().length()> 0) {
			try {
				save = upload.fileUpload(file);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		board.setBfile(save);
		return boardMapper.updateByIdAndBpass(board);
	}
	
	// 삭제하기
	public int delete(Board board) {
		return boardMapper.deleteByIdAndBpass(board);
	}
	
}
