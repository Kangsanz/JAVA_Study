package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_USERID = "홍길동";
	public static final String DEFAULT_PASSWD = "hong1234";
	public static final String DEFAULT_USERNAME = "허균";
	public static final String DEFAULT_SSN = "691103";
	public static final String DEFAULT_EMAIL1 = "홍길동123";
	public static final String DEFAULT_EMAIL2 = "naver.com";
	public static final String[] DEFAULT_CONCERNS = new String[0];

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if (userId == null || userId.length() == 0) {
			userId = DEFAULT_USERID;
		}
		String passwd = request.getParameter("passwd");
		if (passwd == null || passwd.length() == 0) {
			passwd = DEFAULT_PASSWD;
		}
		String userName = request.getParameter("userName");
		if (userName == null || userName.length() == 0) {
			userName = DEFAULT_USERNAME;
		}
		String ssn = request.getParameter("ssn");
		if (ssn == null || ssn.length() == 0) {
			ssn = DEFAULT_SSN;
		}
		String email1 = request.getParameter("email1");
		if (email1 == null || email1.length() == 0) {
			email1 = DEFAULT_EMAIL1;
		}
		String email2 = request.getParameter("email2");
		if (email2 == null || email2.length() == 0) {
			email2 = DEFAULT_EMAIL2;
		}
		String[] concerns = request.getParameterValues("concerns");
		if (concerns == null || concerns.length == 0) {
			concerns = DEFAULT_CONCERNS;
		}

		String pageTitle = "회원가입 폼";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h2>" + "회원가입 승인서" + "</h3>");
		out.println("<h3>" + "회원아이디 : " + userId + "</h3>");
		out.println("<h3>" + "비밀번호 : " + passwd + "</h3>");
		out.println("<h3>" + "이름 : " + userName + "</h3>");
		out.println("<h3>" + "주민번호 : " + ssn + "</h3>");
		out.println("<h3>" + "이메일 : " + email1 + "@" + email2 + "</h3>");
		out.println("<h3> 관심분야 : ");
		for (int j = 0; j < concerns.length; j++) {
			out.println("[ " + concerns[j] + " ] ");
		}
		out.println("</h3>");
		out.println("</body></html>");
		out.close();
	}
}
