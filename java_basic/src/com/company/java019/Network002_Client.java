package com.company.java019;

import java.net.Socket;

public class Network002_Client {

	public static void main(String[] args) throws Exception {
		//2. 고객이 통신사에 연락 - 127.0.0.1 (원래는)(192.168.40.130)/ 7703
		// #2 실행2 
		Socket socket = null;
		
		socket = new Socket("127.0.0.1", 7703);
		System.out.println("[CLIENT] 2. as center에 고객문의!");
		
		//4. 데이터 주고받기 
		Thread sender = new Sender(socket); sender.start();
		Thread receiver = new Receiver(socket); receiver.start();
	} // E main
} // E class
