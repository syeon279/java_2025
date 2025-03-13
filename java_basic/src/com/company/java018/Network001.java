package com.company.java018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network001 {

	public static void main(String[] args) {
		
		try {
			// 1. URL
			URL url = new URL("https://www.google.com/");
			
			// 2. 연결 객체 * (HttpURLConnection)
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// 3. 요청 설정
			conn.setRequestMethod("GET");
			conn.setDoInput(true); conn.setDoOutput(true);conn.setReadTimeout(1000); // 1000 1초
			
			// 4. 응답코드 - 200
//			System.out.println(conn.getResponseCode()); //200
			int code = conn.getResponseCode();
			
			// 5. 응답데이터 # 
			BufferedReader br;
			if(code==200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			
			String line = ""; StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null) {
				sb.append(line+"\n");
			}
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
