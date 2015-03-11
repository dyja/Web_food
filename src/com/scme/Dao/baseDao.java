package com.scme.Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class baseDao extends HibernateDaoSupport {
        private String poName;

		public String getPoName() {
			return poName;
		}
        
		public void setPoName(String poName) {
			this.poName = poName;
		}
        
		//获取全部
	      public List getAll(){
	    	  String sql="from "+this.poName;
	    	  List list=this.getHibernateTemplate().find(sql);
	    	  return list;
	      }
	      //根据ID获取
	      public Object getById(Serializable id){
	    	  Object obj=this.getHibernateTemplate().get(this.poName, id);
	    	  return obj;
	      }
	      //删除实体
	      public void delete(Object entity){
	    	  this.getHibernateTemplate().delete(entity);
	      }
	      //根据ID删除
	      public void deleteById(Serializable id){
	    	  Object entity=this.getHibernateTemplate().get(this.poName, id);
	    	  this.getHibernateTemplate().delete(entity);
	      }
	      //保存
	      public void save(Object entity){
	    	  this.getHibernateTemplate().save(entity);
	      }
	      public void saveOrupdate(Object entity){
	    	  this.getHibernateTemplate().saveOrUpdate(entity);
	      }
	      //根据Hql查询
	      public List findByHQl(String hql,Object [] params){
	    	  List list=null;
	    	  try {
	    		 list=this.getHibernateTemplate().find(hql, params);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	  return list;
	      }
	      //根据Hql进行修改
	      public int updateByHql(final String hql,final Object [] params){
	    	  int num=getHibernateTemplate().execute(new HibernateCallback( 
	    			  ) {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							Query query=session.createQuery(hql);
							if (params!=null) {
								for (int i = 0; i < params.length; i++) {
									query.setParameter(i, params[i]);
								}
							}
							return query.executeUpdate();
						}
			});
	    	  return num;
	      }
	      //获取总行数
	      public int getCount(String hql,Object [] params){
	    	  List list=this.getHibernateTemplate().find(hql,params);
	    	  
	    	  Number num =null;
	    	  if(list.size()>0){
	    		  num =(Number)list.get(0);
	    	  }
	    	  int rowCount=num.intValue();
			  return rowCount;  
	    	 
	    	 
	      }
	      //通用的分页查询方法
	      public List getPageDate(final String hql,final Object [] params,final int currentPage,final int pageSize){
	    	  List list=this.getHibernateTemplate().executeFind(new HibernateCallback(  
	    			  ) {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							Query query=session.createQuery(hql);
							if (params!=null) {
								for (int i = 0; i < params.length; i++) {
									query.setParameter(i, params[i]);
								}
								}
								query.setFirstResult((currentPage-1)*pageSize);
								query.setMaxResults(pageSize);
							return query.list();
						}
			});
	    	  return list;
	      }
}
