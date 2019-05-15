package com.itcast.entity;


public class Good {
	private Integer gid;//药品编号
	private String gname;//药品名称
	
	private Supplier sid;//药品供应商id
	private Integer stockid;//库存表id
	private Double price;//售价
	private Double purchasePrice;//进货价
	private String date;//生产日期
	private Integer qualitaDate;//保质期
	private String purchaseNum;//进货编号
	
	
	private Type type;//类别id
	private String overTime;//距离过期时间
	/*
	 * private Repertory repertory;
	 * 
	 * 
	 * //配置与仓库的一对多关系 //private Repertory repertory=new Repertory();
	 * 
	 * 
	 * public Repertory getRepertory() { return repertory; }
	 * 
	 * public void setRepertory(Repertory repertory) { this.repertory = repertory; }
	 */

	


	@Override
	public String toString() {
		return "Good [gid=" + gid + ", gname=" + gname + ", sid=" + sid + ", stockid=" + stockid + ", price=" + price
				+ ", purchasePrice=" + purchasePrice + ", date=" + date + ", qualitaDate=" + qualitaDate
				+ ", purchaseNum=" + purchaseNum + ", type=" + type + ", overTime=" + overTime + "]";
	}
	
	/**
	 * 供应商
	 * @return
	 */
	public Supplier getSid() {
		return sid;
	}
	public void setSid(Supplier sid) {
		this.sid = sid;
	}
	
	/**
	 * 类型
	 * @return
	 */
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getStockid() {
		return stockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getQualitaDate() {
		return qualitaDate;
	}
	public void setQualitaDate(Integer qualitaDate) {
		this.qualitaDate = qualitaDate;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
