package com.duanc.model.dto;

import java.io.Serializable;

import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;

public class OrderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BaseOrder baseOrder;
	
	private BaseUser baseUser;
	
	private BaseUserAddress baseUserAddress;
	
	private BaseOrderDetail baseOrderDetail;
	
	private BasePhone basePhone;
	
	private String status;
	
	private String brandName;
	
	private String modelName;
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BasePhone getBasePhone() {
		return basePhone;
	}

	public void setBasePhone(BasePhone basePhone) {
		this.basePhone = basePhone;
	}

	public BaseOrderDetail getBaseOrderDetail() {
		return baseOrderDetail;
	}

	public void setBaseOrderDetail(BaseOrderDetail baseOrderDetail) {
		this.baseOrderDetail = baseOrderDetail;
	}

	public BaseOrder getBaseOrder() {
		return baseOrder;
	}

	public void setBaseOrder(BaseOrder baseOrder) {
		this.baseOrder = baseOrder;
	}

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}

	public BaseUserAddress getBaseUserAddress() {
		return baseUserAddress;
	}

	public void setBaseUserAddress(BaseUserAddress baseUserAddress) {
		this.baseUserAddress = baseUserAddress;
	}
}
