package com.duanc.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>手机详情表 </p> 
 * 
 * <p>class type : javabean</p> 
 * 
 * <pre>含成员类:CreatedAndModify cam</pre>
 * 
 * @author duanchao
 */
public class Phone implements Serializable{

	private static final long serialVersionUID = -334297480471644670L;
	
	/**手机编号*/
	private Integer id;
	/**品牌编号*/
	private Integer brandId;
	/**机型编号*/
	private Integer modelId;
	/**手机版本**/
	private String version;
	/**价格**/
	private BigDecimal price;
	/**cpu**/
	private String cpu;
	/**cpu核心数**/
	private String cpuCores;
	/**cpu频率**/
	private Double cpuHz;
	/**上市日期**/
	private Date listingDate;
	/**主屏尺寸**/
	private Double screenSize;
	/**网络类型**/
	private String netType;
	/**操作系统**/
	private String os;
	/**运行内存**/
	private String ram;
	/**手机内存**/
	private String rom;
	/**电池容量**/
	private Integer batteryCapacity;
	/**展示图片路径**/
	private String picUrl;
	
	private CreatedAndModify cam;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCpuCores() {
		return cpuCores;
	}

	public void setCpuCores(String cpuCores) {
		this.cpuCores = cpuCores;
	}

	public Double getCpuHz() {
		return cpuHz;
	}

	public void setCpuHz(Double cpuHz) {
		this.cpuHz = cpuHz;
	}

	public Date getListingDate() {
		return listingDate;
	}

	public void setListingDate(Date listingDate) {
		this.listingDate = listingDate;
	}

	public Double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Double screenSize) {
		this.screenSize = screenSize;
	}

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public Integer getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(Integer batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public CreatedAndModify getCam() {
		return cam;
	}

	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
