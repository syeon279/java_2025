package com.company.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String path = request.getServletPath(); // 어떤 경로로 들어왔는지 확인
		System.out.println("........................." + path);
		
		/*
		 * if(path.equals("/list.do")) { // 전체리스트 list.jsp로 이동 } else
		 * if(path.equals("/write_view.do")) { // write.jsp로 이동 } else
		 * if(path.equals("/detail.do")) { //detail.jsp로 이동 } else
		 * if(path.equals("/update.do")) { //update.jsp로 이동 } else
		 * if(path.equals("/delete.do")) { // delete.jsp로 이동 }
		 */
		switch(path) {
		case "/list.do" :
			System.out.println("list.do : C: 전체리스트 BList / V:list.jsp");
			//http://localhost:8080/project_JOAbooks/list.do 
			//ok
			break;
		case "/write_view.do": 
			System.out.println("write_view.do : 글쓰기 폼");
			//http://localhost:8080/project_JOAbooks/write_view.do 
			//ok
			break;
		case "/write.do": 
			System.out.println("write.do : 글쓰기 기능");
			//http://localhost:8080/project_JOAbooks/write.do 
			//ok
			break;
		case "/detail.do" :
			System.out.println("detail.do : 상세보기");
			//http://localhost:8080/project_JOAbooks/detail.do 
			//ok
			break;
		case "/update_view.do": 
			System.out.println("update_view.do : 글수정 폼");
			//http://localhost:8080/project_JOAbooks/update_view.do
			//ok
			break;
		case "/update.do": 
			System.out.println("update.do : 글 수정 기능");
			//http://localhost:8080/project_JOAbooks/update.do
			//ok
			break;
		case "/delete.do": 
			System.out.println("delete.do : 글 삭제");
			//http://localhost:8080/project_JOAbooks/delete.do
			//ok
			break;
		}
		
	}

}
