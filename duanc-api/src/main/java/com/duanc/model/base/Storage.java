package com.duanc.model.base;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <p>库存表</p> 
 * <p>class type : javabean </p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 * 
 * @author duanchao
 */
public class Storage implements Serializable{

	private static final long serialVersionUID = -1830578604645708767L;
	
	private Integer id;
	private String storageId;
	private Integer phoneId;
	private Integer count;
	private BigDecimal price;
	private Integer status;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public Integer getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
