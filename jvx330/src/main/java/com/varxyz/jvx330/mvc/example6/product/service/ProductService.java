package com.varxyz.jvx330.mvc.example6.product.service;

import java.util.List;

import com.varxyz.jvx330.mvc.example6.product.domain.Product;
import com.varxyz.jvx330.mvc.example6.product.repository.ProductDao;

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
