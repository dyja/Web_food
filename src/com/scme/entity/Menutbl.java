package com.scme.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menutbl entity. @author MyEclipse Persistence Tools
 */

public class Menutbl implements java.io.Serializable {

	// Fields

	private String menuId;
	private Menutypetbl menutypetbl;
	private String menultemNo;
	private String menuName;
	private Float menuPrice;
	private String pic;
	private String menuRemark;
	private Set orderdetailtbls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menutbl() {
	}

	/** minimal constructor */
	public Menutbl(String menuId) {
		this.menuId = menuId;
	}

	/** full constructor */
	public Menutbl(String menuId, Menutypetbl menutypetbl, String menultemNo,
			String menuName, Float menuPrice, String pic, String menuRemark,
			Set orderdetailtbls) {
		this.menuId = menuId;
		this.menutypetbl = menutypetbl;
		this.menultemNo = menultemNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.pic = pic;
		this.menuRemark = menuRemark;
		this.orderdetailtbls = orderdetailtbls;
	}

	// Property accessors

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public Menutypetbl getMenutypetbl() {
		return this.menutypetbl;
	}

	public void setMenutypetbl(Menutypetbl menutypetbl) {
		this.menutypetbl = menutypetbl;
	}

	public String getMenultemNo() {
		return this.menultemNo;
	}

	public void setMenultemNo(String menultemNo) {
		this.menultemNo = menultemNo;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Float getMenuPrice() {
		return this.menuPrice;
	}

	public void setMenuPrice(Float menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getMenuRemark() {
		return this.menuRemark;
	}

	public void setMenuRemark(String menuRemark) {
		this.menuRemark = menuRemark;
	}

	public Set getOrderdetailtbls() {
		return this.orderdetailtbls;
	}

	public void setOrderdetailtbls(Set orderdetailtbls) {
		this.orderdetailtbls = orderdetailtbls;
	}

}