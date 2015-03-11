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
        
		//��ȡȫ��
	      public List getAll(){
	    	  String sql="from "+this.poName;
	    	  List list=this.getHibernateTemplate().find(sql);
	    	  return list;
	      }
	      //����ID��ȡ
	      public Object getById(Serializable id){
	    	  Object obj=this.getHibernateTemplate().get(this.poName, id);
	    	  return obj;
	      }
	      //ɾ��ʵ��
	      public void delete(Object entity){
	    	  this.getHibernateTemplate().delete(entity);
	      }
	      //����IDɾ��
	      public void deleteById(Serializable id){
	    	  Object entity=this.getHibernateTemplate().get(this.poName, id);
	    	  this.getHibernateTemplate().delete(entity);
	      }
	      //����
	      public void save(Object entity){
	    	  this.getHibernateTemplate().save(entity);
	      }
	      public void saveOrupdate(Object entity){
	    	  this.getHibernateTemplate().saveOrUpdate(entity);
	      }
	      //����Hql��ѯ
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
	      //����Hql�����޸�
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
	      //��ȡ������
	      public int getCount(String hql,Object [] params){
	    	  List list=this.getHibernateTemplate().find(hql,params);
	    	  
	    	  Number num =null;
	    	  if(list.size()>0){
	    		  num =(Number)list.get(0);
	    	  }
	    	  int rowCount=num.intValue();
			  return rowCount;  
	    	 
	    	 
	      }
	      //ͨ�õķ�ҳ��ѯ����
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
