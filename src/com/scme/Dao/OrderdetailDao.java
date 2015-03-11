package com.scme.Dao;

import java.util.List;

import com.scme.entity.Orderdetailtbl;

public class OrderdetailDao extends baseDao {
       public void insertDetail(Orderdetailtbl detali){
    	   try {
			   this.save(detali);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       }
       public List<String> getDetailId(){
    	   String hql="select model.detail from Orderdetailtbl as model order by model.detail asc";
    	   List<String> list=this.findByHQl(hql, null);
    	   return list;
       }
       public List<Object []> getDetailByOrder(String orderId){
    	   String hql="select model2.menuName,model1.totalNum,model1.totalPrice,model2.menuPrice,model1.detail from Orderdetailtbl as model1 inner join model1.menutbl as model2 inner join model1.ordertbl as model3 where model3.orderId=?";
    	   Object [] params={orderId};
    	   List<Object []> list=this.findByHQl(hql, params);
    	   return list;
       }
       public void deletedetail(String DetailId){
    	   try {
    		  this.deleteById(DetailId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	    
       }
       public Object[] mergetable(String tableid){
    	       Object [] table=null;
      	   try {
      		      Object [] params={tableid};
    			  String hql="select model1.orderId,model1.personNum from Ordertbl as model1 inner join model1.tabletbl as model2 where model2.tableId=? order by model1.orderTime desc";
    			  List<Object []> tableids=this.findByHQl(hql, params);
    			  table =tableids.get(0);
    			  
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    		return table;
         }
       public void updateNumberdao(int number,String orderId){
    	   String hql="update Ordertbl as model1 set model1.personNum=? where model1.orderId=?";
    	   Object [] params={number,orderId};
    	   this.updateByHql(hql, params);
       }
       public void updateplayDao(String orderId){
    	   String hql="update Ordertbl as model1 set model1.isPlay='Y' where model1.orderId=?";
    	   Object [] params={orderId};
    	   this.updateByHql(hql, params);
       } 
       public void updateTableispayDao(String tableId){
    	   String hql="update Tabletbl as model1 set model1.flag='E' where model1.tableId=?";
    	   Object [] params={tableId};
    	   this.updateByHql(hql, params);
       }
       public void updateTableispayDao2(String tableId){
    	   String hql="update Tabletbl as model1 set model1.flag='F' where model1.tableId=?";
    	   Object [] params={tableId};
    	   this.updateByHql(hql, params);
       }
       public void updateOrderIdByOrderdetailDao(String orderid1,String orderid2){
    	   String hql="update Orderdetailtbl as model set model.ordertbl.orderId=? where model.ordertbl.orderId=?";
    	   Object [] params={orderid2,orderid1};
    	   this.updateByHql(hql, params);
    	   
       }
      public void updateOrderBytableDao(String tableid1,String tableid2){
    	  String hql="update Ordertbl as model set model.tabletbl.tableId=? where model.orderId=?";
    	  Object [] params={tableid1,tableid2};
    	  this.updateByHql(hql, params);
      }
}
