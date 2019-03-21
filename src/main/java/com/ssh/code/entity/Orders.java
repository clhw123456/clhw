package com.ssh.code.entity;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Long OId;
	private String OCode;
	private Integer OPrice;
	private String OQq;
	private String OEmail;
	private String OName;
	private Integer OPay;
	private Integer OUnpay;
	private Integer OStatus;
	private Boolean sendCode;
	private Boolean sendPaper;
	private Boolean needPaper;
	private Integer pushId;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(String OCode, Integer OPrice, String OQq, String OEmail,
			String OName, Integer OPay, Integer OUnpay, Integer OStatus,
			Boolean sendCode, Boolean sendPaper, Boolean needPaper,
			Integer pushId) {
		this.OCode = OCode;
		this.OPrice = OPrice;
		this.OQq = OQq;
		this.OEmail = OEmail;
		this.OName = OName;
		this.OPay = OPay;
		this.OUnpay = OUnpay;
		this.OStatus = OStatus;
		this.sendCode = sendCode;
		this.sendPaper = sendPaper;
		this.needPaper = needPaper;
		this.pushId = pushId;
	}

	// Property accessors

	public Long getOId() {
		return this.OId;
	}

	public void setOId(Long OId) {
		this.OId = OId;
	}

	public String getOCode() {
		return this.OCode;
	}

	public void setOCode(String OCode) {
		this.OCode = OCode;
	}

	public Integer getOPrice() {
		return this.OPrice;
	}

	public void setOPrice(Integer OPrice) {
		this.OPrice = OPrice;
	}

	public String getOQq() {
		return this.OQq;
	}

	public void setOQq(String OQq) {
		this.OQq = OQq;
	}

	public String getOEmail() {
		return this.OEmail;
	}

	public void setOEmail(String OEmail) {
		this.OEmail = OEmail;
	}

	public String getOName() {
		return this.OName;
	}

	public void setOName(String OName) {
		this.OName = OName;
	}

	public Integer getOPay() {
		return this.OPay;
	}

	public void setOPay(Integer OPay) {
		this.OPay = OPay;
	}

	public Integer getOUnpay() {
		return this.OUnpay;
	}

	public void setOUnpay(Integer OUnpay) {
		this.OUnpay = OUnpay;
	}

	public Integer getOStatus() {
		return this.OStatus;
	}

	public void setOStatus(Integer OStatus) {
		this.OStatus = OStatus;
	}

	public Boolean getSendCode() {
		return this.sendCode;
	}

	public void setSendCode(Boolean sendCode) {
		this.sendCode = sendCode;
	}

	public Boolean getSendPaper() {
		return this.sendPaper;
	}

	public void setSendPaper(Boolean sendPaper) {
		this.sendPaper = sendPaper;
	}

	public Boolean getNeedPaper() {
		return this.needPaper;
	}

	public void setNeedPaper(Boolean needPaper) {
		this.needPaper = needPaper;
	}

	public Integer getPushId() {
		return this.pushId;
	}

	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

}