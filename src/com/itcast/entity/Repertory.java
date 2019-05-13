package com.itcast.entity;

import java.util.HashSet;
import java.util.Set;

public class Repertory {
     private Integer rid; //入库编号
     private String rdate; //入库时间
     private String rtotal; //入库总数 
    private  String  runit;//单位
    private  String  rname;//操作员
    private String rtext;//备注
     //  商品编号 ，商品名称    供应商
     //配置一对多
    private Set<Good> good=new HashSet<Good>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
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
	public Set<Good> getGood() {
		return good;
	}
	public void setGood(Set<Good> good) {
		this.good = good;
	}
    
     
     
	
     
     
}
