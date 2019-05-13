 package com.itcast.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 药品类别实体类
 * @author 50339
 *
 */
public class Type {
	private Integer tid;
	private String tname;
	
	//配置一对多关系
	private Set<Good> setgoods = new HashSet<Good>();
	
	/**
	 * 商品set
	 * @return
	 */
	public Set<Good> getSetgoods() {
		return setgoods;
	}
	public void setSetgoods(Set<Good> setgoods) {
		this.setgoods = setgoods;
	}
	
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
	
	
}
