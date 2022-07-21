package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {

	@Autowired
	@Qualifier("sessionCartService") // 두 개의 중복된 서비스 중에 하나를 선택
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService") // 두 개의 중복된 서비스 중에 하나를 선택
	private CartService service2;

	public CartController() {
		System.out.println("CartController 생성");
	}

	public void processRequest() {
		service.addItem();
		service2.addItem();
	}
}
