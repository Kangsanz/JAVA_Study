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

@WebServlet("/mod009/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void init(ServletConfig config) throws ServletException { // ServletConfig 는 서블릿 기본 설정이라는 개념, 코드와 분리해서 사용하여
																		// 유지보수성을 높임
		userService = new UserService(); // init 메소드에 넣음으로써, 여러 개의 객체 생성을 방지함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 1. 폼 파라메터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");

		// 2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.add("ID는 필수입력 정보입니다.");
		}
		if (passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		if (userName == null || userName.length() == 0) {
			errorMsgs.add("userName는 필수입력 정보입니다.");
		}
		if (ssn == null || ssn.length() == 0) {
			errorMsgs.add("ssn는 필수입력 정보입니다.");
		}
		if (email1 == null || email1.length() == 0) {
			errorMsgs.add("email1는 필수입력 정보입니다.");
		}
		if (email2 == null || email2.length() == 0) {
			errorMsgs.add("email2는 필수입력 정보입니다.");
		}
		if (addr1 == null || addr1.length() == 0) {
			errorMsgs.add("addr1는 필수입력 정보입니다.");
		}
		if (addr2 == null || addr2.length() == 0) {
			errorMsgs.add("addr2는 필수입력 정보입니다.");
		}

		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn(ssn);
		user.setEmail(email1 + "@" + email2);
		user.setAddr(addr1 + " " + addr2);

		// 3. 비즈니스 서비스 호출
		userService.addUsers(user);
		request.setAttribute("user", user);

		// 4. NextPage
		request.setAttribute("userId", userId);
		request.setAttribute("passwd", passwd);
		request.setAttribute("userName", userName);
		request.setAttribute("ssn", ssn);
		request.setAttribute("email", email1 + "@" + email2);
		request.setAttribute("addr", addr1 + " " + addr2);
		dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}
}
