package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode
public class BoardDto {
	private int    bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int    bhit;
	private String bip;
}
 