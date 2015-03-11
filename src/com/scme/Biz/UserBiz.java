package com.scme.Biz;

import java.util.List;

import com.scme.Dao.UserDao;
import com.scme.entity.Usertbl;

public class UserBiz {
	   private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	   public List<Object []> getusers(Object [] params){
		   List<Object []> list=this.userdao.getuser(params);
		   return list;
	   }
	   public List<Object []> updateusersBiz(Usertbl users){
		   List<Object []> list=this.userdao.updateusers(users);
		   return list;
	   }
	   public void addUserBiz(Usertbl user){
		   this.userdao.adduserDao(user);  
	   }
	   public List<String> getUserIdsBiz(){
		   List<String> userIds=this.userdao.getUserIdsDao();
		   return userIds;
	   }
	   public List<Usertbl> checkUserBiz(String account){
		   List<Usertbl> list=this.userdao.checkUserDao(account);
		   return list;
	   }
}

