package com.varxyz.jvx330.mvc.example6.category.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.jvx330.mvc.example6.category.domain.BigCategory;
import com.varxyz.jvx330.mvc.example6.category.domain.MidCategory;
import com.varxyz.jvx330.mvc.example6.category.repository.CategoryDao;
import com.varxyz.jvx330.mvc.example6.product.domain.Product;
import com.varxyz.jvx330.mvc.example6.product.repository.ProductDao;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	public CategoryServiceImpl(DataSource datasource) {
		dao = new CategoryDao(datasource);
	}

	@Override
	public void addProduct(ProductDao dao, int proMidCategory, String proName, Long proPrice, String proImage) {
		Product c = new Product();
		c.setProMidCategory(proMidCategory);
		c.setProName(proName);
		c.setProPrice(proPrice);
		c.setProImage(proImage);

		dao.addProduct(c);
		System.out.println("-상품 입력 완료-");
	}

	@Override
	public List<Product> getProductsAll(ProductDao dao) {
		System.out.println("-getProductsAll-");
		return dao.getProductsAll();
	}

	@Override
	public Product getProductByName(ProductDao dao, String proName) {
		System.out.println("-getProductByName-");
		return dao.getProductByName(proName);
	}

	@Override
	public List<Product> getProductsByBigCategory(ProductDao dao, String bigName) {
		System.out.println("-getProductsByBigCategory-");
		return dao.getProductsByBigCategory(dao, bigName);
	}

	@Override
	public List<Product> getProductsByMidCategory(ProductDao dao, String midName) {
		System.out.println("-getProductsByBigCategory-");
		return dao.getProductsByBigCategory(dao, midName);
	}

	@Override
	public void addBigCategory(CategoryDao dao, String bigName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BigCategory> getBigCategoryAll(CategoryDao dao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMidCategory(CategoryDao dao, int midBigCategory, String bigName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MidCategory> getMidCategoryAll(CategoryDao dao) {
		// TODO Auto-generated method stub
		return null;
	}
}