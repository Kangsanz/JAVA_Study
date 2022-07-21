package com.varxyz.jvx330.di.example7;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MenuTest {

	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MenuItemService controller = context.getBean("menuItemService", MenuItemService.class);

		// 1.등록
		controller.addMenuItem(new MenuItem("아아", 1500));
		controller.addMenuItem(new MenuItem("아바라", 2500));
		controller.addMenuItem(new MenuItem("민초라", 3000));

		// 2.조회
		List<MenuItem> list = controller.findAllMenuItem();
		for (MenuItem item : list) {
			System.out.println(item);
		}
		System.out.println("------------------------------------");

		// 3.검색
		MenuItem item = controller.findNameMenuItem("아아");
		System.out.println(item);

		context.close();
	}
}
