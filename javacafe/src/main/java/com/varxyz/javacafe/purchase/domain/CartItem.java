package com.varxyz.javacafe.purchase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CartItem {

	private int count; // 상품 개수

	public static CartItem createCartItem(Cart cart, Item item, int amount) {
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setItem(item);
		cartItem.setCount(amount);
		return cartItem;
	}

	// 이미 담겨있는 물건 또 담을 경우 수량 증가
	public void addCount(int count) {
		this.count += count;
	}
}
