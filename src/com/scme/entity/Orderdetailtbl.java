package com.scme.entity;

/**
 * Orderdetailtbl entity. @author MyEclipse Persistence Tools
 */

public class Orderdetailtbl implements java.io.Serializable {

	// Fields

	private String detail;
	private Menutbl menutbl;
	private Ordertbl ordertbl;
	private Integer totalNum;
	private Double totalPrice;
	private String detailRemark;

	// Constructors

	/** default constructor */
	public Orderdetailtbl() {
	}

	/** minimal constructor */
	public Orderdetailtbl(String detail) {
		this.detail = detail;
	}

	/** full constructor */
	public Orderdetailtbl(String detail, Menutbl menutbl, Ordertbl ordertbl,
			Integer totalNum, Double totalPrice, String detailRemark) {
		this.detail = detail;
		this.menutbl = menutbl;
		this.ordertbl = ordertbl;
		this.totalNum = totalNum;
		this.totalPrice = totalPrice;
		this.detailRemark = detailRemark;
	}

	// Property accessors

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Menutbl getMenutbl() {
		return this.menutbl;
	}

	public void setMenutbl(Menutbl menutbl) {
		this.menutbl = menutbl;
	}

	public Ordertbl getOrdertbl() {
		return this.ordertbl;
	}

	public void setOrdertbl(Ordertbl ordertbl) {
		this.ordertbl = ordertbl;
	}

	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDetailRemark() {
		return this.detailRemark;
	}

	public void setDetailRemark(String detailRemark) {
		this.detailRemark = detailRemark;
	}

}