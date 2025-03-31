package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVo;

public class BDelete implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 값 가져오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		String bpass = request.getParameter("temppass");
		System.out.println("삭제 요청 - bno: " + bno + ", bpass: " + bpass);
		
		BoardDao dao = new BoardDao();
		
		request.setAttribute("result", String.valueOf(dao.delete(bno, bpass)));
	}

}
