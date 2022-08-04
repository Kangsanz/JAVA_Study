package com.varxyz.javacafe.purchase.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.javacafe.product.domain.Product;
import com.varxyz.javacafe.purchase.domain.Cart;
import com.varxyz.javacafe.purchase.domain.CartItem;
import com.varxyz.javacafe.purchase.domain.Item;
import com.varxyz.javacafe.purchase.repository.PurchaseDao;

public class PurchaseServiceImpl {
	@Autowired
	private PurchaseDao dao;

	// @Transactional
	public void addCart(List<String> cart, List<CartItem> cartItems, Item item, String productName, int amount) {

		List<CartItem> cartItemList = dao.findAllCartItems(cart);

		// 장바구니가 비었으면 장바구니 생성
		if (cartItemList == null) {
			Cart.createCart();
		}

		Boolean boolbeanCartItem = dao.booleanCartItemByProductName(cartItems, productName);

		// 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가
		if (boolbeanCartItem == false) {
			CartItem.createCartItem(cart, item, amount);
	        dao.saveItem(cart, cartItems);
		}

		// 상품이 장바구니에 이미 존재한다면 수량만 증가
		else {
	        CartItem update = cartItems;
	        update.setCart(cartItems.getCart());
	        update.addCount(amount);
	        update.setCount(cartItems.getCount());
	        dao.removeItem(cart, cartItems);
	        dao.saveItem(cart, update);
		}

		// 카트 상품 총 개수 증가
		cart.setCount(cart.getCount() + amount);
	}
}
