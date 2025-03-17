package com.company.java019;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Network002_Server {

	public static void main(String[] args) throws Exception {
		//1. 서버 소켓 - [ , , , ]  #1 실행1 ascenter
		ServerSocket ascenter=null;
		Socket socket;
		
		ascenter = new ServerSocket(7703);
		System.out.println("[SERVER] 1. 서버준비 완료 A/S 센터 OPEN!");
		System.out.println("[SERVER] 2. 고객님 기다리는 중.....");
		  //localhost / port
		
		//3. 클라이언트의 요청(accept)이 오면 상담사(Socket)랑 연결
		socket = ascenter.accept(); // socket은 고객의 정보를 가지고 있음
		System.out.println("[SERVER] 3. 상담사랑 연결 중....");
		
		//4. 데이터 주고 받기
		Thread sender = new Sender(socket); sender.start();
		Thread receiver = new Receiver(socket); receiver.start();
	} // E main

} // E class
//Thread 1) extends 상속 2) run 구현 3) start 작업수행클래스 실행
// 말하기 기능 클래스  InputStream  > [프로그램] > OutputStream #
class Sender extends Thread {
	Socket socket; DataOutputStream out; String who; SimpleDateFormat sdf;
	
	public Sender() {
	}
	public Sender(Socket socket) throws Exception {
		this.socket = socket;
		out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF("Hello... START >> ");
		this.who = "[" +(socket.getPort()==7703?"Client ":"Server ") ;
		this.sdf = new SimpleDateFormat(" hh:mm:ss"+"]");
	}
	
	@Override
	public void run() {
//		Scanner scanner = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			while ( out!=null ) {
				String data = in.readLine();
				String time = sdf.format(System.currentTimeMillis());
				out.writeUTF(who + time + data);
			}
		} catch(Exception e) {
//			e.printStackTrace();
		} finally {
			try {
					
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();
				}
				if(!socket.isClosed()) {
					socket.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // E run
} // E class

// 듣기 기능 클래스    InputStream # > [프로그램] > OutputStream
class Receiver extends Thread  {
	Socket socket; DataInputStream in;
	
	public Receiver() {
	}

	public Receiver(Socket socket)  throws Exception {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		try {
			while ( in!=null ) {
			System.out.println(in.readUTF());		
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("통신이 종료되었습니다."); 
		} finally {
			try {
				if(in!=null) {
					in.close();
				}
				if(!socket.isClosed()) {
					socket.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//E run 
} // E class