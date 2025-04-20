package com.ysh.boot010.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter @Setter @NoArgsConstructor @ToString
public class UserDto {
	private String name;
	private int age;
}


// com.compnay(회사명).프로젝트.개발단위 - @Controller /@Servlet /@DB 관련