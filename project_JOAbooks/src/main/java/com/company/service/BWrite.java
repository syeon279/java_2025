package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVo;

public class BWrite implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 언어 셋팅 UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. request 데이터 받아오기
		String bname = request.getParameter("name");
		String btitle = request.getParameter("title");
		String bcontent = request.getParameter("content");
	      
	    // 3. dao insert 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setBname(bname);
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
	      
	    // 4. 결과물 처리
		request.setAttribute("result", String.valueOf(dao.insert(vo))); // 값만 나와서 객체로 만든것.
	}

}
