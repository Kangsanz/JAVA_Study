package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBCExample8 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";

		try {
			Class.forName(driver); // 드라이버 연결
			System.out.println("LOADED DRIVER --->" + driver);

			Connection con = DriverManager.getConnection(url, id, passwd); // DB와 연결
			System.out.println("CONNECTED TO --->" + url);
			
			String sql = "UPDATE Account SET balance=?, overdraft=? WHERE aid=?";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setString(1, "444.0"); // ? 내용 입력
			stmt.setString(2, "4444.0"); // ? 내용 입력
			stmt.setLong(3, 3004); // ? 내용 입력
			stmt.executeUpdate(); // 데이터베이스 내용 업데이트

			System.out.println("UPDATED....");
			stmt.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 무조건 실행되도록 finally에 넣어준다

		}
	}
}
