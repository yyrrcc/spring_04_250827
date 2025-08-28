package com.mycompany.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
public class MemberDto {
	private String id;
	private String pw;
	private String confirmPw;
	private String name;
	private String email;
	private Integer age; // null값 확인을 위해
	
	
}
