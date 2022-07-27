package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistController {

	@GetMapping("/example2/step1")
	public String heandleStep1() {
		return "example2/step1"; // 약관 페이지
	}

	@PostMapping("/example2/step2")
	public String heandleStep2() {
		return "example2/step2"; // 회원가입 페이지
	}
	
	@PostMapping("/example2/step3")
	public String heandleStep3() {
		return "example2/step3"; // 가입 후 성공 페이지
	}
}
