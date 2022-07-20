package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml"; // beans 경로
		GenericApplicationContext context = new GenericXmlApplicationContext(config); // beans.xml를 불러오는 컨테이너 생성
		Hello hello = context.getBean("helloBean", Hello.class); // 타입이 Hello 이기 때문에 쉼표로 적어줌
//		Hello hello = (Hello) context.getBean("helloBean"); 위와 같음
		
//		Hello hello = new HelloBeanEn();
		System.out.println(hello.sayHello("Spring"));
		context.close();
	}
}
