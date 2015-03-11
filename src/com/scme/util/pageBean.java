package com.scme.util;

import java.util.List;

public class pageBean {
   private int currentPage;
   private int rowCount;
   private int pageSize;
   private int pageCount;
   private List pageDate;
   public pageBean(int rowCount ,int pageSize){
	   this.rowCount=rowCount;
	   this.pageSize=pageSize;
	   if (this.rowCount%this.pageSize==0) {
		   this.pageCount=this.rowCount/this.pageSize;
	   }else {
		   this.pageCount=this.rowCount/this.pageSize+1;
	}
   }
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getRowCount() {
	return rowCount;
}
public int getPageSize() {
	return pageSize;
}
public int getPageCount() {
	return pageCount;
}
public List getPageDate() {
	return pageDate;
}
public void setPageDate(List pageDate) {
	this.pageDate = pageDate;
}
   
}
