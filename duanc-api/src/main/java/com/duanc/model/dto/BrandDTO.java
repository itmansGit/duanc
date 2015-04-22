package com.duanc.model.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("brandDTO")
public class BrandDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**品牌编号**/
	private Integer id;
	/**品牌名称**/
	private String brandName;
	
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
	
}
