package com.varxyz.javacafe.category.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.category.domain.BigCategory;
import com.varxyz.javacafe.category.domain.MidCategory;
import com.varxyz.javacafe.category.repository.CategoryDao;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	public CategoryServiceImpl(DataSource datasource) {
		dao = new CategoryDao(datasource);
	}

	@Override
	public void addBigCategory(CategoryDao dao, String bigName) {
		BigCategory c = new BigCategory();
		c.setBigName(bigName);

		dao.addBigCategory(c);
		System.out.println("-addBigCategory-");
	}

	@Override
	public List<BigCategory> getBigCategoryAll(CategoryDao dao) {
		System.out.println("-getBigCategoryAll-");
		return dao.getBigCategoryAll();
	}

	@Override
	public void addMidCategory(CategoryDao dao, int midBigCategory, String bigName) {
		BigCategory c = new BigCategory();
		c.setBigName(bigName);

		dao.addBigCategory(c);
		System.out.println("-addMidCategory-");
	}

	@Override
	public List<MidCategory> getMidCategoryAll(CategoryDao dao) {
		System.out.println("-getMidCategoryAll-");
		return dao.getMidCategoryAll();
	}

	@Override
	public MidCategory getMidCategoryByMidName(CategoryDao dao, String midName) {
		System.out.println("-getMidCategoryByMidName-");
		return dao.getMidCategoryByMidName();
	}
}