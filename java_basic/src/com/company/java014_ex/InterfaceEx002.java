package com.company.java014_ex;

interface Board{
	public void exec();
}
class BoardInsert implements Board{
	@Override
	public void exec() {
		System.out.println("게시판 삽입기능 입니다.");
	}
}

class BoardDelete implements Board{
	@Override
	public void exec() {
		System.out.println("게시판 삭제기능 입니다.");
	}
}

class BoardSelect implements Board{
	@Override
	public void exec() {
		System.out.println("게시판 선택기능 입니다.");
	}
}

class BoardUpdate implements Board{
	@Override
	public void exec() {
		System.out.println("게시판 수정기능 입니다.");
	}
}

public class InterfaceEx002 {
	public static void main(String[] args) {
		Board board = null;
		board = new BoardInsert(); board.exec();
		board = new BoardDelete(); board.exec();
		board = new BoardSelect(); board.exec();
		board = new BoardUpdate(); board.exec();
	}

}
