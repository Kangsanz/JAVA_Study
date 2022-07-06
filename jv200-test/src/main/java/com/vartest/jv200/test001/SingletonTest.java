package com.vartest.jv200.test001;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton print1 = Singleton.getInstance();
		print1.print();

		Singleton print2 = Singleton.getInstance();
		print2.print();
	}
}

