package com.company.project001.member;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.company.project001.oauth.PrincipalOauth2UserService;

@Configuration		 //스프링부트 설정파일
@EnableWebSecurity	 //url 스프링 시큐리티 제어 - SecurityFilterChain
public class SecurityConfig {
	//1. url
	@Autowired PrincipalOauth2UserService principalOauth2UserService;
	@Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		 .addFilterBefore(new OncePerRequestFilter() {
		        @Override
		        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		                throws ServletException, IOException {
		            System.out.println("🧭 요청 필터 통과: " + request.getMethod() + " " + request.getRequestURI());
		            filterChain.doFilter(request, response);
		        }
		    }, UsernamePasswordAuthenticationFilter.class)
		 .authorizeRequests()
		.antMatchers("/member/login", "/member/join", "/member/join/**", "/resorces/**").permitAll()		// 누구나 접근 가능
		.antMatchers("/board/insert", "/board/update/**", "/board/delete/**", "/member/member").authenticated()	// 로그인된 사용자만 접근 가능 
	    .antMatchers(HttpMethod.GET, "/member/join").permitAll()
	    .antMatchers(HttpMethod.POST, "/member/join").permitAll()
		.anyRequest().permitAll()			// 지정하지 않은 다른 모든 요펑은 허용
		.and()
		.formLogin()
			.loginPage("/member/login")	// 커스텀 로그인 폼
			.loginProcessingUrl("/member/login")	// 사용자가 입력한 값 처리 url 
			.defaultSuccessUrl("/member/member", true) // 로그인 성공 시 경로 - true : 사용자가 로그인 전 요청이 있더라도 무시하고 이 url로 이동
		.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))	// 로그아웃 경로 
			.logoutSuccessUrl("/member/login")		// 로그아웃 성공경로
			.invalidateHttpSession(true)			// 로그아웃시 세션무효 
		.and()
		.oauth2Login()
			.loginPage("/member/login")
			.defaultSuccessUrl("/member/member")
			.userInfoEndpoint()
			.userService(principalOauth2UserService)
			.and()
			.and()
		//.csrf().disable()		// 개발용 ( 보호기능 비활성화 )  - csrf: 사용자 인증 정보를 웹페이지에서 보내기 
		.csrf(
				csrf->csrf.ignoringRequestMatchers( // csrf 검사 생략 
						new AntPathRequestMatcher("/member/join", "POST"),
						new AntPathRequestMatcher("/board/insert", "POST"),
						new AntPathRequestMatcher("/board/update/**", "POST"),
						new AntPathRequestMatcher("/board/delete/**", "POST")
						)
				);
		return http.build();
	}
	
	//2. AuthenticationManager
	// 사용자 인증시 Service와 PasswordEncoder를 사용
	@Bean AuthenticationManager authenticationManager( AuthenticationConfiguration auth) throws Exception {
		return auth.getAuthenticationManager();
	}
	
	//3. PasswordEncoder
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired(required = false)
	ClientRegistrationRepository testRepo;

	@PostConstruct
	public void printOAuthRepo() {
	    System.out.println("🔍 OAuth Repo 확인: " + testRepo);
	}
}


/*
					[ UsernamePassword  ] token

1. client [ login ]	   ---    AuthenticationManager ( 관리자 )   ---   Provider ( db 체크 ) 
																      PassswordEncoder( 암호화 ) 															     
			[    ] session                                           
                                                                        [ UserDetail ] 유저정보
 */
