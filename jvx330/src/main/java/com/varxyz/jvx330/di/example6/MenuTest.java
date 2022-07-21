package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MenuTest {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);

		MenuItemService controller = context.getBean("menuItemService", MenuItemService.class);
		controller.addMenuItem(new MenuItem("아아", 1500));
		controller.addMenuItem(new MenuItem("아바라", 2500));
		controller.addMenuItem(new MenuItem("민초라", 3000));

		for (MenuItem findAll : controller.getAllMenuItems()) {
			System.out.println(findAll);
		}
		System.out.println("-------------------------------------");

		System.out.println(controller.getNameMenuItems("아아"));

		context.close();
	}
}
