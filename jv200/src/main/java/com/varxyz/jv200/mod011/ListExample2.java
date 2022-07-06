package com.varxyz.jv200.mod011;

import java.util.*;

public class ListExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("3rd");
		list.add("second");
//		list.add(new Integer(4));
//		list.add(new Float(5.0F));
//		list.add(new Integer(4));
		list.add("배고프다");

		String total = (String) list.get(3);
		System.out.println(list);
		System.out.println(total);

		int[] arrayNum = new int[] { 1, 2, 3, 4, 5 };

		for (int e : arrayNum) {
			System.out.print(e + " ");
		}
	}
}
