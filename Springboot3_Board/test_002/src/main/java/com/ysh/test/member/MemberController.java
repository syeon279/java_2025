package com.ysh.test.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String main() {
		return "member/login";
	}

	// http://localhost:8080/
	@GetMapping("member/member")
	public String member() {
		return "member/member";
	}

	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("member/login")
	public String login_post() {
		return "member/member";
	}

	@GetMapping("member/join")
	public String join(MemberForm memberForm) {
		return "member/join";
	}

	@PostMapping("member/join")
	public String join( @Valid MemberForm memberForm, BindingResult bindingResult, Model model) {
		System.out.println("도착했어...........................?");
		if (bindingResult.hasErrors()) {
		    return "member/join";
		}

		if (!memberForm.getPassword().equals(memberForm.getPassword2())) {
		    bindingResult.rejectValue("password2", "passwordInCorrect", "패스워드를 확인해주세요.");
		    return "member/join";
		}

		try {
		    Member member = new Member();
		    member.setUsername(memberForm.getUsername());
		    member.setEmail(memberForm.getEmail());
		    member.setPassword(passwordEncoder.encode(memberForm.getPassword()));
		    System.out.println(memberService.insertMember(member)); 
		} catch (DataIntegrityViolationException e) {
		    e.printStackTrace();
		    model.addAttribute("errorMessage", "이미 등록된 사용자입니다.");
		    System.out.println("이미 등록된 사용자입니다.");
		    return "member/join";
		} catch (Exception e) {
		    e.printStackTrace();
		    model.addAttribute("errorMessage", e.getMessage());
		    System.out.println(".........................................................."+e.getMessage());
		    return "member/join";
		}

		return "member/login";
	}
	
	@GetMapping("/checkUsername")
	@ResponseBody
	public int username(@RequestParam String username) {
		return memberService.countByUsername(username);
	}
	
}
