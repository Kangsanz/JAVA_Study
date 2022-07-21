package com.varxyz.jvx330.di.example7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;

//	신규 메뉴 아이템 등록
	@Override
	public void addMenuItem(MenuItem menuitem) {
		menuItemDao.addMenuItem(menuitem);
	}

// 모든 메뉴 조회
	@Override
	public List<MenuItem> findAllMenuItem() {
		return menuItemDao.findAllMenuItems();
	}

// 이름으로 메뉴 조회
	@Override
	public MenuItem findNameMenuItem(String name) {
		return menuItemDao.findNameMenuItems(name);
	}
}
