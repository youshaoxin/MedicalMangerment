package com.itcast.entity;

import java.util.Date;

public class OrderDetial {
	//订单 详情 
	private Integer orderId;//订单主键
	private String ordernumber; //订单编号
	private String orName;//订单药品名称
	private double orUnitPrice; //单价
	private String orValDate;//有效期
	private Date orProductDate;//出厂日期
	private Integer tid; //药品类型id
	private Integer ornum;//数量
	private double orsum;//总价
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getOrName() {
		return orName;
	}
	public void setOrName(String orName) {
		this.orName = orName;
	}
	public double getOrUnitPrice() {
		return orUnitPrice;
	}
	public void setOrUnitPrice(double orUnitPrice) {
		this.orUnitPrice = orUnitPrice;
	}
	public String getOrValDate() {
		return orValDate;
	}
	public void setOrValDate(String orValDate) {
		this.orValDate = orValDate;
	}
	public Date getOrProductDate() {
		return orProductDate;
	}
	public void setOrProductDate(Date orProductDate) {
		this.orProductDate = orProductDate;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "OrderDetial [orderId=" + orderId + ", ordernumber=" + ordernumber + ", orName=" + orName
				+ ", orUnitPrice=" + orUnitPrice + ", orValDate=" + orValDate + ", orProductDate=" + orProductDate
				+ ", tid=" + tid + "]";
	}
	public Integer getOrnum() {
		return ornum;
	}
	public void setOrnum(Integer ornum) {
		this.ornum = ornum;
	}
	public double getOrsum() {
		return orsum;
	}
	public void setOrsum(double orsum) {
		this.orsum = orsum;
	}


}
