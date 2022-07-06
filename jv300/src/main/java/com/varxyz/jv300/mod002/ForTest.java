package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageTitle = "ForTest";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body style='display:flex; align-items:center; flex-direction: column;>");
		for (int i = 1; i < 10; i++) {
			out.println("<div class='column'>");
			for (int j = 1; j < 10; j++) {
				out.println("<div>" + i + "x" + j + "=" + i * j + "</div><br>");
			}
			out.println("</div>");
		}
		out.println("</body></html>");
		out.close();
	}
}
