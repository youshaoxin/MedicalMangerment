package com.itcast.entity;

public class OutRepertory {
	private Integer outid; // 上架编号
	private String outnumber;// 上架订单编号
	private String outname;// 上架产品
	private String outdate; // 上架时间
	private String outprice;// 上架单价
	private String outfactory;//厂家
	private String outtext;// 备注 备用
	private String outbrithdate; // 生产日期
	private String outnum;// 上架数量

	//还需要做一个下架
	
	
	@Override
	public String toString() {
		return "OutRepertory [outid=" + outid + ", outnumber=" + outnumber + ", outname=" + outname + ", outdate="
				+ outdate + ", outprice=" + outprice + ", outfactory=" + outfactory + ", outtext=" + outtext
				+ ", outbrithdate=" + outbrithdate + ", outnum=" + outnum + "]";
	}
	public Integer getOutid() {
		return outid;
	}
	public void setOutid(Integer outid) {
		this.outid = outid;
	}
	public String getOutnumber() {
		return outnumber;
	}
	public void setOutnumber(String outnumber) {
		this.outnumber = outnumber;
	}
	public String getOutname() {
		return outname;
	}
	public void setOutname(String outname) {
		this.outname = outname;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getOutprice() {
		return outprice;
	}
	public void setOutprice(String outprice) {
		this.outprice = outprice;
	}
	public String getOutfactory() {
		return outfactory;
	}
	public void setOutfactory(String outfactory) {
		this.outfactory = outfactory;
	}
	public String getOuttext() {
		return outtext;
	}
	public void setOuttext(String outtext) {
		this.outtext = outtext;
	}
	public String getOutbrithdate() {
		return outbrithdate;
	}
	public void setOutbrithdate(String outbrithdate) {
		this.outbrithdate = outbrithdate;
	}
	public String getOutnum() {
		return outnum;
	}
	public void setOutnum(String outnum) {
		this.outnum = outnum;
	}
	
	
	
	
	
	
}
