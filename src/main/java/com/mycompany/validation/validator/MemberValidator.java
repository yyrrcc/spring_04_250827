package com.mycompany.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycompany.validation.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberDto memberDto = (MemberDto) target;
		String id = memberDto.getId();
		String pw = memberDto.getPw();
		String confirmPw = memberDto.getConfirmPw();
		String name = memberDto.getName();
		String email = memberDto.getEmail();
		Integer age = memberDto.getAge();
		
		// 필드 값 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id_empty", "아이디는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "pw_empty", "비밀번호는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPw", "confirmPw_empty", "비밀번호(확인)는 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name_empty", "이름은 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email_empty", "이메일은 필수 입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age_empty", "나이는 필수 입력 사항입니다.");
		
		// 아이디 길이 5자 이상인지 확인
		if (id != null && id.length() < 5) { // 참이면 error
			errors.rejectValue("id", "id_short", "아이디는 5자 이상이어야 합니다.");
		}
		
		// 비밀번호 길이 8자 이상인지 확인
		if (pw != null && pw.length() < 8) { 
			errors.rejectValue("pw", "pw_short", "비밀번호는 8자 이상이어야 합니다.");
		}
		
		// 비밀번호 일치 여부 확인
		if (pw != null && !pw.equals(confirmPw)) {
			errors.rejectValue("confirmPw", "pw_mismatch", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		// 나이 18살 이상인지 확인
		if (age == null || age < 18) { 
			errors.rejectValue("pw", "age_under18", "나이가 18세 이상만 가능합니다.");
		}
	}

}
