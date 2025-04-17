package com.thejoa.boot008.util3_naver_mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class NaverMail {
	
	private String subject, content;
	
	public void sendMail(String subject, String content) {
		// 1. 보내는 쪽
		String host="smtp.naver.com";
		String user = "syeonblue@naver.com"; // naver아이디 cozizii@naver.com
		String password="thgus2790!";
		
		// 2. 받는 사람 
		String to = "syeonblue@naver.com";
		
		// 3. 인증과 함께 보내는 세션설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host); // naver host
		props.put("mail.smtp.auth", "true"); //  인증 세팅 켬
		props.put("mail.smtp.port", "587"); // 포트 번호
		props.put("mail.debug", "true"); // 디버그 
		
		props.put("mail.smtp.starttls.enable", "true"); // 이메일 전송시 보안연결 사용함
		props.put("mail.smtp.ssl.trust", "smtp.naver.com"); // ssl 인증서 신뢰함
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session  = Session.getInstance(props , new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password); // id, password
			}
			
		});
		
		// 4. 메일 보내기
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(user)); // 보내는 사람
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(""+"<div style='background-color:black; color:white; padding:20px' >"
					+ "<p>"+content+"</p>"
					+ "</div>","text/html; charset=euc-kr");
			
			Transport.send(message);
			System.out.println(".....successfully....");
			
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
}
