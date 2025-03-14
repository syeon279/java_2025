package com.company.java019;

import java.awt.Toolkit;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 = 자원 + Thread => 작업수행 클래스 
//3. 작업수행 클래스 1. 상속, Runnable 2. run() 해야할 일 3 start() 실행

class Sound extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i =0; i<5;i++) {
//			toolkit.beep();
			System.out.print("야옹....");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}//E class

class CatCount extends Thread { //#1. 작업수행클래스 상속
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i<5;i++) {
			System.out.println((i+1) + "마리 ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}  // E run
} // E class

public class Thread002 {

	public static void main(String[] args) throws Exception { //1개의 스레드 
		// 여러가지 일을 동시에 
		// /ᐠ - ˕ -マ Ⳋ 5번 
		// 작업스레드 ## 3단계 
		Thread sound = new Sound();
		Thread cnt = new CatCount();
		sound.start();
		cnt.start();
		for(int i =0; i<5;i++) {
			System.out.print("    /ᐠ - ˕ -マ Ⳋ    ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // E main

} // E class
