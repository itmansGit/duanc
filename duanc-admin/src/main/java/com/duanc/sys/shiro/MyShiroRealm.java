package com.duanc.sys.shiro;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.duanc.api.UserService;
import com.duanc.model.User;


public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.     【权限认证】 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalC) {
		/* 这里编写授权代码 */
		User user = new User();
		String loginName = (String) principalC.fromRealm(getName()).iterator().next(); 
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>loginName:" + loginName);
		user.setUsername(loginName);
		Set<String> roleNames = userService.getRolesByUser(user);
		Set<String> permissions = userService.getPremissionsByUser(user);
		permissions.remove(null);
		permissions.remove("");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
		info.setRoles(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}
	
	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authT) throws AuthenticationException {
		logger.info("【******登录验证*****】");
		UsernamePasswordToken token = (UsernamePasswordToken) authT;
		logger.info("              >>>" + token.getUsername());
		//第一次查询，设为用户名
		User user = new User();
		user.setUsername(token.getUsername());
		user = userService.findUser(user);
		//没有此用户，第二次查询，设为email
		/*if(user.getId() == null) {
			user.setEmail(token.getUsername());
			user.setUsername(null);
			user = userService.findUser(user);
		}
		//没有此用户，第三次查询，设为phoneNo
		if(user.getId() == null) {
			user.setPhoneNo(token.getUsername());
			user.setUsername(null);
			user = userService.findUser(user);
		}
		if(user.getId() == null) {
			return null;
		}*/
		Subject currentUser = SecurityUtils. getSubject();
		currentUser.getSession().setAttribute("user", user);
	    return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName()); 
	}
	
	/**=================================================================================================**/
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
