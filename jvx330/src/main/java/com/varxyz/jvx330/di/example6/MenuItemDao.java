package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

public class MenuItemDao {
	private static final List<MenuItem> menuItems = new ArrayList<MenuItem>();

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
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
		return null;
	}
}
