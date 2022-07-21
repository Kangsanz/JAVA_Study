package com.varxyz.jvx330.di.example7;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode // 중복값 비교

public class MenuItem {
	private String name;
	private double price;
}