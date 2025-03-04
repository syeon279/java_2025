package com.company.java011_ex;
//Cat 부품 
// class Cat {같은 폴더에서 class 사용해야함
public class Cat {
	public int public_;
	protected int protected_;
			  int package_;
	private   int private_; //Cat 내부에서만 접근 가능
	
	public int getProtected_() {
		return protected_;
	}
	public void setProtected_(int protected_) {
		this.protected_ = protected_;
	}
	// alt shift s > getters+stters
	public void setPrivate_(int i) {
		this.private_=i;
	}
	public int getPrivate_() {
		return 0;
	}
	
}
