package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml"; // beans 경로
		GenericApplicationContext context = new GenericXmlApplicationContext(config); // beans.xml를 불러오는 컨테이너 생성

		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		
		Foo foo1 = context.getBean("foo", Foo.class);
		System.out.println(foo1); // hash 값이 같음, 같은 객체를 재활용하고 있음
		
		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2);
		context.close();
	}
}
