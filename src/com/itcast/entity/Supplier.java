package com.itcast.entity;

import java.util.HashSet;
import java.util.Set;

public class Supplier {
	
	private Integer sid;
	private String sname;
	private String sadress;
	
	private Set<Good> suppliergoods = new HashSet<Good>();
	
	/**
	 * 商品set
	 * @return
	 */
	public Set<Good> getSuppliergoods() {
		return suppliergoods;
	}
	public void setSuppliergoods(Set<Good> suppliergoods) {
		this.suppliergoods = suppliergoods;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", sname=" + sname + ", sadress=" + sadress + "]";
	}
	
	
	
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadress() {
		return sadress;
	}
	public void setSadress(String sadress) {
		this.sadress = sadress;
	}
	
	
	
	
	
}
