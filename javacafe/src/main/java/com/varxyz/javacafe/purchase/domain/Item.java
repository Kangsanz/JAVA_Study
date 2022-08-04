package com.varxyz.javacafe.purchase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
	private String proName;

	public Item(String proName) {
		setProName(proName);
	}
}
