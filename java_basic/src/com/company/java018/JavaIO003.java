package com.company.java018;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class JavaIO003 {
	public static void main(String[] args) {
		//1. 경로준비
		String folder_rel = "src/com/company/java018/";
		String file_rel = "file003.txt";
		
		//2. 폴더+파일 만들기
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
		
		//3. char 쓰기   Reader > [프로그램] > Writer #
		try {
			Writer writer = new FileWriter(file);
			writer.write("Hello");
			writer.flush();
			writer.close();
			System.out.println("쓰기 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//4. char 읽기 Reader# > [프로그램] > Writer
		try {
			Reader reader = new FileReader(file);
			int cnt = 0;
			while((cnt=reader.read())!=-1){
				System.out.print((char)cnt);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
