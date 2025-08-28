package com.mycompany.validation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.validation.dto.MemberDto;
import com.mycompany.validation.validator.MemberValidator;

@Controller
public class MemberController {
	
	@RequestMapping (value = "/memberJoin")
	public String memberJoin() {
		return "memberJoin";
	}
	@RequestMapping (value = "/memberJoinOk")
	public String memberJoinOk(@ModelAttribute("memberDto") MemberDto memberDto, Model model, BindingResult result) {
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		// 에러가 있는지 확인 (유효성 체크)
		if (result.hasErrors()) {
			List<ObjectError> objectErrors = result.getAllErrors(); // 모든 에러 받기
			List<String> errorMsgs = new ArrayList<String>();
			for (ObjectError objectError : objectErrors) {
				String errorMsg = objectError.getDefaultMessage(); // 에러 메시지
				errorMsgs.add(errorMsg);
			}
			model.addAttribute("signupError", "회원 가입에 실패하였습니다.");
			model.addAttribute("errorMsgs", errorMsgs);
			return "memberJoin";
		}
		model.addAttribute("memberDto", memberDto);
		return "memberJoinOk";
	}

}
