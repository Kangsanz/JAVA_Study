package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.varxyz.jv300.mod009.UserService;

@WebServlet("/mod010/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void init() {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // true로 설정되면 session을 새로 만듬, 새로 만들면 사용자를 알 수 없게 됨
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			if (cookie.getName().equals("lastAccessTime")) {
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
		response.addCookie(lastAccessTime());
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date());
		format.format(new Date());

		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath("/"); // '/' 를 사용하면 어떤 사이트라도 쿠키를 전부 심는다는 의미

		return cookie;
	}

}
