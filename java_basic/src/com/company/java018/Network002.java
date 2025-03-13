package com.company.java018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Network002 {

	public static void main(String[] args) throws Exception {
		// 1. URL 
		//https://openapi.naver.com/v1/search/news.xml
		// https://openapi.naver.com/v1/search/news.json
		String apiurl = "https://openapi.naver.com/v1/search/news.json?query="
				+URLEncoder.encode("ai", "UTF-8");
		URL url = new URL(apiurl);
		
		// 2. HttpURLConnection
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// 3. 요청설정
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Naver-Client-Id", "NvhXAQC8hP09pJRhew10");
		conn.setRequestProperty("X-Naver-Client-Secret", "cWxzVNifKe");
		// GET
		// 쿼리 스트링 형식 - 요청사항 주소표시줄로 데이터 넘기기
							// 주소?이름=값?이름=값
		// > X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
		// > X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
		
		// 4. 응답확인 - 200
		System.out.println(conn.getResponseCode());
		int code = conn.getResponseCode();
		BufferedReader br;
		if(code == 200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}
		
		// 5. 응답데어터 - xml/json/scv 
		String line = ""; StringBuffer sb = new StringBuffer();
		while( (line=br.readLine())!= null) {
			sb.append(line+"\n");
		}
		
		System.out.println(sb.toString());
		br.close(); conn.disconnect();
		
		
	} // E main

} // E class

//1.
	//Id
	//NvhXAQC8hP09pJRhew10 
	//
	//Key
	//cWxzVNifKe
//2.
	//https://openapi.naver.com/v1/search/news.xml	XML
	//https://openapi.naver.com/v1/search/news.json	JSON
//3. 요청정보
	// GET
	// 쿼리 스트링 형식 - 요청사항 주소표시줄로 데이터 넘기기
	// > X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
	// > X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
//4. 응답확인 