package com.scme.Dao;

import java.util.List;

import com.scme.entity.Tabletbl;

public class TableDao extends baseDao {
        public List<Object []> gettabel(){
        	List<Object []> tables=null;
        	try {
				String hql="select model.tableId,model.tableNum,model.flag,model.description from Tabletbl as model";
        		tables=this.findByHQl(hql, null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        	return tables;
        }
        public List<Object []> getTableIds(){
        	List<Object []> tableids=null;
        	try {
				String hql="select model.tableId,model.tableNum from Tabletbl as model where model.flag='F'";
				tableids=this.findByHQl(hql, null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return tableids;
        }
        public List<Object []> getTableIdsDao(){
        	List<Object []> tableid1=null;
        	try {
				String hql="select model.tableId,model.tableNum from Tabletbl as model where model.flag='E'";
				tableid1=this.findByHQl(hql, null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return tableid1;
        }
        public List<Object []> getTableAfoodDao(){
        	String hql="select model1.tableId,model1.tableNum,model1.flag from Tabletbl as model1";
        	List<Object []> list=this.findByHQl(hql, null);
        	return list;
        }
}
