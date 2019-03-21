package com.ssh.code.entity;

/**
 * Code entity. @author MyEclipse Persistence Tools
 */

public class Code implements java.io.Serializable {

	// Fields

	private Long CId;
	private String CName;
	private String CNum;
	private Dict typeDict;
	private Dict tradeDict;
	private Dict levelDict;
	private Integer CPrice;
	private String downLoad;

	// Constructors

	/** default constructor */
	public Code() {
	}


	// Property accessors

	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCNum() {
		return this.CNum;
	}

	public void setCNum(String CNum) {
		this.CNum = CNum;
	}

	

	public Dict getTypeDict() {
		return typeDict;
	}


	public void setTypeDict(Dict typeDict) {
		this.typeDict = typeDict;
	}


	public Dict getTradeDict() {
		return tradeDict;
	}


	public void setTradeDict(Dict tradeDict) {
		this.tradeDict = tradeDict;
	}


	public Dict getLevelDict() {
		return levelDict;
	}


	public void setLevelDict(Dict levelDict) {
		this.levelDict = levelDict;
	}


	public Integer getCPrice() {
		return this.CPrice;
	}

	public void setCPrice(Integer CPrice) {
		this.CPrice = CPrice;
	}

	public String getDownLoad() {
		return this.downLoad;
	}

	public void setDownLoad(String downLoad) {
		this.downLoad = downLoad;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Code [CId=" + CId + ", CName=" + CName + ", CNum=" + CNum + ", typeDict=" + typeDict + ", tradeDict="
				+ tradeDict + ", levelDict=" + levelDict + ", CPrice=" + CPrice + ", downLoad=" + downLoad + "]";
	}


	
	

}