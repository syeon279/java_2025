package com.thejoa.boot008.util6_chatGPT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService_my {
/*
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";

	@Value("${openapi.api.key}")
	private String API_KEY;

	public String getAPIResponse(String usermsg) {
		RestTemplate restTemplate = new RestTemplate();
		// header
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + API_KEY);
		// body
		Map<String, Object> body = new HashMap<>();
		body.put("model", "gpt-3.5-turbo"); // ##
		body.put("store", true);

		List<Map<String, String>> messages = new ArrayList<>();
		messages.add(Map.of("role", "user", "content", usermsg + "이 일기를 이모지 5개로 요약해줘"));
		body.put("messages", messages);

		// HttpEntity
		HttpEntity<Map<String, Object>> requesetEntity = new HttpEntity<>(body, headers);
		// 요청 전송
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(API_URL, requesetEntity, String.class);

		return responseEntity.getBody();

	}
*/
}

/*
 * curl https://api.openai.com/v1/responses \ -H
 * "Content-Type: application/json" \ -H "Authorization: Bearer $OPENAI_API_KEY"
 * \ -d '{ "model": "gpt-4.1", "input":
 * "Write a one-sentence bedtime story about a unicorn." }'
 * 
 */