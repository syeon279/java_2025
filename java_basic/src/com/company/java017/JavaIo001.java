package com.company.java017;

import java.io.File;
import java.io.IOException;

public class JavaIo001 {

	public static void main(String[] args) {
		String folder_rel = "C:\\java017\\";
		//String folder_rel = "src/com/company/java017/";
		String file_rel = "file001.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_rel);
		try {
			if(!folder.exists()) {
				folder.mkdir();
			}
			if(!file.exists()){
				file.createNewFile();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("폴더/파일 준비완료!");
	}

} // 1. ctrl + f11  2. f5
