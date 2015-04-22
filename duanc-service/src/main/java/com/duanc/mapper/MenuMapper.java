package com.duanc.mapper;

import java.util.List;

import com.duanc.model.Menu;
import com.duanc.model.SubMenu;

public interface MenuMapper {
	
	/**
	 * @Description: 获取系统菜单 
	 * @return List<Menu>
	 */
	List<Menu> getMenus(Menu menu);
	
	/**
	 * @Description: 获取系统子菜单 
	 * @return List<SubMenu>
	 */
	List<SubMenu> getSubMenus(SubMenu subMenu);
}
