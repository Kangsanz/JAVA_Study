package com.varxyz.javacafe.product.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.product.domain.Product;
import com.varxyz.javacafe.product.repository.ProductDao;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	public ProductServiceImpl(DataSource datasource) {
		dao = new ProductDao(datasource);
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
		return dao.getProductsByMidCategory(dao, midName);
	}

	public String[] splits(String string) {
		if (string == null || string == "" || string == " ") {
			return null;
		} else {
			return string.replace("[", "").replace("]", "").replace(" ", "").split(",");
		}
	}

	public boolean contain(List<String> cart, String cartName, String carPrice, int cartAmount, String cartNamePrice) {
		for (int i = 0; i < 10; i++) {

			cartNamePrice = cartName + "/" + carPrice + "/" + (cartAmount + i);

			if (cart.contains(cartNamePrice)) {
				return true;
			}
		}
		return false;
	}

	public Object contain2(List<String> cart, String cartName, String carPrice, int cartAmount, String cartNamePrice) {
		for (int i = 0; i < 10; i++) {

			cartNamePrice = cartName + "/" + carPrice + "/" + (cartAmount + i);

			if (cart.contains(cartNamePrice)) {
				return i;
			}
		}
		return 2;
	}

}