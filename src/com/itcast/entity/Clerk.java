package com.itcast.entity;

public class Clerk {

	private Integer cid;
	private String cname;
	private String cpassword;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Clerk [cid=" + cid + ", cname=" + cname + ", cpassword=" + cpassword + "]";
	}
	
	
}
