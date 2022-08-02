package com.varxyz.javacafe.purchase.domain;

import com.varxyz.javacafe.product.domain.Product;

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
