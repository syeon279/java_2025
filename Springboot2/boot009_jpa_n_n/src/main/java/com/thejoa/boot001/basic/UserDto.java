package com.thejoa.boot001.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter 
@Setter 
@NoArgsConstructor
@ToString
public class UserDto {
	private String name;
	private int age;
}


// com.회사명.프로젝트.개발단위 - @Controller / @Servlet/@Db관련