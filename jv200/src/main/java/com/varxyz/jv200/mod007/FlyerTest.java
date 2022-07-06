package com.varxyz.jv200.mod007;

public class FlyerTest {
	public static void main(String[] args) {
		Flyer f = new Airplane();
		Flyer b = new Bird();
		Vehicle a = new Airplane();

		f.takeOff();
		b.takeOff();
		a.test2();
	}
}