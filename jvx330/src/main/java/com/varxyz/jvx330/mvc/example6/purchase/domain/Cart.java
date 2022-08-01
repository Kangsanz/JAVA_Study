package com.varxyz.jvx330.mvc.example6.purchase.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private static Cart cart = new Cart();

	private static List<MenuList> cartList;

	private Cart() {
		cartList = new ArrayList<MenuList>();
	}

	public static Cart getCart() {
		return cart;
	}

	public List<MenuList> getCartList() {
		return cartList;
	}

	public void addList(MenuList menuList) {
		cartList.add(menuList);
	}

	public void cleanCartList() {
		cartList.clear();
	}
}
