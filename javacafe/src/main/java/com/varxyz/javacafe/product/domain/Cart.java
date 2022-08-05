package com.varxyz.javacafe.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cart {
	private String cartName;
	private Long cartPrice;

	public Cart() {
		super();
	}
}
