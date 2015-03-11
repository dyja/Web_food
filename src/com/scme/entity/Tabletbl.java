package com.scme.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tabletbl entity. @author MyEclipse Persistence Tools
 */

public class Tabletbl implements java.io.Serializable {

	// Fields

	private String tableId;
	private String tableNum;
	private String flag;
	private String description;
	private Set ordertbls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tabletbl() {
	}

	/** minimal constructor */
	public Tabletbl(String tableId) {
		this.tableId = tableId;
	}

	/** full constructor */
	public Tabletbl(String tableId, String tableNum, String flag,
			String description, Set ordertbls) {
		this.tableId = tableId;
		this.tableNum = tableNum;
		this.flag = flag;
		this.description = description;
		this.ordertbls = ordertbls;
	}

	// Property accessors

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getOrdertbls() {
		return this.ordertbls;
	}

	public void setOrdertbls(Set ordertbls) {
		this.ordertbls = ordertbls;
	}

}