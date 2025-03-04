package com.company.java011;

import com.company.java011_ex.Cat;

public class Modifier1_public {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.public_ = 10;
		//cat.protected_
		//cat.package_
		//cat.private_
		cat.setPrivate_(100);
		System.out.println(cat.public_ + "/"+cat.getPrivate_());
	}
}

