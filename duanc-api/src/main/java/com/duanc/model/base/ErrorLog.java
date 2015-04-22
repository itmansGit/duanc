package com.duanc.model.base;

import java.io.Serializable;

/**
 * <p>错误日志表</p> 
 * <p>class type :  javabean</p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 * 
 * @author duanchao
 */
public class ErrorLog implements Serializable{

	private static final long serialVersionUID = -3521995096651300499L;
	private Integer id;
	private String className;
	private String methodName;
	private String reason;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
