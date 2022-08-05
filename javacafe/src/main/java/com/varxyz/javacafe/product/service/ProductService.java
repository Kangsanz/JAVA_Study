package com.varxyz.javacafe.product.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.varxyz.javacafe.category.domain.MidCategory;
import com.varxyz.javacafe.product.domain.Product;
import com.varxyz.javacafe.product.repository.ProductDao;

public interface ProductService {
	// 상품 생성
	public void addProduct(ProductDao dao, int proMidCategory, String proName, Long proPrice, String proImage);

	// 모든 상품 조회
	public List<Product> getProductsAll(ProductDao dao);

	// 상품 이름으로 상품 조회
	public Product getProductByName(ProductDao dao, String proName);

	// 큰 카테고리로 상품 조회
	public List<Product> getProductsByBigCategory(ProductDao dao, String bigName);

	// 작은 카테고리로 상품 조회
	public List<Product> getProductsByMidCategory(ProductDao dao, String midName);
}
