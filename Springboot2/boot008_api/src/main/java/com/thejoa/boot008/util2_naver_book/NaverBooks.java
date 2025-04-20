package com.thejoa.boot008.util2_naver_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class NaverBooks {
	   public String getApi(String query) throws IOException {  // 0. 사용자가 넣어주는 검색어
		      String result="";
		      //1. 연결
		      String cliendId="reu63fdeQl8IXmwLVsRM";
		      String cliendSecret="AvEnm8FcX2";
		      String param = "?query=" + URLEncoder.encode(query, "UTF-8");
		      URL url = new URL("https://openapi.naver.com/v1/search/book.json" + param);   // ##
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      //2. 옵션 
		      conn.setRequestProperty("X-Naver-Client-Id", cliendId);
		      conn.setRequestProperty("X-Naver-Client-Secret", cliendSecret);
		      conn.setDoInput(true);
		      conn.setDoOutput(true);
		      conn.setRequestMethod("GET"); //##
		      //3. 성공
		      if(conn.getResponseCode() == 200) {
		         StringBuffer buffer = new StringBuffer();
		         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		         String line = "";
		         while(   (line = br.readLine())  != null) {buffer.append(line);  }
		         result = buffer.toString();
		         br.close();
		      }
		      conn.disconnect();
		      return result;
		   }
}
