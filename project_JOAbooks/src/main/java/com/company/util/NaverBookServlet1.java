package com.company.util;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NaverBookServlet
 */
@WebServlet("/books1")
public class NaverBookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NaverBookServlet1() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			String apiurl = "https://openapi.naver.com/v1/search/book.json?query="
					+URLEncoder.encode("독서", "UTF-8");
			URL url = new URL(apiurl);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", "NvhXAQC8hP09pJRhew10");
			conn.setRequestProperty("X-Naver-Client-Secret", "cWxzVNifKe");
			
			System.out.println(conn.getResponseCode());
			int code = conn.getResponseCode();
			
			BufferedReader br;
			if(code == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			
			String line = ""; StringBuffer sb = new StringBuffer();
			while( (line = br.readLine())!= null) {
				sb.append(line+"\n");
			}
			
			br.close(); conn.disconnect();
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
			} catch (Exception e) {
					e.printStackTrace();
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
