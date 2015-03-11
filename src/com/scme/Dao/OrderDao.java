package com.scme.Dao;

import java.util.List;

import com.scme.entity.Orderdetailtbl;
import com.scme.entity.Ordertbl;

public class OrderDao extends baseDao {
     public void insertOrder(Ordertbl order){
    	 try {
    		 Object [] params={order.getTabletbl().getTableId()};
    		 String sql="update Tabletbl as model set model.flag='F' where model.tableId=?";
    		 this.updateByHql(sql, params);
			 this.save(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
     public List<String> getOrderId(){
    	 List<String> list=null;
    	 try {
    		 String hql="select model.orderId from Ordertbl as model ORDER BY model.orderId ASC";
			 list=this.findByHQl(hql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
     public List<String> getdetailId(){
    	 List<String> list=null;
    	 try {
    		 String hql="select model.detail from Orderdetailtbl as model ORDER BY model.detail ASC";
			 list=this.findByHQl(hql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
     public List<Object []> getOrder(String orderId){
    	 List<Object []> list=null;
    	 try {
    		 Object [] params={orderId};
    		 String hql="select model1.orderId,model2.userName,model3.tableNum,model1.personNum,model1.isPlay,model1.orderTime from Ordertbl as model1 inner join model1.usertbl as model2 inner join model1.tabletbl as model3 where model1.orderId=?";
			 list=this.findByHQl(hql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
     public void updateOrderPlay(String orderId){
    	 Object [] params1={orderId};
  	   String hql1="update Ordertbl as model1 set model1.isPlay='Y' where model1.orderId=?";
  	   this.updateByHql(hql1, params1);
     }
     public void updateOrderPlay2(String tableId){
    	 Object [] params2={tableId};
  	   String hql2="update Tabletbl as model1 set model1.flag='E' where model1.tableId=?";
  	   this.updateByHql(hql2, params2);
     }
     public Object [] getOrderByTable(String tableId){
    	 Object [] obj=null;
    	 try {
			String hql="select model1.orderId,model1.isPlay from Ordertbl as model1 inner join model1.tabletbl as model2 where model2.tableId=? order by model1.orderTime desc";
			Object [] params={tableId};
			List<Object []> list=this.findByHQl(hql, params);
			obj=list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return obj;
     }
     public List<Object []> getOrderByTableId(String tableId){
    	 List<Object []> list=null;
    	 try {
    		 Object [] params={tableId};
    		 String hql="select model1.orderId,model2.userName,model3.tableNum,model1.personNum,model1.isPlay,model1.orderTime from Ordertbl as model1 inner join model1.usertbl as model2 inner join model1.tabletbl as model3 where model3.tableId=?";
			 list=this.findByHQl(hql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
    public Object [] updateOrderDao(String tableId){
    	Object [] params={tableId};
    	String hql1="select model1.orderId,model1.isPlay from Ordertbl as model1 inner join model1.tabletbl as model2 where model2.tableId=? order by model1.orderTime desc";
    	List<Object []> lists=this.findByHQl(hql1, params);
    	Object [] list=lists.get(0);
    	return list;
    }
    public void saveDetailDao(Orderdetailtbl detail){
    	this.save(detail);
    }
}
