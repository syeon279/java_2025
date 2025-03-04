package com.company.java011;

//class Cat2{ //The type Cat2 is already defined
//	//package - default - 기본 - 같은 폴더에서 사용가능
//}

public class Modifier3_package {
	public static void main(String[] args) {
		Cat2 cat = new Cat2();
		//import안해도 사용가능! 같은 패키지 안에 있기 때문에
		cat.public_=10;
//		cat.protected_=20; //외부라서 사용X Cat2에서만 사용 가능
//		cat.package_=30; //같은 폴더에서만
//		cat.private_=40; //getters/setters
		cat.show();
	}
}
