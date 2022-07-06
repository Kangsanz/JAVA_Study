package com.varxyz.jv200.mod005;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("Thinkpad"));
		cart.addProduct(new SmartPhone("Samsung Galaxy"));
		cart.addProduct(new SmartPhone("Apple Iphone"));
		
		System.out.println(cart.getDetails());
	}
}
