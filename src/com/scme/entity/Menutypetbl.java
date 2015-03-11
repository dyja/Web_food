package com.scme.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menutypetbl entity. @author MyEclipse Persistence Tools
 */

public class Menutypetbl implements java.io.Serializable {

	// Fields

	private String menuTypeId;
	private String menuType;
	private Set menutbls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menutypetbl() {
	}

	/** minimal constructor */
	public Menutypetbl(String menuTypeId) {
		this.menuTypeId = menuTypeId;
	}

	/** full constructor */
	public Menutypetbl(String menuTypeId, String menuType, Set menutbls) {
		this.menuTypeId = menuTypeId;
		this.menuType = menuType;
		this.menutbls = menutbls;
	}

	// Property accessors

	public String getMenuTypeId() {
		return this.menuTypeId;
	}

	public void setMenuTypeId(String menuTypeId) {
		this.menuTypeId = menuTypeId;
	}

	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Set getMenutbls() {
		return this.menutbls;
	}

	public void setMenutbls(Set menutbls) {
		this.menutbls = menutbls;
	}

}