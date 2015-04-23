package com.duanc.model.mybase;

import java.io.Serializable;

/**
 * <p>手机品牌表 <p>
 * <p>class type : javabean<p> 
 * <pre>含成员类:CreatedAndModify cam</pre>
 * @author duanchao
 */
public class Brand implements Serializable {
	
	private static final long serialVersionUID = -6918956382686326759L;
	
	private Integer id;
	private String brandName;
	private CreatedAndModify cam;
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
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
}
