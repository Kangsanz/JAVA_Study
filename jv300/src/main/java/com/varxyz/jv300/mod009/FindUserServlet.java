package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/find_User.do")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
																		// 유지보수성을 높임
		userService = new UserService(); // init 메소드에 넣음으로써, 여러 개의 객체 생성을 방지함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");

		List<String> errorMsgs = new ArrayList<>();
		if (userName == null || userName.length() == 0) {
			errorMsgs.add("userName는 필수입력 정보입니다.");
		}

		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		User user = new User();
		user.setUserName(userName);

		// 3. 비즈니스 서비스 호출
		request.setAttribute("userName", userName);
		List<User> userList = userService.findUser(userName);
		request.setAttribute("userList", userList);

		dispatcher = request.getRequestDispatcher("find_User.jsp");
		dispatcher.forward(request, response);
	}
}
