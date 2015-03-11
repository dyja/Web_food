package com.scme.Action;

import java.util.List;

import com.google.gson.Gson;
import com.scme.Biz.TableBiz;
import com.scme.entity.Tabletbl;

public class TableAcion extends baseAction {
     private TableBiz tablebiz;

	public TableBiz getTablebiz() {
		return tablebiz;
	}

	public void setTablebiz(TableBiz tablebiz) {
		this.tablebiz = tablebiz;
	}
     public void getTableAll() throws Exception{
    	 try {
			List<Object []> tabels=this.tablebiz.getTables();
			Gson gson=new Gson();
			String result=gson.toJson(tabels);
			if (result!=null) {
				this.getout().print(result);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
     public void getTableIds() throws Exception{
    	 try {
			List<Object []> tableid=this.tablebiz.gettableId();
			String result=new Gson().toJson(tableid);
			this.getout().print(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
     public void getTableIds2() throws Exception{
    	 try {
			List<Object []> tableid=this.tablebiz.getTableIdsBiz();
			String result=new Gson().toJson(tableid);
			this.getout().print(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
     public void getTableAfoodAction() throws Exception{
    	 try {
    		 List<Object []> list=this.tablebiz.getTableAfoodBiz();
    		 if (list.size()>0) {
				this.getout().print(new Gson().toJson(list));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
}
