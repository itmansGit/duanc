package com.duanc.model.mybase;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * <p>创建及删除相应字段</p>
 * <p>class type : javabean<p> 
 * <pre>
 * 包含字段:
 * ==变量=========字段=========定义====
 * createdTime  created_time  创建时间
 * createdUser  created_user  创建人  
 * modifyTime   modify_time   修改时间 
 * modifyUser   modify_user   修改人
 * </pre>
 * @author duanchao
 */
public class CreatedAndModify implements Serializable{
	
	private static final long serialVersionUID = 6173366557221806977L;
	
	private Date createdTime;
	private Integer createdUser;
	private Date modifyTime;
	private Integer modifyUser;
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(Integer createdUser) {
		this.createdUser = createdUser;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(Integer modifyUser) {
		this.modifyUser = modifyUser;
	}
}
