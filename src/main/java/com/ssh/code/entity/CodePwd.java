package com.ssh.code.entity;

/**
 * CodePwd entity. @author MyEclipse Persistence Tools
 */

public class CodePwd implements java.io.Serializable {

	// Fields
	private Integer cpId;
	private String codeNum;
	private String codePwd;

	// Constructors

	/** default constructor */
	public CodePwd() {
	}

	/** full constructor */
	public CodePwd(String codePwd) {
		this.codePwd = codePwd;
	}

	// Property accessors
	
    

	public String getCodePwd() {
		return this.codePwd;
	}

	/**
	 * @return the cpId
	 */
	public Integer getCpId() {
		return cpId;
	}

	/**
	 * @param cpId the cpId to set
	 */
	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	/**
	 * @return the codeNum
	 */
	public String getCodeNum() {
		return codeNum;
	}

	/**
	 * @param codeNum the codeNum to set
	 */
	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}

	/**
	 * @param codePwd the codePwd to set
	 */
	public void setCodePwd(String codePwd) {
		this.codePwd = codePwd;
	}

	

}