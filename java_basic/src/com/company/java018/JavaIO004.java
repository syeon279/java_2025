package com.company.java018;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004 {

	public static void main(String[] args) throws Exception {
		// 1. 경로
		String origin = "src/com/company/java018/puppy.png";
		String target1 = "src/com/company/java018/puppy1.png";
		String target2 = "src/com/company/java018/puppy2.png";
		
		// 2. byte 단위로 이미지 파일 읽어들여서 쓰기
		// puppy.png -> puppy.png
		// InputStream (읽기) > [Program] > OutputStream(쓰기)
		InputStream bis = new FileInputStream(origin);
		OutputStream bos = new FileOutputStream(target1);
		
		int cnt1 = 0;
		while ((cnt1 = bis.read())!=-1) {
			bos.write((byte)cnt1);
		}
		bos.flush(); bos.close(); bis.close();
		System.out.println(">복사 완료!");
		
		// 3. char 단위로 이미지 파일 읽어들여서 쓰기 
//		Reader cr = new FileReader(origin);
		Reader cr = new FileReader(origin);
		Writer cw = new FileWriter(target2);
		
		int cnt2 =0;
		while ((cnt2 = cr.read())!=-1) {
			cw.write((char)cnt2);
		}
		cw.flush(); cw.close(); cr.close();
		System.out.println(">> 이미지 복사 완료!"); // 이미지 깨짐. 
		
	} // E main

} // E class 
