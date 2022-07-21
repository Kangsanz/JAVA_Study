package com.varxyz.jvx330.di.example3;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
//		String config = "com/varxyz/jvx330/di/example3/beans.xml"; // XML 방식
//		GenericApplicationContext context = new GenericXmlApplicationContext(config); // XML 방식

		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // 클래스Configuration방식

		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.getAllMembers().forEach(member -> System.out.println(member));

//		List<Member> list = memberService.getAllMembers();
//		for (Member member : list) {
//			System.out.println(member);
//		}

		context.close();
	}
}
