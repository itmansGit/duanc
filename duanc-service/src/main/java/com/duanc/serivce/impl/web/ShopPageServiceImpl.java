package com.duanc.serivce.impl.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.ShopPageService;
import com.duanc.inner.common.BasePhoneToDTO;
import com.duanc.mapper.base.BrandMapper;
import com.duanc.mapper.base.ModelMapper;
import com.duanc.mapper.base.PhoneMapper;
import com.duanc.model.base.BaseModel;
import com.duanc.model.base.BaseModelExample;
import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BasePhoneExample;
import com.duanc.model.base.BasePhoneExample.Criteria;
import com.duanc.model.dto.PhoneDTO;

@Service("shopPageService")
public class ShopPageServiceImpl implements ShopPageService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PhoneMapper phoneMapper;
	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public List<BaseModel> getModels() {
		BaseModelExample example = new BaseModelExample();
		return modelMapper.selectByExample(example);
	}

	@Override
	public List<PhoneDTO> getPhones(Integer modelId, BigDecimal minPrice, BigDecimal maxPrice) {
		BasePhoneExample example = new BasePhoneExample();
		Criteria c = example.createCriteria();
		if(modelId != null) {
			c.andModelIdEqualTo(modelId);
		}
		if(minPrice != null && maxPrice != null) {
			c.andPriceBetween(minPrice, maxPrice);
		} else if(maxPrice != null && minPrice == null) {
			c.andPriceLessThan(maxPrice);
			/*c.andPriceBetween(new BigDecimal(0), maxPrice);*/
		} else if(minPrice != null && maxPrice == null) {
			c.andPriceGreaterThan(minPrice);
			/*c.andPriceBetween(minPrice, new BigDecimal(100000000));*/
		}
		List<BasePhone> list = phoneMapper.selectByExample(example);
		List<PhoneDTO> phones = new ArrayList<PhoneDTO>();
		for (BasePhone basePhone : list) {
			PhoneDTO phoneDTO = new BasePhoneToDTO().getPhoneDTO(basePhone,modelMapper,brandMapper);
			phones.add(phoneDTO);
		}
		return phones;
	}

}
