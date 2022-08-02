package com.varxyz.javacafe.category.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.category.domain.BigCategory;
import com.varxyz.javacafe.category.domain.MidCategory;

public class CategoryDao {
	private JdbcTemplate jdbcTemplate;

	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 큰 카테고리 생성
	public void addBigCategory(BigCategory bigCategory) {
		String sql = "INSERT INTO BigCategory bigName VALUES ?";
		jdbcTemplate.update(sql, bigCategory.getBigName());
	}

	// 큰 카테고리 조회
	public List<BigCategory> getBigCategoryAll() {
		String sql = "SELECT * FROM BigCategory";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<BigCategory>(BigCategory.class));
	}

	// 작은 카테고리 생성
	public void addMidCategory(MidCategory midCategory) {
		String sql = "INSERT INTO MidCategory (midBigCategory, midName) VALUES (?, ?)";
		jdbcTemplate.update(sql, midCategory.getMidBigCategory(), midCategory.getMidName());
	}

	// 작은 카테고리 조회
	public List<MidCategory> getMidCategoryAll() {
		String sql = "SELECT * FROM MidCategory";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MidCategory>(MidCategory.class));
	}
}