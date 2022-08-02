package com.varxyz.javacafe.product.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.product.domain.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate;

	public ProductDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 상품 생성
	public void addProduct(Product product) {
		String sql = "INSERT INTO Account (proMidCategory, proName, proPrice, proImage) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getProMidCategory(), product.getProName(), product.getProPrice(),
				product.getProImage());
	}

	// 모든 상품 조회
	public List<Product> getProductsAll() {
		String sql = "SELECT * FROM Product";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	}

	// 상품 이름으로 상품 조회
	public Product getProductByName(String proName) {
		String sql = "SELECT * FROM Product WHERE proName = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), proName);
	}

	// 큰 카테고리로 상품 조회
	public List<Product> getProductsByBigCategory(ProductDao dao, String bigName) {
		String sql = "SELECT * FROM Product a INNER JOIN MidCategory b INNER JOIN BigCategory c ON a.proMidCategory = b.mid AND b.midBigCategory = c.bid WHERE c.bigName = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), bigName);
	}

	// 작은 카테고리로 상품 조회
	public List<Product> getProductsByMidCategory(ProductDao dao, String midName) {
		String sql = "SELECT * FROM Product a INNER JOIN MidCategory b ON a.proBigCategory = b.bid WHERE b.MidName = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), midName);
	}
}