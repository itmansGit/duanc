package com.duanc.api.web;

import java.util.List;

import com.duanc.model.base.BaseCart;

public interface CartService {
	boolean addToCart(BaseCart baseCart);
	
	List<BaseCart> getCarts(int userId);
	
	boolean updataCarts(BaseCart baseCart, int userId);
}
