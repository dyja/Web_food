package com.scme.Biz;

import java.util.List;

import com.scme.Dao.OrderdetailDao;
import com.scme.entity.Orderdetailtbl;

public class OrderdetailBiz {
    private OrderdetailDao detaildao;

	public OrderdetailDao getDetaildao() {
		return detaildao;
	}

	public void setDetaildao(OrderdetailDao detaildao) {
		this.detaildao = detaildao;
	}
    public void addDetail(Orderdetailtbl detali){
    	this.detaildao.insertDetail(detali);
    }
    public List<String> getDetailIdAll(){
    	List<String> list=this.detaildao.getDetailId();
    	return list;
    }
    public List<Object []> getDetailAll(String detailId){
    	List<Object []> list=this.detaildao.getDetailByOrder(detailId);
    	return list;
    }
    public void deletedetail2(String DetailId){
 	   try {
 		 this.detaildao.deletedetail(DetailId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 	    
    }
    public Object [] mergetables(String tableid){
    	Object [] number=this.detaildao.mergetable(tableid);
    	return number;
    }
    public void updateNumberbiz(int number,String orderId){
    	this.detaildao.updateNumberdao(number, orderId);
    }
    public void updateplayBiz(String orderId){
    	this.detaildao.updateplayDao(orderId);
    }
    public void updateTableispayBiz(String tableId){
    	this.detaildao.updateTableispayDao(tableId);
    }
    public void updateTableispayBiz2(String tableId){
    	this.detaildao.updateTableispayDao2(tableId);
    }
    public void updateOrderIdByOrderdetailBiz(String orderid1,String orderid2){
    	this.detaildao.updateOrderIdByOrderdetailDao(orderid1, orderid2);
    }
    public void updateOrderBytableBiz(String tableid1,String tableid2){
    	this.detaildao.updateOrderBytableDao(tableid1, tableid2);
    }
}
