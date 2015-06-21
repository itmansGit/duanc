package com.duanc.api.web;

import java.util.List;

import com.duanc.model.base.BasePhone;

/**
 * <p>Index首页</p> 
 * <p>interface</p>
 * <pre></pre> 
 * @author duanchao
 */
public interface IndexService {
	
	List<BasePhone> getRotationFigure();       
	
	List<BasePhone> getIntro();
}
