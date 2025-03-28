package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NaverBookServlet
 */
@WebServlet("/books")
public class NaverBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {	
			//#1. URL
			//		https://openapi.naver.com/v1/search/book.xml	XML
			//		https://openapi.naver.com/v1/search/book.json	JSON
			String apiurl = "https://openapi.naver.com/v1/search/book.json?query="
							+ URLEncoder.encode("요리" , "UTF-8");
			URL url = new URL(apiurl);
			//#2. HttpURLConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//#3. 요청파라미터
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id"    , "reu63fdeQl8IXmwLVsRM");
			conn.setRequestProperty("X-Naver-Client-Secret", "AvEnm8FcX2"); 
			
			//#4. 응답코드 - 200
			//System.out.println(conn.getResponseCode());
			int code = conn.getResponseCode();
			BufferedReader br;
			if(  code == 200) { br = new BufferedReader(new InputStreamReader(conn.getInputStream()));}
			else { br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			//#5. 응답
			String line="";   StringBuffer sb = new StringBuffer();
			while(  (line=br.readLine() )     != null ) {  sb.append(line+"\n");  }
			System.out.println(sb.toString());
			br.close();   conn.disconnect(); 
			
			PrintWriter out = response.getWriter();   
			out.println(sb.toString()); //##
			
			
		  }catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
