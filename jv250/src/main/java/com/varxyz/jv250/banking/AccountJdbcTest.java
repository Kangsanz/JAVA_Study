package com.varxyz.jv250.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountJdbcTest {
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

			select(con);
			insert(con);
			select(con);
			con.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // rs에 저장
			while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
				Long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				Double balance = rs.getDouble("balance");
				Double interestRate = rs.getDouble("interestRate");
				Double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);

				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println("-------------------");
			}
			pstmt.close();
			System.out.println("SELECT COMPLETED...\t");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "456-78-9012");
			pstmt.setDouble(2, 3000.0);
			pstmt.setDouble(3, 0.03);
			pstmt.setDouble(4, 0.0);
			pstmt.setString(5, String.valueOf('S'));
			pstmt.setLong(6, 1004);

			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("NEW ACCOUNT INSERTED...\t");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
