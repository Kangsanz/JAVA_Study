package com.vartest.jv200.test001;

// 자바 싱글톤 패턴 실습
public class Singleton {
	private Singleton() {
		System.out.println("Constructor");
	}

	private static class LazyHolder {
		private static final Singleton instance = new Singleton();
	}

	public static Singleton getInstance() {
		return LazyHolder.instance;
	}

	public void print() {
		System.out.println("Singleton 객체(instance) 주소값(Hash) : " + LazyHolder.instance.hashCode());
	}
}