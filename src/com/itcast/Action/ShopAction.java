package com.itcast.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Good;
import com.itcast.entity.Shop;
import com.itcast.entity.ShopItem;
import com.itcast.service.GoodService;
import com.itcast.service.ShopService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ShopAction extends ActionSupport implements ModelDriven<ShopItem>{

	private ShopItem shopItem=new ShopItem();
	
	@Override
	public ShopItem getModel() {
		// TODO Auto-generated method stub
		return shopItem;
	}
	
	
	  //注入Service 
	  private ShopService shopService;
	  
	  public void setShopService(ShopService shopService) { 
	  	this.shopService =shopService;
}
	 
	
	//注入GoodService
	private GoodService goodService;
	
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	private Integer gid;
	
	//private Integer count;
	
	//private Double price;

	
	
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	
	/**
	 * 购物车保存到session中
	 * @return
	 */
	private Shop getShop() {
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop");
		if (shop == null) {
			shop = new Shop();
			ServletActionContext.getRequest().getSession().setAttribute("shop", shop);
		}
		return shop;
	}
	
	
	

	/**
	 * 加入结算
	 * @return
	 */
	public String addShop() {
		System.out.println(gid+".."+shopItem.getCount());
		//shopItem.setCount(count);
		Good good=goodService.findById(gid);
		//设置商品
		shopItem.setGood(good);
		System.out.println(shopItem.getGood());
		//获得购物车
		Shop shop=getShop();
		shop.addShop(shopItem);
		System.out.println("...");
		return "addSuccess"; 
	}

	/**
	 * 删除单个药品
	 * @return
	 */
	public String removeShopItem() {
		Shop shop=getShop();
		shop.removeShopItem(gid);
		return "removeSuccess";
	}
	
	/**
	 * 清空所有药品
	 * @return
	 */
	public String clearShop() {
		Shop shop=getShop();
		shop.clearShop();
		return "clearSuccess";
	}
	

	public String commit() {
		getShop();
		return "commitSuccess";
	}
	
	
	
	
	
}
