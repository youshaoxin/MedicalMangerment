package com.itcast.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Repertory {
     private Integer rid; //入库编号
     private String rnumber;//入库订单编号
     private String rproduct;//入库产品
     private String rdate; //入库时间
     private String rtotal; //入库总数 
    private  String  runit;//单价
    private  String  rname;//操作员
    private String rtext;//备注 
    private  String rbrithdate;  //生产日期
    private String rput;//供应商

	//  商品编号 ，商品名称    供应商
     //配置一对多
	/*
	 * private Set<Good> good = new HashSet<Good>(); public Set<Good> getGood() {
	 * return good; } public void setGood(Set<Good> good) { this.good = good; }
	 */
    
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	
	

	

	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Repertory [rid=" + rid + ", rnumber=" + rnumber + ", rproduct=" + rproduct + ", rdate=" + rdate
				+ ", rtotal=" + rtotal + ", runit=" + runit + ", rname=" + rname + ", rtext=" + rtext + ", rbrithdate="
				+ rbrithdate + ", rput=" + rput +  "]";
	}
	public String getRbrithdate() {
		return rbrithdate;
	}
	public void setRbrithdate(String rbrithdate) {
		this.rbrithdate = rbrithdate;
	}
	public String getRput() {
		return rput;
	}
	public void setRput(String rput) {
		this.rput = rput;
	}
	public String getRnumber() {
		return rnumber;
	}
	public void setRnumber(String rnumber) {
		this.rnumber = rnumber;
	}
	public String getRproduct() {
		return rproduct;
	}
	public void setRproduct(String rproduct) {
		this.rproduct = rproduct;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRtotal() {
		return rtotal;
	}
	public void setRtotal(String rtotal) {
		this.rtotal = rtotal;
	}
	public String getRunit() {
		return runit;
	}
	public void setRunit(String runit) {
		this.runit = runit;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	
    
     
     
	
     
     
}
