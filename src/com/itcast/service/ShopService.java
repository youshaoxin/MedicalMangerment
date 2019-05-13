package com.itcast.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.Dao.ShopDao;
import com.itcast.Dao.UserDao;
import com.itcast.entity.Good;
import com.itcast.entity.Shop;
import com.itcast.entity.ShopItem;

//事务的注解
@Transactional
public class ShopService {

	//注入userDao
	private ShopDao shopDao;
		
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	private Shop shop =new Shop();
	


	public Good finById(Integer gid) {
		return shopDao.finById(gid);
	}

	
	
	/**
	 * 添加到购物车中
	 * @param shopItem
	 */
	/*
	 * public void addShop(ShopItem shopItem) { Map<Integer, ShopItem> map =
	 * shop.getMap(); System.out.println("能到吗"); Integer gid =
	 * shopItem.getGood().getGid(); System.out.println(gid); //判断购物车是否存在购物项
	 * if(map.containsKey(gid)) { //存在 ShopItem shopItemOld = map.get(gid);
	 * //购买数量设置为 (老购物项的总数=老购物项的总数+新购物项的数量)
	 * shopItemOld.setCount(shopItemOld.getCount()+shopItem.getCount());
	 * 
	 * }else { System.out.println("map!!!"); map.put(gid, shopItem);
	 * System.out.println(map.get(gid)); System.out.println("map222"); } Double
	 * total = shop.getTotal(); total +=shopItem.getSubtotal();
	 * System.out.println("能到吗！！！！！？？"); }
	 */

	

}
