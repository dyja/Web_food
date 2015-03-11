package com.scme.Action;

import java.util.List;

import com.google.gson.Gson;
import com.scme.Biz.OrderdetailBiz;
import com.scme.entity.Orderdetailtbl;

public class OrderdetailAction extends baseAction {
       private OrderdetailBiz detailbiz;
       private Orderdetailtbl detali;
       String detailid;
       private String tableid1;
       private String tableid2;
      
	public String getTableid1() {
		return tableid1;
	}

	public void setTableid1(String tableid1) {
		this.tableid1 = tableid1;
	}

	public String getTableid2() {
		return tableid2;
	}

	public void setTableid2(String tableid2) {
		this.tableid2 = tableid2;
	}

	public Orderdetailtbl getDetali() {
		return detali;
	}

	public void setDetali(Orderdetailtbl detali) {
		this.detali = detali;
	}

	public OrderdetailBiz getDetailbiz() {
		return detailbiz;
	}

	public void setDetailbiz(OrderdetailBiz detailbiz) {
		this.detailbiz = detailbiz;
	}
       public void insetDetail() throws Exception{
    	   try {
    		   int numb=1;
    		   List<String> detailids=this.detailbiz.getDetailIdAll();
    		   if (detailids.size()!=0) {
    			   for (int i = 0; i < detailids.size(); i++) {
        			   if (numb<10) {
        				   detailid="d100"+numb;
        				}
        			    else if (numb<100) {
        			    	detailid="d10"+numb;
        				 }else {
        					 detailid="d1"+numb;
        				}
        			if (detailids.get(i).toString().equals(detailid)) {
        				 numb++;
        			}else {
        				break;
        			}
        			if ((i+1)==detailids.size()) {
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
    		  
    		   this.detali.setDetail(detailid);  
    		   Double price=this.detali.getTotalPrice()*this.detali.getTotalNum();
    		   this.detali.setTotalPrice(price);
    		   this.detali.setDetailRemark("нч");
			   this.detailbiz.addDetail(this.detali);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       }
       public void getOrderDetailAll() throws Exception{
    	   List<Object []> list;
    	   try {
    		   list=this.detailbiz.getDetailAll(this.detali.getOrdertbl().getOrderId());
    		   Gson gson=new Gson();
    		   String result=gson.toJson(list);
    		   this.getout().print(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   
    	   
       }
       public void deletedetail3() throws Exception {
    	   try {
    		 this.detailbiz.deletedetail2(this.detali.getDetail());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	    
       }
       public void mergetable() throws Exception{
    	   try {
			    Object [] obj1=this.detailbiz.mergetables(this.tableid1);
			    Object [] obj2=this.detailbiz.mergetables(this.tableid2);
			    int number=Integer.parseInt(obj1[1].toString())+Integer.parseInt(obj2[1].toString());
			    this.detailbiz.updateNumberbiz(number, obj2[0].toString());
			    this.detailbiz.updateplayBiz(obj1[0].toString());
			    this.detailbiz.updateTableispayBiz(this.tableid1);
			    this.detailbiz.updateOrderIdByOrderdetailBiz(obj1[0].toString(), obj2[0].toString());
			    List<Object []> list2=this.detailbiz.getDetailAll(obj2[0].toString());
			    String result2=new Gson().toJson(list2);
			    this.getout().print(result2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       }
       public void turntable() throws Exception{
    	   try {
    		   Object [] obj1=this.detailbiz.mergetables(this.tableid1);
			   this.detailbiz.updateTableispayBiz(this.tableid1);
			   this.detailbiz.updateTableispayBiz2(this.tableid2);
			   this.detailbiz.updateOrderBytableBiz(this.tableid2, obj1[0].toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       }
}
