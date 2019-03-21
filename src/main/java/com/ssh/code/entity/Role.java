package com.ssh.code.entity;

import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer RId;
	private String RName;
	
	@JSONField(serialize=false)
	private Set<Privilege> privileges;

	// Constructors

	/** default constructor */
	public Role() {
	}
	
	

	public Role(Integer rId) {
		super();
		RId = rId;
	}

	/** full constructor */
	public Role(String RName) {
		this.RName = RName;
	}

	// Property accessors

	public Integer getRId() {
		return this.RId;
	}

	public void setRId(Integer RId) {
		this.RId = RId;
	}

	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}
	
	

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}