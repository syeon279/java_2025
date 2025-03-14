package com.company.java019_ex;

import javax.swing.JOptionPane;

class QuestionCount extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for(int i=10;i>0;i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	} //E run

	void stopThread() {
		super.interrupt();
	}
}// E class

public class ThreadEx001 {
	public static void main(String[] args) {
		Thread count = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=10;i>0;i--) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						break;
					}
				}
			}
		});
		count.start();
		
		String answer = JOptionPane.showInputDialog("사과를 영어로?");
		System.out.println(answer);
		if(answer.equals("apple")) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("정답이 아닙니다.");
		}
		if(answer!=null) {
			count.interrupt();
		}
		System.out.println("End main");
	} // E main
} // E class
