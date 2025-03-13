package com.company.java018;

import java.io.File;
import java.io.IOException;

public class Repeat003 {

	public static void main(String[] args) {
		String folder_rel = "src/com/company/java018/";
		String file_rel = "JavaIO002.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_rel);
		
		try {
			if(!folder.exists()) {
				folder.mkdir();
			}
			if(!file.exists()){
				file.createNewFile();
			}
			System.out.println("폴더/파일 준비완료!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
