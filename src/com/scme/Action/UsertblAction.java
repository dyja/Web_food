package com.scme.Action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.scme.Biz.UserBiz;
import com.scme.entity.Usertbl;

public class UsertblAction extends baseAction {
	  private UserBiz userbiz;
      private Usertbl users;
      private String userId;

	public Usertbl getUsers() {
		return users;
	}

	public void setUsers(Usertbl users) {
		this.users = users;
	}

	public UserBiz getUserbiz() {
		return userbiz;
	}

	public void setUserbiz(UserBiz userbiz) {
		this.userbiz = userbiz;
	}
	  
    public void getuserByName()throws Exception{
    	
    	Object [] parmas={this.users.getAccount(),this.users.getPassword()};
    	List<Object []> lists=this.userbiz.getusers(parmas);
    	Object [] list=lists.get(0);
    	Gson gson=new Gson();
    	String result=gson.toJson(list);
    	if (result!=null) {
    		this.getout().print(result);
		}
    }
    public void updateuserAction() throws Exception{
    	try {
			List<Object []> lists=this.userbiz.updateusersBiz(this.users);
			Object [] list=lists.get(0);
			String result=new Gson().toJson(list);
			if (result!=null) {
	    		this.getout().print(result);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void addUserAction() throws Exception{
    	try {
    		int numb=1;
 		   List<String> userIds=this.userbiz.getUserIdsBiz();
 		   if (userIds.size()!=0) {
 			   for (int i = 0; i < userIds.size(); i++) {
 				   if (numb<10) {
 					  userId="u100"+numb;
 					}
 				    else if (numb<100) {
 				    	userId="u10"+numb;
 					 }else {
 						userId="u1"+numb;
 					}
 				if (userIds.get(i).toString().equals(userId)) {
 					 numb++;
 				}else {
 					break;
 				}
 				if ((i+1)==userIds.size()) {
 					if (numb<10) {
 						userId="u100"+numb;
 						}
 					    else if (numb<100) {
 					    	userId="u10"+numb;
 						 }else {
 							userId="u1"+numb;
 						}
 				}
 		    	}
 		 }else {
 			userId="u1001";
 		  }
 		    this.users.setUserId(userId);
			this.userbiz.addUserBiz(this.users);
			this.getout().print("Y");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.getout().print("N");
		}
    }
    public void checkUserBiz() throws Exception{
    	try {
			List<Usertbl> list=this.userbiz.checkUserBiz(this.users.getAccount());
			if (list.size()!=0) {
				this.getout().print("Y");
			}else {	
				this.getout().print("N");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
