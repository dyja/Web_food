package com.scme.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class baseAction {
     public Map<String,Object> getRequest(){
    	 Map<String,Object> request=(Map<String,Object>)ActionContext.getContext().get("request");
    	 return request;
     }
     public Map<String,Object> getSession(){
    	 Map<String,Object> session=(Map<String,Object>)ActionContext.getContext().getSession();
    	 return session;
     }
     public PrintWriter getout(){
    	HttpServletResponse response=ServletActionContext.getResponse();
 		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return out;
     }
     
}
