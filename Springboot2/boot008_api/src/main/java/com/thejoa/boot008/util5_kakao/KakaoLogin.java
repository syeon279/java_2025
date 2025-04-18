package com.thejoa.boot008.util5_kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class KakaoLogin {

	@Value("${kakao_redirect_url}")
	private String kakao_redirect_url;

	@Value("${kakao_api}")
	private String kakao_api;

	// 1. login - 인증(사용자 신원 확인) , 인가( 접근 권한 부여 )
	public String step1() {
		return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + kakao_api + "&redirect_uri="
				+ kakao_redirect_url;

	}

	// 2. code - 인가코드를 토큰으로 처리
	public List<String> step2(String code) { // code
		System.out.println("............STEP1) " + code);
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		tokenUrl += "?grant_type=authorization_code" + "&client_id=" + kakao_api + "&redirect_uri=" + kakao_redirect_url
				+ "&code=" + code;
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line = "";
		StringBuffer buffer = new StringBuffer();
		String resultToken = "";

		try {
			url = new URL(tokenUrl);
			conn = (HttpURLConnection) url.openConnection();
			// Post
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// Content-Type: application/x-www-form-urlencoded;charset=utf-8
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
			conn.disconnect();

			resultToken = buffer.toString();
			System.out.println(".........................Step2)" + resultToken);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// com.goole.gson
		JsonObject job = JsonParser.parseString(resultToken).getAsJsonObject();
		String token = job.get("access_token").getAsString();

		System.out.println("....................Step2)" + token);

		return step3(token); // 마지막 수정
	}

	// 사용자 정보 가져오기
	// nickname, profile_img
	public List<String> step3(String token) {
		System.out.println("............STEP 2) " + token);
		List<String> userinfos = new ArrayList<>();

		String userUrl = "https://kapi.kakao.com/v2/user/me";

		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line = "";
		StringBuffer buffer = new StringBuffer();
		String result = "";

		try {
			url = new URL(userUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setRequestProperty("Authorization", "Bearer " + token); // ##

			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		result = buffer.toString();
		System.out.println("........................." + result);
		/*
		 * ............STEP1) VeyYQmdDmojU_NP82S0Pg6RO1Ab7wZ-AuXo1QmwMaYWjpoOu-
		 * f5FVAAAAAQKDRSjAAABlkcBoCuYFzyUYZmfhQ
		 * .........................Step2){"access_token":
		 * "B4Am5PWh9Pqpj1AEEQgzjkP6jmJqIJXJAAAAAQoNGZAAAAGWRwGggqhuWkW__Nqy",
		 * "token_type":"bearer","refresh_token":
		 * "IFoJ54KIJe4uTojhp-cZ3cwdMiqHlnTgAAAAAgoNGZAAAAGWRwGgdqhuWkW__Nqy",
		 * "expires_in":21599,"scope":"profile_image profile_nickname"
		 * ,"refresh_token_expires_in":5183999} ....................Step2)
		 * B4Am5PWh9Pqpj1AEEQgzjkP6jmJqIJXJAAAAAQoNGZAAAAGWRwGggqhuWkW__Nqy
		 * ............STEP 2)
		 * B4Am5PWh9Pqpj1AEEQgzjkP6jmJqIJXJAAAAAQoNGZAAAAGWRwGggqhuWkW__Nqy
		 * .........................{"id":4221814940,"connected_at":
		 * "2025-04-18T02:50:12Z","properties":{"nickname":"윤소현","profile_image":
		 * "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"
		 * ,"thumbnail_image":
		 * "http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"
		 * },"kakao_account":{"profile_nickname_needs_agreement":false,
		 * "profile_image_needs_agreement":false,"profile":{"nickname":"윤소현",
		 * "thumbnail_image_url":
		 * "http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"
		 * ,"profile_image_url":
		 * "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"
		 * ,"is_default_image":true,"is_default_nickname":false}}}
		 */

		JsonObject job = JsonParser.parseString(result).getAsJsonObject();
		System.out.println(".................job: " + job);
		userinfos.add(job.getAsJsonObject("properties").get("nickname").getAsString());
		userinfos.add(job.getAsJsonObject("properties").get("profile_image").getAsString());
		
		System.out.println(".......userinfos:" + userinfos);

		return userinfos; // 마지막 수정
	}

}
/*
 * curl -v -X POST "https://kauth.kakao.com/oauth/token" \ -H
 * "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \ -d
 * "grant_type=authorization_code" \ -d "client_id=${REST_API_KEY}" \
 * --data-urlencode "redirect_uri=${REDIRECT_URI}" \ -d "code=${AUTHORIZE_CODE}"
 * 
 * ............STEP1)
 * sNLR2wuHD7qFsDlF7YiCVCFmTXltqy8P28YOT8YypeanMhUtmGxZFgAAAAQKDRSjAAABlkbOg3_C3p98Pd5TpQ
 * .............................>{"access_token":
 * "ynCdlnlfeFmyR7DfMdP_2wj3ISXsUCVtAAAAAQoXAQ8AAAGWRs6D0ahuWkW__Nqy",
 * "token_type":"bearer","refresh_token":
 * "KutYVbgcr-juF8wE5x2m9BMSL-Q745T-AAAAAgoXAQ8AAAGWRs6DyahuWkW__Nqy",
 * "expires_in":21599,"scope":"profile_image profile_nickname"
 * ,"refresh_token_expires_in":5183999}
 * 
 * curl -v -X POST "https://kapi.kakao.com/v2/user/me" \ -H
 * "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \ -H
 * "Authorization: Bearer ${ACCESS_TOKEN}" \ --data-urlencode
 * 'property_keys=["kakao_account.email"]'
 */