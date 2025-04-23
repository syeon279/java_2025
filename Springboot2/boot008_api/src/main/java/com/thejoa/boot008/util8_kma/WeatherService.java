package com.thejoa.boot008.util8_kma;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	@Value("${kma_api}")
	private String api_key;
	
	public String getWeatherResponse() throws URISyntaxException {
		
		String date = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
		
		String url= "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey="
				+api_key+"&numOfRows=10&pageNo=1&base_date="+date+"&base_time=0600&nx=55&ny=127";
		
		URI uri = new URI(url);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		return response.getBody();
		
	}
}
