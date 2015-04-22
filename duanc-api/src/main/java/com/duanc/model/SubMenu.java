package com.duanc.model;

import java.io.Serializable;

public class SubMenu implements Serializable{

	private static final long serialVersionUID = 4487565770404559470L;
	
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 子菜单名称
	 */
	private String name;
	/**
	 * 路径
	 */
	private String url;
	/**
	 * 父级编号
	 */
	private Integer parentId;
	/**
	 * 子菜单的
	 */
	private Integer type;
	
	private String css;
	
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
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
	public String getUrl() {
		return url;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
