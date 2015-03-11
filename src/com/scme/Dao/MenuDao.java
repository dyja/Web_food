package com.scme.Dao;

import java.util.List;

import com.scme.entity.Menutbl;
import com.scme.util.pageBean;

public class MenuDao extends baseDao {
       public pageBean getMenuByType(String menuTypeId,int currentPage,int pageSize){
    	   pageBean pagebean=null;
    	   try {
    		   Object [] params={menuTypeId};
    		   String hql1="select count(model1) from Menutbl as model1 inner join model1.menutypetbl as model2 where model2.menuTypeId=?";
    		   int rowCount=this.getCount(hql1, params);
    		   String hql="select model1.menuId,model1.menultemNo,model1.menuName,model1.menuPrice,model1.pic,model1.menuRemark from Menutbl as model1 inner join model1.menutypetbl as model2 where model2.menuTypeId=?";
    		   List<Object []> list=this.getPageDate(hql, params, currentPage, pageSize);
			   pagebean=new pageBean(rowCount, pageSize);
			   pagebean.setCurrentPage(currentPage);
			   pagebean.setPageDate(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   return pagebean;
       }
       public List<Object []> getMenuTypes(){
    	   List<Object []> list=null;
    	   try {
    		   String hql="select model.menuTypeId,model.menuType from Menutypetbl as model";
			list=this.findByHQl(hql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   return list;
       }
       public List<Object []> getMenusDao(){
    	   List<Object []> menus=null;
    	   String hql="select model1.menuId,model2.menuType,model1.menultemNo,model1.menuName,model1.menuPrice,model1.pic,model1.menuRemark from Menutbl as model1 inner join model1.menutypetbl as model2";
    	   menus=this.findByHQl(hql, null);
    	   return menus;
       }
       public Object [] getOneMenutblDao(String menuName){
    	   Object [] menu=null;
    	   Object [] params={menuName};
    	   String hql="select model1.menuId,model2.menuType,model1.menultemNo,model1.menuName,model1.menuPrice,model1.pic,model1.menuRemark,model2.menuTypeId from Menutbl as model1 inner join model1.menutypetbl as model2 where model1.menuName=?";
    	   List<Object []> list=this.findByHQl(hql, params);
    	   if (list.size()>0) {
			menu=list.get(0);
		}
    	   return menu;
       }
}
