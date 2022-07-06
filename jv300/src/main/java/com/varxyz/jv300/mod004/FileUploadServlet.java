package com.varxyz.jv300.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/mod004/file_upload.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB, 2MB보다 커지면 저장소를 쓴다는 의미
		maxFileSize = 1024 * 1024 * 10, // 10MB, 업로드 최대 크기
		maxRequestSize = 1024 * 1024 * 50) // 50MB, 다른 정보들과 파일을 포함한 총합 크기, - 주면 무제한

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIR = "C:/temp"; // 경로를 상수로 지정

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File saveDir = new File(SAVE_DIR);
		if (!saveDir.exists()) { // 경로에 폴더가 존재하지 않는다면 폴더를 만듬
			saveDir.mkdir();
		}
		for (Part part : request.getParts()) { //request로 정보를 받아오고, part에 나눠서 정보를 저장한다는 의미
			// c:\temp\파일
			part.write(saveDir.getPath() + File.separator + extractFileName(part));
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully.</h3>");
		out.println("</body></html>");
		out.close();

//		Enumeration<String> en = request.getHeaderNames();
//		while (en.hasMoreElements()) {
//			String header = en.nextElement();
//			System.out.println(header + " = " + request.getHeader(header));
//		}
	}

	//파일 넘버를 구분
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("Content-Disposition: " + contentDisp);
		for (String s : contentDisp.split(";")) {
			if (s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", "");
			} else {
				return s;
			}
		}
		return "";
	}

}
