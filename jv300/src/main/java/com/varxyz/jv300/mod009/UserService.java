package com.varxyz.jv300.mod009;

import java.util.List;

public class UserService {
	private UserDao userDao = new UserDao();

	public UserService() {

	}

	public void addUsers(User user) {
		userDao.addUsers(user);
	}

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public User findUser(String userId) {
		return userDao.findUser(userId);
	}

	public boolean isVaildUser(String userId, String passwd) {
		User user = userDao.findUser(userId);

		if (user == null) {
			System.out.println("유저가 없습니다.");
			return false;
		} else {
			if (user.getPasswd().equals(passwd)) {
				System.out.println(user.getUserId());
				System.out.println(user.getPasswd());
				return true;
			} else {
				System.out.println("비밀번호가 틀립니다!");
				return false;
			}
		}
	}
}
