package com.duanc.inner.qo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @ClassName: PhoneQO 
 * @Description: 手机查询QO
 * @author duanchao 
 * @date 2015年3月31日 下午5:07:15
 */
@Component("phoneQO")
public class PhoneQO implements Serializable{

	private static final long serialVersionUID = 1429600086003832647L;
	
	private Integer brandId;
	
	private Integer modelId;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
}
