package com.duanc.model;

import java.io.Serializable;
import java.util.Date;

public class MyBaseUser implements Serializable{
	
	private static final long serialVersionUID = 1946921523286169435L;
	
	/**昵称*/
	private String nickname;
	/**性别*/
	private String sexStr;
	/**性别*/
	private Integer sex;
	/**年龄*/
	private Integer age;
	/**头像地址*/
	private String headUrl;
	/**出生日期*/
	private Date brithday;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getSexStr() {
		return sexStr;
	}
	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
