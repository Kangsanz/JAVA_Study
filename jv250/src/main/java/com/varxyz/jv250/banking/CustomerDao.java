package com.varxyz.jv250.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao { // DB 관련 내용을 상수로 설정
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWORD = "jv250";

	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 연결
			System.out.println("LOADED DRIVER --->" + JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Customer> findAllCustomers() { // 전체 고객 검색
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); // DB와 연결
				pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
				rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("CustomerId"));
					customerList.add(c);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList; // List 에 결과값을 받음
	}

	public Customer findCustomerBySsn(String ssn) { // 해당 ssn을 가진 고객 검색
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null; // 위와 다르게 c라는 Cutomer 변수 생성, 방법은 둘다 맞음
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("CustomerId"));
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public void addCustomers(Customer customer) { // Customer 추가
		String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwd) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getCustomerId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			System.out.println("INSERTED....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CustomerDao customerdao = new CustomerDao();

		System.out.println(customerdao.findCustomerBySsn("961025-7894561").getPhone());
	}
}
