package com.duanc.serivce.impl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.CartService;
import com.duanc.mapper.base.CartMapper;
import com.duanc.model.base.BaseCart;
import com.duanc.model.base.BaseCartExample;
import com.duanc.model.base.BaseCartExample.Criteria;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public boolean addToCart(BaseCart baseCart) {
		if(cartMapper.insert(baseCart) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<BaseCart> getCarts(int userId) {
		BaseCartExample example = new BaseCartExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		List<BaseCart> list = cartMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean updataCarts(BaseCart baseCart,int userId) {
		BaseCartExample example = new BaseCartExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		if(cartMapper.updateByExample(baseCart, example) > 0) {
			return true;
		}
		return false;
	}

}
