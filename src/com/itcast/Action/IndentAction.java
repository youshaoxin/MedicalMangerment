package com.itcast.Action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.Indent;
import com.itcast.entity.IndentDetail;
import com.itcast.entity.Shop;
import com.itcast.entity.ShopItem;
import com.itcast.entity.User;
import com.itcast.service.IndentDetailService;
import com.itcast.service.IndentService;
import com.itcast.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndentAction extends ActionSupport implements ModelDriven<Indent>{

	private Indent indent=new Indent();
	@Override
	public Indent getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//注入订单的service
	private IndentService indentService;
	
	
	public void setIndentService(IndentService indentService) {
		this.indentService = indentService;
	}


	//注入订单详情的service
	private IndentDetailService indentDetailService;
	
	
	public void setIndentDetailService(IndentDetailService indentDetailService) {
		this.indentDetailService = indentDetailService;
	}

	//注入用户的service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	private String indentid;
	
	private String phone;
	
	
	private Integer uid;
	
	

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIndentid() {
		return indentid;
	}

	public void setIndentid(String indentid) {
		this.indentid = indentid;
	}

	//生成订单
	public String addIndent() {
		System.out.println("到这里了吗？？");
	//	Indent indent =new Indent();
		
	
		//生成订单时间
		SimpleDateFormat df =new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式, 编号
		SimpleDateFormat date =new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式, 下单时间
		
		String indentId =df.format(new Date());
		String indentDate =date.format(new Date());
		//统计页面上的值
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userlogin");
		if(user==null) {
			User user667 = userService.finById(667);
			System.out.println(user667);
			indent.setUser(user667);
		}else {
			indent.setUser(user);
		}
		
		Double total = shop.getTotal();
		
		
		
		indent.setIndentid(indentId);
		indent.setIndentDate(indentDate);
		indent.setIndentPrice(total);
		
		
		indentService.addIndent(indent);
		
		Collection<ShopItem> shopItems = shop.getShopItems();
		
		IndentDetail indentDetail=new IndentDetail();
		//生成订单详情
		for (ShopItem shopItem : shopItems) {
			indentDetail.setIndentid(indentId);
			indentDetail.setGid(shopItem.getGood().getGid());
			indentDetail.setGname(shopItem.getGood().getGname());
			indentDetail.setCount(shopItem.getCount());
			indentDetail.setPrice(shopItem.getGood().getPrice());
			indentDetail.setSubtotal(shopItem.getSubtotal());
			System.out.println(indentDetail);
			indentDetailService.addIndentDetail(indentDetail);
			System.out.println(shopItem.getGood().getGname()+"..."+shopItem.getGood().getPrice()+"..."+shopItem.getCount()+"..."+shopItem.getSubtotal());
		}
		
		ServletActionContext.getRequest().getSession().invalidate();
		//ServletActionContext.getRequest().getSession().removeAttribute("shop");
		return "addSuccess";
	}
	
	/**
	 * 查询订单
	 * @return
	 */
	public String findIndent(){
		List<Indent> indentList=indentService.findList();
		ActionContext.getContext().getValueStack().set("indentList", indentList);
		System.out.println(indentList);
		return "findSuccess";
	}

	/**
	 * 查看订单详情
	 * @return
	 */
	public String findIndentDetail() {
		System.out.println("findIndentDetail能到吗");
		System.out.println(indentid);
		 List<IndentDetail> IndentDetailList =indentDetailService.findByIndentId(indentid);
		 System.out.println(IndentDetailList);
		 ActionContext.getContext().getValueStack().set("IndentDetailList", IndentDetailList);
		return "findDetailSuccess";
	}
	
	
	/**
	 * 通过手机号查询到订单表
	 * @return
	 */
	public String SearchIndent() {
		List<User> userlist = userService.searchUser(phone);
		User user = userlist.get(0);
		Integer uid = user.getUid();
		List<Indent> indentList =indentService.SearchIndent(uid);
		ActionContext.getContext().getValueStack().set("indentList", indentList);
		return "searchSuccess";
	}
	/**
	 * 通过会员id查询到订单表
	 * @return
	 */
	public String findIndentById() {
		List<Indent> indentList =indentService.SearchIndent(uid);
		ActionContext.getContext().getValueStack().set("indentList", indentList);
		return "searchSuccess";
	}
	
}
