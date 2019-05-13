package com.itcast.entity;

public class ShopItem {

	private Integer count;//购买商品的数量
	private Double subtotal;//购买商品的小计
	private Good good; //购物项的商品信息
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	

	/**
	 * 小计自动计算
	 * @return
	 */
	public Double getSubtotal() {
		return count*good.getPrice();
	}
	
	public void setGood(Good good) {
		this.good = good;
	}
	public Good getGood() {
		return good;
	}
	@Override
	public String toString() {
		return "ShopItem [count=" + count + ", subtotal=" + subtotal + ", good=" + good + "]";
	}
	
	
	
}
