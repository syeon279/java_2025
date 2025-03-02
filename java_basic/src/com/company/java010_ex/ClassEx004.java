package com.company.java010_ex;
//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
//3. 클래스는 자동으로 부품객체의 이름과 동일한 생성자를 호출해 초기화가 이루어짐. 

import java.util.Scanner;

class TV{
	// 상태    채널, 볼륨
	String channel; int volume;
	// 행위 - 멤버함수
	// 채널 볼륨 입력 : input()/ 출력: show
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("채널을 입력하세요> "); this.channel = scanner.next();
		System.out.print("볼륨을 입력하세요> "); this.volume = scanner.nextInt();
	}
	void show() {
		System.out.println("현재 채널: " + channel);
		System.out.println("현재 볼륨: " + volume);
	}
	public TV() { //기본생성자, 디폴트 생성자. 파라미터가 없으면 이쪽으로 옴. 컴파일러가 자동생성. BUT 생성자를 개발자가 손대는 순간 자동생성 취소. 
		// 리턴값이 없고, 클래스명과 동일. 
		channel = "mbc";
		volume = 15;
	}
	public TV(String channel, int volume) {
		this.channel = channel;
		this.volume = volume;
	}
}
class TV2_ai extends TV{
	// 디폴트 생성자가 없으면 상속 시 오류 남. 
}
	
public class ClassEx004 {

	public static void main(String[] args) {
		TV tv1 = new TV();
		TV tv2 = new TV("youtube",20);
		TV tv3 = new TV();
		System.out.println("==기본생성자==");
		tv1.show();
		System.out.println("==파라미터가 있는 생성자");
		tv2.show();
		System.out.println("==입력함수를 사용한 생성자");
		tv3.input();
		tv3.show();
	}

}

/*
------------------------------------------------------------------ runtime 
[method]	TV.class / ClassEx004.class  #1
------------------------------------------------------------------
[heap]   		         					| [stack]
												} 이후 프로그램 종료
2번지{channel=하하, volume=34}					   tv3.show {2번지의 채널, 볼륨 출력}
2번지{channel=하하, volume=34}					   tv3.input {스캐너, 2번지의 채널, 볼륨에다 입력한 값을 대입 후 사라짐.}
2번지{channel=null, volume=0}					<- tv3.2번지
											   tv2.show {1번지의 채널, 볼륨 출력} 임시공간. 
1번지{channel=youtube, volume=20}				<- tv2
						  					| main  #2
------------------------------------------------------------------
*/


