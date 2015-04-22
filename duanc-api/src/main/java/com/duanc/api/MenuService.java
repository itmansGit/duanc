package com.duanc.api;

import java.util.List;

import com.duanc.model.Menu;
import com.duanc.model.SubMenu;

public interface MenuService {
	/**
	 * @Description: 获取系统菜单 
	 * @return List<Menu>
	 */
	List<Menu> getMenu(Integer userId, Integer menuId, Integer subMenuId);
	
	/**
	 * @Description: 获取子菜单 
	 * @return List<SubMenu>
	 */
	List<SubMenu> getSubMenu(Menu menu);
}
