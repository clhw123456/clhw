package com.ssh.code.entity;

import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	// Fields

	private Integer id;
	private String text;
	private boolean checked;
	
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	private String PUrl;
	
	@JSONField(serialize=false)
	private Privilege parent;
	
	private Set<Privilege> children;
	
	@JSONField(serialize=false)
	private Set<Role> roles;

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** full constructor */
	public Privilege(String text, String pUrl) {
		super();
		this.text = text;
		PUrl = pUrl;
	}

	// Property accessors
	
	public String getPUrl() {
		return this.PUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPUrl(String PUrl) {
		this.PUrl = PUrl;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", text=" + text + ", PUrl=" + PUrl + ", children=" + children + "]";
	}

	
	
	

}