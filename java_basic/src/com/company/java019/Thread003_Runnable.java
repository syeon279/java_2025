package com.company.java019;
//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 = 자원 + Thread => 작업수행 클래스 
//3. 작업수행 클래스 1. 상속, Runnable 2. run() 해야할 일 3 start() 실행
class Human {
	
}
class SayHi extends Human implements Runnable {
	@Override
	public void run() {
		try {
//			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<5;i++) {
			System.out.print("  안녕!  ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} // 1000 이 1초
		}
	}
	
} // E class

public class Thread003_Runnable {

	public static void main(String[] args) {
		//⎛⎝(•‿•)⎠⎞
		Thread sayhi = new Thread(new SayHi());
		sayhi.start();;
		
		Thread count = new Thread( new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println((i+1)+"명 ");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}// E run
		});
		count.start();
		
		for(int i=0;i<5;i++) {
			System.out.print("  ⎛⎝(•‿•)⎠⎞  ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // E main

} // E class
