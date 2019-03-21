package com.ssh.code.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer UId;
	private String UName;
	private String UPwd;
	private Integer superMan;
	private Integer status;
	
	
	
	public Integer getSuperMan() {
		return superMan;
	}

	public void setSuperMan(Integer superMan) {
		this.superMan = superMan;
	}

	public User(Integer uId, String uName, Integer status, Integer rId, String rName) {
		super();
		UId = uId;
		UName = uName;
		this.status = status;
		
		role = new Role();
		
		role.setRId(rId);
		
		role.setRName(rName);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Role role;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String UName, String UPwd, Role role) {
		this.UName = UName;
		this.UPwd = UPwd;
		this.role = role;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [UId=" + UId + ", UName=" + UName + ", UPwd=" + UPwd + "]";
	}
	
	

}