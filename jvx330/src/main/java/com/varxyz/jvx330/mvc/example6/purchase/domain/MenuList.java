package com.varxyz.jvx330.mvc.example6.purchase.domain;

import com.varxyz.jvx330.mvc.example6.product.domain.Product;

public class MenuList {

	private Product product;
	private int count;

	public MenuList(Product product, int count1) {
		this.product = product;
		count = count1;
	}

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}
}
