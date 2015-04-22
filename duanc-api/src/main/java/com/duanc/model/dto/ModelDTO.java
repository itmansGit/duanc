package com.duanc.model.dto;

import java.io.Serializable;

import com.duanc.utils.Pagination;

public class ModelDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**机型编号**/
	private Integer id;
	/**机型名称**/
	private String modelName;
	
	/**品牌名称**/
	private String brandName;
	
	/**品牌编号*/
	private Integer brandId;
	
	private Pagination pagination;
	
	public ModelDTO() {
		super();
	}
	public ModelDTO(Integer id, String modelName, String brandName) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.brandName = brandName;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
	
}
