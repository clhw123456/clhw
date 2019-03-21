package com.ssh.code.entity;

/**
 * Dict entity. @author MyEclipse Persistence Tools
 */

public class Dict implements java.io.Serializable {

	// Fields

	private Integer DId;
	private String DName;
	private String DValue;
	private String type;

	// Constructors

	/** default constructor */
	public Dict() {
	}

	public Integer getDId() {
		return DId;
	}

	public void setDId(Integer dId) {
		DId = dId;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getDValue() {
		return DValue;
	}

	public void setDValue(String dValue) {
		DValue = dValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** full constructor */
	

	// Property accessors

	

}