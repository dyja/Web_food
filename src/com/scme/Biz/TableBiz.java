package com.scme.Biz;

import java.util.List;

import com.scme.Dao.TableDao;
import com.scme.entity.Tabletbl;

public class TableBiz {
    private TableDao tabledao;

	public TableDao getTabledao() {
		return tabledao;
	}

	public void setTabledao(TableDao tabledao) {
		this.tabledao = tabledao;
	}
      public List<Object []> getTables(){
    	  List<Object []> tabels=this.tabledao.gettabel();
    	  return tabels;
      }
      public List<Object []> gettableId(){
    	  List<Object []> tableids=this.tabledao.getTableIds();
    	  return tableids;
      }
      public List<Object []> getTableIdsBiz(){
    	  List<Object []> list=this.tabledao.getTableIdsDao();
    	  return list;
      }
      public List<Object []> getTableAfoodBiz(){
    	  List<Object []> list=this.tabledao.getTableAfoodDao();
    	  return list;
      }
}
