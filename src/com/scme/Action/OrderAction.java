package com.scme.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import com.google.gson.Gson;
import com.scme.Biz.OrderBiz;
import com.scme.entity.Orderdetailtbl;
import com.scme.entity.Ordertbl;

public class OrderAction extends baseAction{
   private OrderBiz orderbiz;
    private Ordertbl order;
    private Orderdetailtbl detail;
    
    String orderid;
    String detailid;
    
public Orderdetailtbl getDetail() {
		return detail;
	}

	public void setDetail(Orderdetailtbl detail) {
		this.detail = detail;
	}

public Ordertbl getOrder() {
		return order;
	}

	public void setOrder(Ordertbl order) {
		this.order = order;
	}

public OrderBiz getOrderbiz() {
	return orderbiz;
}

public void setOrderbiz(OrderBiz orderbiz) {
	this.orderbiz = orderbiz;
}
   public void insertOrder() throws Exception{
	   try {
		   int numb=1;
		   List<String> orderids=this.orderbiz.getordrer();
		   if (orderids.size()!=0) {
			   for (int i = 0; i < orderids.size(); i++) {
				   if (numb<10) {
				       orderid="o100"+numb;
					}
				    else if (numb<100) {
				       orderid="o10"+numb;
					 }else {
					    orderid="o1"+numb;
					}
				if (orderids.get(i).toString().equals(orderid)) {
					 numb++;
				}else {
					break;
				}
				if ((i+1)==orderids.size()) {
					if (numb<10) {
					       orderid="o100"+numb;
						}
					    else if (numb<100) {
					       orderid="o10"+numb;
						 }else {
						    orderid="o1"+numb;
						}
				}
		    	}
		}else {
			orderid="o1001";
		}
		   this.order.setOrderId(orderid);
		   int num=this.order.getPersonNum();
		   this.order.setPersonNum(num);
		   this.order.setIsPlay("N");
		   Date date=new Date();
		   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String time=format.format(date);
		   this.order.setOrderTime(time);
		   this.order.setOrderRemark("нч");
		   this.orderbiz.addaorder(this.order);
		   this.getout().print(orderid);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void getOrderById() throws Exception{
	   try {
		  List<Object []> list=this.orderbiz.getOrderByOrderId(this.order.getOrderId());
		  String result=new Gson().toJson(list);
		  this.getout().print(result);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void updateorderBypay() throws Exception{
	   try {
		this.orderbiz.updateOrderPlay(this.order.getOrderId());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void updateorderBypay2() throws Exception{
	   try {
		this.orderbiz.updateOrderPlay2(this.order.getTabletbl().getTableId());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void getorderByTable() throws Exception{
	   try {
		Object [] obj=this.orderbiz.getOrderByTableid(this.order.getTabletbl().getTableId());
		String result=new Gson().toJson(obj);
		this.getout().print(result);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void getOrderByTableids() throws Exception{
	   try {
		List<Object []> list=this.orderbiz.getOrderByTableByIds(this.order.getTabletbl().getTableId());
		String result=new Gson().toJson(list);
		this.getout().print(result);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public void updateOrderAction() throws Exception{
	   try {
		Object [] list=this.orderbiz.updateOrderBiz(this.order.getTabletbl().getTableId());
		 if (list[1].toString().equals("N")) {
   		   int numb=1;
 		   List<String> orderids=this.orderbiz.getdetailIdBiz();
 		   if (orderids.size()!=0) {
 			   for (int i = 0; i < orderids.size(); i++) {
 				   if (numb<10) {
 					 detailid="d100"+numb;
 					}
 				    else if (numb<100) {
 				    	detailid="d10"+numb;
 					 }else {
 						detailid="d1"+numb;
 					}
 				if (orderids.get(i).toString().equals(detailid)) {
 					 numb++;
 				}else {
 					break;
 				}
 				if ((i+1)==orderids.size()) {
 					if (numb<10) {
 						detailid="d100"+numb;
 						}
 					    else if (numb<100) {
 					    	detailid="d10"+numb;
 						 }else {
 							detailid="d1"+numb;
 						}
 				}
 		    	}
 		}else {
 			detailid="d1001";
 		}
 		  this.detail.setDetail(detailid);
 		  Ordertbl order=new Ordertbl();
 		  order.setOrderId(list[0].toString());
 		  this.detail.setOrdertbl(order);
 		  this.orderbiz.saveDetailBiz(this.detail);
		}
   	if (list[1].toString().equals("Y")) {
   		    this.insertOrder();
   		    this.updateOrderAction();
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
}
