package com.scme.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Ordertbl entity. @author MyEclipse Persistence Tools
 */

public class Ordertbl implements java.io.Serializable {

	// Fields

	private String orderId;
	private Usertbl usertbl;
	private Tabletbl tabletbl;
	private String orderTime;
	private Integer personNum;
	private String isPlay;
	private String orderRemark;
	private Set orderdetailtbls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ordertbl() {
	}

	/** minimal constructor */
	public Ordertbl(String orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public Ordertbl(String orderId, Usertbl usertbl, Tabletbl tabletbl,
			String orderTime, Integer personNum, String isPlay,
			String orderRemark, Set orderdetailtbls) {
		this.orderId = orderId;
		this.usertbl = usertbl;
		this.tabletbl = tabletbl;
		this.orderTime = orderTime;
		this.personNum = personNum;
		this.isPlay = isPlay;
		this.orderRemark = orderRemark;
		this.orderdetailtbls = orderdetailtbls;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Usertbl getUsertbl() {
		return this.usertbl;
	}

	public void setUsertbl(Usertbl usertbl) {
		this.usertbl = usertbl;
	}

	public Tabletbl getTabletbl() {
		return this.tabletbl;
	}

	public void setTabletbl(Tabletbl tabletbl) {
		this.tabletbl = tabletbl;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	public String getIsPlay() {
		return this.isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}

	public String getOrderRemark() {
		return this.orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Set getOrderdetailtbls() {
		return this.orderdetailtbls;
	}

	public void setOrderdetailtbls(Set orderdetailtbls) {
		this.orderdetailtbls = orderdetailtbls;
	}

}