package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Customer;

public class CustomerDao {

	public CustomerDao() {

	}

	// 전체 고객 검색
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection(); // DB와 연결
				pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
				rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					customerList.add(c);
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
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
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public void addCustomers(Customer customer) { // Customer 추가
		String sql = "INSERT INTO Customer(name, ssn, phone, userId, passwd) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = DataSourceManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getUserId());
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
