package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVo;

public class BUpdate implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 언어 셋팅 UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 값 가져오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		// 3. dao update 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setBno(bno);

		
		// 4. 결과값 처리
		request.setAttribute("result", String.valueOf(dao.update(vo)));
		
	}

}
