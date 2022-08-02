package com.varxyz.jvx330.mvc.example6.product.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.varxyz.jvx330.mvc.example6.product.domain.Product;

public class CategoryRowMapper implements RowMapper<Product> {

	private Product product;

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		product.setMidBigCategory(rs.getInt("midBigCategory"));
		product.setProMidCategory(rs.getInt("proMidCategory"));
		product.setBigName(rs.getString("bigName"));
		product.setMidName(rs.getString("midName"));
		product.setProName(rs.getString("proName"));
		product.setProPrice(rs.getLong("proPrice"));
		product.setProImage(rs.getString("proImage"));

		return product;
	}
}
