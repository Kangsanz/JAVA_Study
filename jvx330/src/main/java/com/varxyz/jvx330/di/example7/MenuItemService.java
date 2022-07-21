package com.varxyz.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	
	public void addMenuItem(MenuItem Item);
	public List<MenuItem> findAllMenuItem();
	public MenuItem findNameMenuItem(String name);
}
