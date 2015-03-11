package com.scme.Dao;

import java.util.List;

import com.scme.entity.Usertbl;

public class UserDao extends baseDao {
     public List<Object []> getuser(Object [] params){
    	 String hql="select model.userId,model.account,model.password,model.userName,model.sex,model.pemission,model.remark from Usertbl as model where model.account=? and model.password=?"; 
    	 List<Object []> list=this.findByHQl(hql, params);
    	 return list;
     }
     
     public List<Object []> updateusers(Usertbl users){
    	 List<Object []> list=null;
    	 Object [] params={users.getAccount(),users.getPassword(),users.getUserName(),users.getSex(),users.getPemission(),users.getRemark(),users.getUserId()};
    	 String hql="update Usertbl as model set model.account=?,model.password=?,model.userName=?,model.sex=?,model.pemission=?,model.remark=? where model.userId=?";
    	 Object [] params2={users.getAccount(),users.getPassword()};
    	 this.updateByHql(hql, params);
    	 list=this.getuser(params2);
    	 return list;
     }
     public void adduserDao(Usertbl user){
    	 try {
    		 this.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   
     } 
     public List<String> getUserIdsDao(){
    	 List<String> list=null;
    	 try {
    		 String hql="select model.userId from Usertbl as model ORDER BY model.userId ASC";
			 list=this.findByHQl(hql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
     public List<Usertbl> checkUserDao(String account){
    	 List<Usertbl> list=null;
    	 try {
			String hql="from Usertbl as model where model.account='"+account+"'";
			list=this.findByHQl(hql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
     }
}
