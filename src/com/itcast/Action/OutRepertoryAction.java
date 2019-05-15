package com.itcast.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itcast.entity.OutRepertory;
import com.itcast.entity.Repertory;
import com.itcast.service.RepertoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OutRepertoryAction extends ActionSupport implements ModelDriven<OutRepertory> {

	private RepertoryService outrepertoryService;
	// 注入service

	// 模型驱动
	private OutRepertory outRepertory = new OutRepertory();

	private String brithdate;
	
	

	

	public void setBrithdate(String brithdate) {
		this.brithdate = brithdate;
	}

	public OutRepertory getOutRepertory() {
		return outRepertory;
	}

	public RepertoryService getOutrepertoryService() {
		return outrepertoryService;
	}

	public void setOutrepertoryService(RepertoryService outrepertoryService) {
		this.outrepertoryService = outrepertoryService;
	}

	public void setOutRepertory(OutRepertory outRepertory) {
		this.outRepertory = outRepertory;
	}

	@Override
	public OutRepertory getModel() {
		// TODO Auto-generated method stub
		return outRepertory;
	}

	// 出库产品 查询 需要 出库产品信息
	public String outrepertory() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String rnumber = request.getParameter("number");
		System.out.println(rnumber);
		// request.getParameter("")
		System.out.println("出库产品 进入action");
		List<Repertory> reper = (List<Repertory>) outrepertoryService.outrepertory(rnumber);

		System.out.println(reper);

		for (Repertory out : reper) {
			if (out.getRnumber().equals(rnumber)) {
				ActionContext.getContext().getValueStack().set("outdate", out);
				System.out.println(out);
				return "outrepertory";
			}
		}

		System.out.println(reper);

		System.out.println("出库产品 action出");
		return "outrepertoryfalse";
	}

	// 出库插入 数据 和数量的减少
	public String insertoutrepertory() {

		System.out.println("进action.............");
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 多态
		// 2017-04-19 星期三 下午 20:17:38
		HttpServletRequest request = ServletActionContext.getRequest();
		String format = bf.format(date);// 格式化 bf.format(date);
		System.out.println(format);
		// 往outRepertory添加时间
		outRepertory.setOutdate(format);
		System.out.println(outRepertory);
		System.out.println("进出库action....");

		// 出库插入 数据
		/*
		 * String outbrithdate = request.getParameter("outbrithdate"); String
		 * outbrithdate2 = bf.format(outbrithdate);
		 * System.out.println("看下 输出数量是 outbrithdate是什么格式"+outbrithdate);
		 * System.out.println("看下 输出数量是 outbrithdate2是什么格式"+outbrithdate2);
		 */

		
		String[] split = brithdate.split("\\.");
		System.out.println(split[0]);
		outRepertory.setOutbrithdate(split[0]);
		System.out.println("叶祖炯成功了！可喜可贺!");
		outrepertoryService.insertoutrepertory(outRepertory);

		
		
		
		
		
		String outnumber = request.getParameter("outnumber");// 获取订单编号

		List<Repertory> outperson = outrepertoryService.outrepertory("outnumber");// 根据编号查Repertory

		int outnum = Integer.parseInt(request.getParameter("outnum"));// 获取 订单数量

		// int outnum2=Integer.parseInt(outnumber);

		for (Repertory person : outperson) {
			if (person.getRnumber().equals(outnumber)) {
				// rtotal
				// 根据 总数
				int rtotal = Integer.parseInt(person.getRtotal());
				System.out.println(rtotal);
				String num = (rtotal - outnum) + "";
				System.out.println(num);
				person.setRtotal(num);
//出库， 入库数量的减少 
				outrepertoryService.updatetotal(person);
			}

		}

		System.out.println(outnumber);
		System.out.println(outnum);
		System.out.println("出库action.............");

		return "insertoutrepertory";
	}

	// 出库列表查询 所有出库商品
	public String outRepertoryquery() {
		System.out.println("出库查询action进");

		List<OutRepertory> outRepertory = outrepertoryService.outRepertoryquery();

		// 放入值栈中
		ActionContext.getContext().getValueStack().set("outRepertory", outRepertory);

		System.out.println("出库查询action出");

		return "outRepertoryquery";
	}

}
