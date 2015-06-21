<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" id="sidebar">					
	<ul class="nav nav-list">
		<li>
			<a href="#">
				<i class="icon-dashboard"></i>
				<span class="menu-text"> 主页 </span>
			</a>
		</li>						
		
		<c:forEach var="menu" items="${menus }">
			<li class="${menu.css }">
				<a href="#" class="dropdown-toggle">
					<i class="${menu.icon }"></i>
					<span class="menu-text">${menu.name }</span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">	
					<c:forEach var="subMenu" items="${menu.subMenus }">
						<li class="${subMenu.css }">
							<a href="${ctx }${subMenu.url }?menuId=${menu.id}&subMenuId=${subMenu.id}">
								<i class="icon-double-angle-right"></i>
								${subMenu.name }
							</a>
						</li>
					</c:forEach>															
				</ul>
			</li>
		</c:forEach>
	</ul>
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>					
</div>