package com.itcast.entity;

import java.util.HashSet;
import java.util.Set;


public class User {
	private Integer uid;  			//会员Id
	private String username; 		//会员名称
	private String cardNum;		//会员身份证
	private String phone;			//会员电话
	private String adress;			//会员所在地址
	private String sex;				//会员性别	
	//通过ORM的方式表示：一个会员对应多个订单
	//放置多的一方的集合.Hibernate默认使用的是Set集合
	private Set<Indent> indent=new HashSet<Indent>();
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Set<Indent> getIndent() {
		return indent;
	}
	public void setIndent(Set<Indent> indent) {
		this.indent = indent;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", cardNum=" + cardNum + ", phone=" + phone + ", adress="
				+ adress + ", sex=" + sex + "]";
	}
	
	
	
	
	
	
}
