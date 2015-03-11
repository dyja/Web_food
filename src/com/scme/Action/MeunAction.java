package com.scme.Action;

import java.util.List;

import com.google.gson.Gson;
import com.scme.Biz.MenuBiz;
import com.scme.entity.Menutbl;
import com.scme.entity.Menutypetbl;
import com.scme.util.pageBean;

public class MeunAction extends baseAction {
    private MenuBiz menubiz;
    private Menutbl menu;
    private String currentPage;
    private String pageSize;
    
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Menutbl getMenu() {
		return menu;
	}

	public void setMenu(Menutbl menu) {
		this.menu = menu;
	}

	public MenuBiz getMenubiz() {
		return menubiz;
	}

	public void setMenubiz(MenuBiz menubiz) {
		this.menubiz = menubiz;
	}
    public void getMenuAll() throws Exception{
    	try {
    		pageBean list=this.menubiz.getMenus(this.menu.getMenultemNo(),Integer.parseInt(this.currentPage),Integer.parseInt(this.pageSize));
			Gson gson=new Gson();
			String result=gson.toJson(list);
			this.getout().print(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void getMenuType() throws Exception{
    	try {
			List<Object []> list=this.menubiz.getType();
			Gson gson=new Gson();
			String result=gson.toJson(list);
			this.getout().print(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void getMenusAction() throws Exception{
    	try {
			List<Object []> menus=this.menubiz.getMenusBiz();
			if (menus!=null) {
				this.getout().print(new Gson().toJson(menus));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void getOneMenutblAction() throws Exception{
    	try {
			Object [] menu=this.menubiz.getOneMenutblBiz(this.menu.getMenuName());
			this.getout().print(new Gson().toJson(menu));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
