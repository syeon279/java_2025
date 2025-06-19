package com.company.project001.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
	@NonNull String  userid;
	@NonNull private String userpw;
	private char enabled;
	
	private List<AuthDto> authList;
}
