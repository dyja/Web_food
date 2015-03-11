package com.scme.Biz;

import java.util.List;

import com.scme.Dao.OrderDao;
import com.scme.entity.Orderdetailtbl;
import com.scme.entity.Ordertbl;

public class OrderBiz {
       private OrderDao orderdao;

	public OrderDao getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(OrderDao orderdao) {
		this.orderdao = orderdao;
	}
       public void addaorder(Ordertbl order){
    	   this.orderdao.insertOrder(order);
       }
       public List<String> getordrer(){
    	   List<String> list=this.orderdao.getOrderId();
    	   return list;
       }
       public List<String> getdetailIdBiz(){
    	   List<String> list=this.orderdao.getdetailId();
    	   return list;
       }
       public List<Object []> getOrderByOrderId(String orderId){
    	   List<Object []> list=this.orderdao.getOrder(orderId);
    	   return list;
       }
      public void updateOrderPlay(String orderId){
    	  this.orderdao.updateOrderPlay(orderId);
      }
      public void updateOrderPlay2(String tableId){
    	  this.orderdao.updateOrderPlay2(tableId);
      }
      public Object [] getOrderByTableid(String tableId){
    	  Object [] obj=this.orderdao.getOrderByTable(tableId);
    	  return obj;
      }
      public List<Object []> getOrderByTableByIds(String tableid){
    	  List<Object []> list=this.orderdao.getOrderByTableId(tableid);
    	  return list;
      }
      public Object [] updateOrderBiz(String tableId){
    	  Object [] obj=this.orderdao.updateOrderDao(tableId);
    	  return obj;
      }
      public void saveDetailBiz(Orderdetailtbl detail){
    	  this.orderdao.saveDetailDao(detail);
      }
}
