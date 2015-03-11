package com.scme.Biz;

import java.util.List;

import com.scme.Dao.MenuDao;
import com.scme.util.pageBean;

public class MenuBiz {
	   private MenuDao menudao;

	public MenuDao getMenudao() {
		return menudao;
	}

	public void setMenudao(MenuDao menudao) {
		this.menudao = menudao;
	}

	public pageBean getMenus(String menuTypeId,int currentPage,int pageSize){
		pageBean list=null;
    	   try {
			list=this.menudao.getMenuByType(menuTypeId,currentPage,pageSize);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   return list;
       }
	public List<Object []> getType(){
		List<Object []> list=this.menudao.getMenuTypes();
		return list;
	}
	public List<Object []> getMenusBiz(){
		List<Object []> list=this.menudao.getMenusDao();
		return list;
	}
	public Object [] getOneMenutblBiz(String menuName){
		Object [] menu=this.menudao.getOneMenutblDao(menuName);
		return menu;
	}
}
