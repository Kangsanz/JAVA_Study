package com.varxyz.javacafe.purchase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Cart {
	private String cartName;
	private Long cartPrice;
	private int count; // 상품 개수
}
