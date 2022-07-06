package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
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

			String sql = "SELECT * FROM Customer WHERE name='유비'"; // 해당 문자열을 DB에 전달할 SQL메소드
			Statement stmt = con.createStatement(); //
			ResultSet rs = stmt.executeQuery(sql); // rs에 저장
			while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
				long cid = rs.getLong("cid");
				String customerId = rs.getString("customerId"); // 테이블에 해당 값을 받아옴
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				System.out.println(cid);
				System.out.println(customerId);
				System.out.println(name);
				System.out.println(phone);
				System.out.println("-------------------");
			}
			rs.close(); // 열었다면 반드시 닫아줘야함 (반대순서로)
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
