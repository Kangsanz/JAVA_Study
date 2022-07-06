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

@WebServlet("/mod009/find_AllUser.do")
public class FindAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
																		// 유지보수성을 높임
		userService = new UserService(); // init 메소드에 넣음으로써, 여러 개의 객체 생성을 방지함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 3. 비즈니스 서비스 호출
		List<User> userList = userService.findAllUsers();
		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("find_AllUser.jsp");
		dispatcher.forward(request, response);
	}
}
