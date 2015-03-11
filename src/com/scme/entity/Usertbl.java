package com.scme.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Usertbl entity. @author MyEclipse Persistence Tools
 */

public class Usertbl implements java.io.Serializable {

	// Fields

	private String userId;
	private String account;
	private String password;
	private String userName;
	private String sex;
	private String pemission;
	private String remark;
	private Set ordertbls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usertbl() {
	}

	/** minimal constructor */
	public Usertbl(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Usertbl(String userId, String account, String password,
			String userName, String sex, String pemission, String remark,
			Set ordertbls) {
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.userName = userName;
		this.sex = sex;
		this.pemission = pemission;
		this.remark = remark;
		this.ordertbls = ordertbls;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPemission() {
		return this.pemission;
	}

	public void setPemission(String pemission) {
		this.pemission = pemission;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getOrdertbls() {
		return this.ordertbls;
	}

	public void setOrdertbls(Set ordertbls) {
		this.ordertbls = ordertbls;
	}

}