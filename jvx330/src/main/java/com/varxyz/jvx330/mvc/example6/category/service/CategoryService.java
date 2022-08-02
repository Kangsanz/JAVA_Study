package com.varxyz.jvx330.mvc.example6.category.service;

import java.util.List;

import com.varxyz.jvx330.mvc.example6.category.domain.BigCategory;
import com.varxyz.jvx330.mvc.example6.category.domain.MidCategory;
import com.varxyz.jvx330.mvc.example6.category.repository.CategoryDao;

public interface CategoryService {
	// 큰 카테고리 생성
	public void addBigCategory(CategoryDao dao, String bigName);

	// 큰 카테고리 조회
	public List<BigCategory> getBigCategoryAll(CategoryDao dao);

	// 작은 카테고리 생성
	public void addMidCategory(CategoryDao dao, int midBigCategory, String bigName);

	// 큰 카테고리 조회
	public List<MidCategory> getMidCategoryAll(CategoryDao dao);
}
