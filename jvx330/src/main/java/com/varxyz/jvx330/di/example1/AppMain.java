package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml"; // beans 경로
		GenericApplicationContext context = new GenericXmlApplicationContext(config); // beans.xml를 불러오는 컨테이너 생성

		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		context.close();
	}
}
