package com.company.util;

import java.io.*;
import java.net.*;

public class NaverBook {
	public void getBooks() {
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
				
				System.out.println(sb.toString());
				br.close(); conn.disconnect();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
