package com.duanc.api.web;

import java.math.BigDecimal;
import java.util.List;

import com.duanc.model.base.BaseModel;
import com.duanc.model.dto.PhoneDTO;

/**
 * <p>shop商城页面服务 </p> 
 * <p>接口</p>
 * 
 * <pre>Description: </pre> 
 *
 * @author duanchao
 */
public interface ShopPageService {
	
	List<BaseModel> getModels();
	
	List<PhoneDTO> getPhones(Integer modelId, BigDecimal minPrice, BigDecimal maxPrice);
}
