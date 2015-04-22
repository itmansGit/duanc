package com.duanc.model.base;

import java.io.Serializable;

/**
 * <p>购物车表</p> 
 * <p>class type :  javabean</p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 * 
 * @author duanchao
 */
public class Cart implements Serializable{

	private static final long serialVersionUID = 8343451688208069276L;
	
	private Integer id;
	private Integer userId;
	private String carts;
	private CreatedAndModify cam;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCarts() {
		return carts;
	}
	public void setCarts(String carts) {
		this.carts = carts;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
}
