package com.company.java014_ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//1. 클래스는 부품객체 (멤버변수/ 멤버함수)
//2. 클래스는 조립해서 사용한다. 
class MyView implements ActionListener {
	// 멤버 변수(frame: 틀/button: 버튼)
	JFrame frame; JButton button;
	public MyView() {
		frame = new JFrame("BOX");
		button = new JButton("BUTTON");
	}
	
	// 멤버 함수
	public void create() {
		//2-1. frame.add(컴포넌트)
		frame.add(button);
		//2-2. frame.size(가로, 세로)
		frame.setSize(300,300);
		//2-3. frame.setVisible
		frame.setVisible(true);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Hi");
	}
}

public class NonameClassEx002 {
	public static void main(String[] args) {
		new MyView().create();
	}

}
