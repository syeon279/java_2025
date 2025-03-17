package com.company.java018;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class JavaIO005 {

	public static void main(String[] args) {
		//1. 경로 만들기
		String folder_rel = "src/com/company/java018/";
		String file_rel = "file005";
		
		// 2. 폴더 + 파일 만들기
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
		
//		//3. 파일 쓰기(byte 단위)
		// 1) InputStream > [Program] > OutputStream
		// BufferdWriter(속도향상) - OutputStreamWriter(단어) - FileOutputStream(byte)
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				bw.write("1, white, 1200\n");
				bw.write("2, choco, 1500\n");
				bw.write("3, banana, 1800\n");
				bw.flush();
				bw.close();
				System.out.println("쓰기 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		//4. 파일 읽기(byte 단위)
			try {
				BufferedReader br =
				new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
//				System.out.println(br.readLine());
				String line ="";
				StringBuffer sb = new StringBuffer();
				while((line=br.readLine())!= null) {
					sb.append(line+"\n");
				}
				System.out.println(sb.toString());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	} // E main

} // E class
