package com.itcast.entity;

public class IndentDetail {

	private Integer did;
	private String indentid;
	private Integer gid;
	private String gname;
	private Integer count;
	private Double price;
	private Double subtotal;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	
	
	public String getIndentid() {
		return indentid;
	}
	public void setIndentid(String indentid) {
		this.indentid = indentid;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "IndentDetail [did=" + did + ", indentid=" + indentid + ", gid=" + gid + ", gname=" + gname + ", count="
				+ count + ", price=" + price + ", subtotal=" + subtotal + "]";
	}
	
	
}
