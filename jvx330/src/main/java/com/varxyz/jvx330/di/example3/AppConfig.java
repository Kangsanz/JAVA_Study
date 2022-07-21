package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 관련된 클래스 임을 설정
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
