package com.varxyz.jvx330.di.example7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("menuItemDao")
public class MenuItemDao {
	private static final List<MenuItem> menuItems = new ArrayList<MenuItem>();

	public void addMenuItem(MenuItem menuItem) {
		if (!menuItems.contains(menuItem)) { // 중복되지 않으면 넣는다
			menuItems.add(menuItem);
		}
	}

	public List<MenuItem> findAllMenuItems() {
		return menuItems;
	}

	public MenuItem findNameMenuItems(String name) {
		for (MenuItem menuItem : menuItems) {
			if (menuItem.getName().equals(name)) {
				return menuItem;
			}
		}
		throw new RuntimeException(name + " menu does not exist");
	}
}
