package com.duanc.model.mybase;

import java.io.Serializable;

/**
 * <p>机型表<p> 
 * <p>class type : javabean<p> 
 * <pre>含成员类:CreatedAndModify cam</pre>
 * @author duanchao
 */
public class Model implements Serializable{

	private static final long serialVersionUID = 7503711234462463031L;
	
	private Integer id;
	private String modelName;
	
	private Brand brand;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
}
