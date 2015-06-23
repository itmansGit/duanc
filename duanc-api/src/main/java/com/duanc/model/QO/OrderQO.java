package com.duanc.model.QO;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("orderQO")
public class OrderQO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderId;
	
	private Integer userId;
	
	private Byte status;
	
	private Integer phoneId;
	
	private Integer brandId;
	
	private Integer modelId;
	
	private String username;
	
	private String statusStr;
	
	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public boolean isEmpty(){
		if(this.orderId != null && !"".equals(this.orderId)){
			return false;
		} else if(this.brandId != null ) {
			return false;
		} else if(this.modelId != null ) {
			return false;
		} else if(this.username != null && !"".equals(this.username)) {
			return false;
		} else if(this.status != null) {
			return false;
		}
		return true;
	}
}
