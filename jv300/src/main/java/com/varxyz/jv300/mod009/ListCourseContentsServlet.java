package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/list_course_contents.do")
public class ListCourseContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String[]> contentList;

	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		contentList = (List<String[]>) context.getAttribute("contentList");
		contentList = tapToSpace(contentList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentList", contentList);
		request.getRequestDispatcher("list_course_contents.jsp").forward(request, response);
	}

	private List<String[]> tapToSpace(List<String[]> contentList) {
		if (contentList != null) {
			for (String[] contents : contentList) {
				for (int i = 0; i < contents.length; i++) {
					if (contents[i].length() == 0) {
						contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
				}
			}
		} else {
			String[] str = new String[] { "=No Data=" };
			ArrayList<String[]> list = new ArrayList<>();
			list.add(str);
			contentList = list;
		}
		return contentList;

//		if (contentList.size() > 0) {
//			for (String[] contents : contentList) {
//				// empty line처리
//				if (isEmptyLine(contents)) {
//					continue;
//				}
//				for (int i = 0; i < contents.length; i++) {
//					if (contents[i].length() == 0) {
//						contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
//					}
//				}
//			}
//		} else {
//			lineList.add("-No Data-");
//		}
//
//		String line = "";
//		for (String[] contents : contentList) {
//			for (String s : contents) {
//				line += s;
//			}
//			lineList.add(line);
//			line = "";
//		}
//		return lineList;
//	}
//
//	private boolean isEmptyLine(String[] line) {
//		return false;
//
	}
}
