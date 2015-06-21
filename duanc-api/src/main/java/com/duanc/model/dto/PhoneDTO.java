package com.duanc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.duanc.utils.Pagination;

@Component("phoneDTO")
public class PhoneDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**手机编号*/
	private Integer id;
	
	private Integer brandId;
	/**品牌名称**/
	private String brandName;
	
	private Integer modelId;
	/**机型名称**/
	private String modelName;
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
	private BigDecimal cpuhz;
	/**上市日期**/
	private Date listingDate;
	/**主屏尺寸**/
	private Double screenSize;
	private BigDecimal screensize;
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
	private Short battery;
	/**展示图片路径**/
	private String picUrl;
	
	private Pagination pagination;
	
	public BigDecimal getCpuhz() {
		return cpuhz;
	}
	public void setCpuhz(BigDecimal cpuhz) {
		this.cpuhz = cpuhz;
	}
	public BigDecimal getScreensize() {
		return screensize;
	}
	public void setScreensize(BigDecimal screensize) {
		this.screensize = screensize;
	}
	public Short getBattery() {
		return battery;
	}
	public void setBattery(Short battery) {
		this.battery = battery;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
}
