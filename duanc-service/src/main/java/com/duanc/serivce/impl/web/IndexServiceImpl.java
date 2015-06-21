package com.duanc.serivce.impl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.IndexService;
import com.duanc.mapper.base.PhoneMapper;
import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BasePhoneExample;

@Service("indexService")
public class IndexServiceImpl implements IndexService{
	
	@Autowired
	private PhoneMapper phoneMapper;
	
	@Override
	public List<BasePhone> getRotationFigure() {
		BasePhoneExample example = new BasePhoneExample();
		List<BasePhone> list =  phoneMapper.selectByExample(example);
		return list.subList(0, 4);
	}

	@Override
	public List<BasePhone> getIntro() {
		
		return null;
	}
	
}
