package com.duanc.model.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = -4977148281400971427L;
	
	private Integer id;
	
	private String username;
	
	private String nickname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
