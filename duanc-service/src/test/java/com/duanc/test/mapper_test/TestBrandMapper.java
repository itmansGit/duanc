package com.duanc.test.mapper_test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.duanc.mapper.base.BrandMapper;
import com.duanc.model.base.BaseBrand;
import com.duanc.model.base.BaseBrandExample;
import com.duanc.test.BaseSpringTest;

public class TestBrandMapper extends BaseSpringTest{
	@Autowired
	private BrandMapper brandMapper;
	
	@Test
	public void test(){
		BaseBrand record = new BaseBrand();
		record.setBrandName("iPhone");
		record.setCreatedTime(new Date());
		record.setCreatedUser(1);
		record.setDelFlag(false);
		/*int i = brandMapper.insert(record);
		System.out.println(i > 0 ? true : false );*/
		
		record.setId(2);
		/*brandMapper.updateByPrimaryKey(record);*/
		
		BaseBrandExample example = new BaseBrandExample();
		BaseBrandExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(1);
		List<BaseBrand> list = brandMapper.selectByExample(example);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list.get(0).getBrandName());
	}
}
