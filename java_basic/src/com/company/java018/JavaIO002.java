package com.company.java018;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIO002 {
	public static void main(String[] args) {
		// #1. 경로준비
		String folder_rel = "src/com/company/java018/";
		String file_rel = "file002.txt";
		
		// #2. 폴더 파일 만들기
		File folder = new File(folder_rel);
		File file = new File(folder_rel+file_rel);
		
		try {
			if(!folder.exists()) {
				folder.mkdir();
			}
			if(!file.exists()) {
				file.createNewFile();
			}
			System.out.println("준비 완료!");
		} catch(IOException e) {
			e.printStackTrace(); //?
		}
		
		// #3. byte 파일 쓰기  IntputStream > [프로그램] > OutputStream 
		try {
			OutputStream output = new FileOutputStream(file);
			output.write('j');
			output.write('a');
			output.write('v');
			output.write('a');
			output.flush();
			output.close();
			System.out.println("OutputStream 쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// #4. 파일 읽기     InputStream > [프로그램] > OutputStream
		try {
			InputStream input = new FileInputStream(file);
			int cnt = 0;
			while((cnt=input.read())!=-1) { //-1 파일 끝남
				System.out.println((char)cnt);
			}
			
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
