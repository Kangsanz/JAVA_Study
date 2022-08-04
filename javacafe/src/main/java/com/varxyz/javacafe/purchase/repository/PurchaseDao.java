package com.varxyz.javacafe.purchase.repository;

import java.util.List;

import com.varxyz.javacafe.purchase.domain.Cart;
import com.varxyz.javacafe.purchase.domain.CartItem;

public class PurchaseDao {
	public void saveItem(CartItem cartItem) {
		cart.getCartItems().add(cartItem);
	}

	public void removeItem(CartItem cartItem) {
		cart.getCartItems().remove(cartItem);
	}

	public Cart findItemByProductName(Cart cart, String productName) {
		return null;
	}

	public List<CartItem> findAllCartItems(Cart cart) {
		List<CartItem> cartList = cart.getCartItems();
		return cartList;
	}

	public Boolean booleanCartItemByProductName(CartItem cartItem, String productName) {
		if (cartItem.getItem().getProName().contains(productName)) {
			return false;
		} else {
			return true;
		}
	}
}
