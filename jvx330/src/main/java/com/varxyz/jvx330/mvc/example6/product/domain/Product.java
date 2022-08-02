package com.varxyz.jvx330.mvc.example6.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product {
	private int midBigCategory;
	private int proMidCategory;
	private String bigName;
	private String midName;
	private String proName;
	private Long proPrice;
	private String proImage;

	public Product() {
		super();
	}
}
