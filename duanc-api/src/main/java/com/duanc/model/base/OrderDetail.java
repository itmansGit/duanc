package com.duanc.model.base;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>订单详细表 </p> 
 * <p>class type : javabean </p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre>
 * 
 * @author duanchao
 */
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = -3441577552009223346L;
	
	private Integer id;
	private String orderId;
	private Integer phoneId;
	private Integer number;
	private BigDecimal price;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
