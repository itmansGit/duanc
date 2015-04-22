package com.duanc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.duanc.model.User;
import com.duanc.utils.Pagination;

/**
 * @Description: 库存
 * @author duanchao 
 */
@Component("storageDTO")
public class StorageDTO implements Serializable{
	private static final long serialVersionUID = 7768626286667545489L;
	
	private Integer id;
	private String storageId;
	private Integer phoneId;
	private String phoneName;
	private Integer count;
	private BigDecimal price;
	private Integer status;
	private String statusName;
	private Date createdTime;
	
	private PhoneDTO phone;
	private User createUser;
	
	private Integer brandId;
	private String brandName;
	private Integer modelId;
	private String modelName;
	private String phoneUrl;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private Pagination pagination;
	
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
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
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
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
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
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
	public String getPhoneUrl() {
		return phoneUrl;
	}
	public void setPhoneUrl(String phoneUrl) {
		this.phoneUrl = phoneUrl;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public PhoneDTO getPhone() {
		return phone;
	}
	public void setPhone(PhoneDTO phone) {
		this.phone = phone;
	}
	
}
