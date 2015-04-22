package com.duanc.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{

	private static final long serialVersionUID = 2907775961740561402L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 菜单-状态码-0
	 */
	private Integer type;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 子菜单列表
	 */
	private List<SubMenu> subMenus;
	/**
	 * 所属用户编号
	 */
	private Integer userId;
	
	private String css;
	
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}
}
