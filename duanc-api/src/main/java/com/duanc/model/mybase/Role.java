package com.duanc.model.mybase;

import java.io.Serializable;

/**
 * <p>角色表</p> 
 * <p>class type : javabeans </p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 * 
 * @author duanchao
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 5449913337140040029L;
	
	private Integer id;
	private String name;
	private CreatedAndModify cam;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
}
