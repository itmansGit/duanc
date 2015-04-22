package com.duanc.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>用户详情表</p> 
 * <p>class type : javabean</p>
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 *
 * @author duanchao
 */
public class UserData implements Serializable{

	private static final long serialVersionUID = -7914804502671058537L;
	
	private Integer id;
	private Integer userId;
	private String nickname;
	private Integer sex;
	private Integer age;
	private String headUrl;
	private Date brithday;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
