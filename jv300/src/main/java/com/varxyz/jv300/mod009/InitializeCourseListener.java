package com.varxyz.jv300.mod009;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized() method called");

		ServletContext context = event.getServletContext();
		InputStream is = null;
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<>();
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt"); // 텍스트를 Character 타입으로 읽어온 것을 is에
																						// 담음
			reader = new BufferedReader(new InputStreamReader(is)); // Character 타입 텍스트를 String으로 변환하고, BufferedReader로
																	// 텍스트를 모은것을 reader에 담음
			String record = null;
			while ((record = reader.readLine()) != null) { // 한 라인의 텍스트를 읽어오고, 텍스트가 없을 때 까지 계속 읽어옴
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			context.log("The course contents has been loaded");
		} catch (Exception e) {g
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed() method called");
	}

//	private String escapeHtml(String line) {
//		if (line.length() == 0) {
//			return line;
//		}
//		return line.replace("<", "&lt;").replace(">", "&gt;");
//	}
}
