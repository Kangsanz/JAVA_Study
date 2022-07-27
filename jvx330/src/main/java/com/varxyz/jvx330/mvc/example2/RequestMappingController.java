package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // 원래는 이름도 달아줘야 충돌 위험 없어짐
public class RequestMappingController {

	@RequestMapping(value = "/example2/mapping", method = RequestMethod.GET) // 메소드를 불러주는 URL
	public String getMapping() { // 메소드를 불러줘야함
		return "example2/mapping_result";
	}

	@RequestMapping(value = "/example2/mapping", method = RequestMethod.POST)
	public ModelAndView postMapping() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result");
		mav.addObject("result", "post 요청의 결과 메세지");
		
		return mav;
	}
}
