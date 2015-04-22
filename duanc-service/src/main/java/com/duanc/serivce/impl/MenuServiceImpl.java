package com.duanc.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.MenuService;
import com.duanc.constants.Constants;
import com.duanc.mapper.MenuMapper;
import com.duanc.model.Menu;
import com.duanc.model.SubMenu;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenu(Integer userId, Integer menuId, Integer subMenuId) {
		Menu menu = new Menu();
		menu.setType(Constants.MENU_TYPE);
		menu.setUserId(userId);
		List<Menu> menus = menuMapper.getMenus(menu);
		for (Menu menu2 : menus) {
			if(menuId == menu2.getId()) {
				menu2.setCss(Constants.MENU_ACTIVE_CSS);
			}
			List<SubMenu> subMenus = getSubMenu(menu2);
			for (SubMenu subMenu : subMenus) {
				if(subMenuId == subMenu.getId()) {
					subMenu.setCss(Constants.SUBMENU_ACTIVE_CSS);
				}
			}
			menu2.setSubMenus(subMenus);
		}
		return menus;
	}

	@Override
	public List<SubMenu> getSubMenu(Menu menu) {
		SubMenu subMenu = new SubMenu();
		subMenu.setParentId(menu.getId());
		subMenu.setType(Constants.SUBMENU_TYPE);
		return menuMapper.getSubMenus(subMenu);
	}

}
