package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor  // 필드 없는 생성자
@AllArgsConstructor // 필드 있는 생성자
@ToString 
@EqualsAndHashCode 
public class BoardDto {
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;

}
