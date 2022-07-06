package com.varxyz.jv200.mod011;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(new Integer(1), "유비");
		map.put(Integer.valueOf(2), "관우");
		map.put(3, "장비");

		System.out.println(map.get(new Integer(3)) + "\n");

		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			System.out.println(integer);
			System.out.println(map.get(integer));
		}
	}
}
