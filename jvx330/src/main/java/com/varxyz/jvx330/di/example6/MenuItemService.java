package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;

	public void addMenuItem(MenuItem menuitem) {
		menuItemDao.addMenuItem(menuitem);
	}

	public List<MenuItem> getAllMenuItems() {
		return menuItemDao.findAllMenuItems();
	}

	public MenuItem getNameMenuItems(String name) {
		return menuItemDao.findNameMenuItems(name);
	}
}
