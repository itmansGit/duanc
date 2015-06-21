package com.duanc.inner.common;

public class OrderStatusMatch {

	public String getOrderStatus(byte status){
		if(status == 0) {
			return "待付款";
		} else if(status == 1) {
			return "待发货";
		} else if(status == 2) {
			return "已发货";
		} else if(status == 3) {
			return "已到货";
		} else if(status == 4) {
			return "已签收";
		} else if(status == 5) {
			return "已确认收货";
		} else if(status == 6) {
			return "待退货审核";
		} else if(status == 7) {
			return "退货审核通过";
		} else if(status == 8) {
			return "已退货";
		} else {
			return null;
		}
	}
}
