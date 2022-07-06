package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBCExample6 {
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

			String sql = "SELECT * FROM Account"; // 해당 문자열을 DB에 전달할 SQL메소드
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(); // rs에 저장
			while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
				Long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				Double balance = rs.getDouble("balance");
				Double interestRate = rs.getDouble("interestRate");
				Double overdraft = rs.getDouble("overdraft");
				String accountType = rs.getString("accountType");
				Long customerId = rs.getLong("customerId");
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println(customerId);
				System.out.println("-------------------");
			}
			rs.close(); // 열었다면 반드시 닫아줘야함 (반대순서로)
			stmt.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 무조건 실행되도록 finally에 넣어준다

		}
	}
}
