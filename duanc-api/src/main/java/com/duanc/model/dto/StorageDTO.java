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
	private Integer count;
	private BigDecimal price;
	private Integer status;
	private String statusName;
	private Date createdTime;
	
	private PhoneDTO phone;
	private User createUser;
	
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
