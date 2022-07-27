package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/example1/sayHello", method = RequestMethod.GET) // 아무것도 안쓰면 GET 방식
	public ModelAndView sayHello() {
		String greeting = "Hello! 스프링 MVC";

		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello");
		mav.addObject("greeting", greeting);

		return mav;
	}
}
