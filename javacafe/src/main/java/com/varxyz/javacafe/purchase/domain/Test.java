package com.varxyz.javacafe.purchase.domain;

public class Test {

	public static void main(String[] args) {
		Item item = new Item(null);

		item.setProName("테스트용1");
		item.setProName("테스트용2");

		System.out.println(item.getProName());
	}

}
