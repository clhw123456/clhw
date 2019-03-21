package com.ssh.code.entity;

import java.util.Date;

/**
 * PaperOrder entity. @author MyEclipse Persistence Tools
 */

public class PaperOrder implements java.io.Serializable {

	// Fields

	private Long PId;
	private Integer PNum;
	private String PTitle;
	private String PDescription;
	private String ktbgFile;
	private Boolean sendPaper;
	private Date paperTime;
	private Long OId;

	// Constructors

	/** default constructor */
	public PaperOrder() {
	}

	/** full constructor */
	public PaperOrder(Integer PNum, String PTitle, String PDescription,
			String ktbgFile, Boolean sendPaper, Date paperTime, Long OId) {
		this.PNum = PNum;
		this.PTitle = PTitle;
		this.PDescription = PDescription;
		this.ktbgFile = ktbgFile;
		this.sendPaper = sendPaper;
		this.paperTime = paperTime;
		this.OId = OId;
	}

	// Property accessors

	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	public Integer getPNum() {
		return this.PNum;
	}

	public void setPNum(Integer PNum) {
		this.PNum = PNum;
	}

	public String getPTitle() {
		return this.PTitle;
	}

	public void setPTitle(String PTitle) {
		this.PTitle = PTitle;
	}

	public String getPDescription() {
		return this.PDescription;
	}

	public void setPDescription(String PDescription) {
		this.PDescription = PDescription;
	}

	public String getKtbgFile() {
		return this.ktbgFile;
	}

	public void setKtbgFile(String ktbgFile) {
		this.ktbgFile = ktbgFile;
	}

	public Boolean getSendPaper() {
		return this.sendPaper;
	}

	public void setSendPaper(Boolean sendPaper) {
		this.sendPaper = sendPaper;
	}

	public Date getPaperTime() {
		return this.paperTime;
	}

	public void setPaperTime(Date paperTime) {
		this.paperTime = paperTime;
	}

	public Long getOId() {
		return this.OId;
	}

	public void setOId(Long OId) {
		this.OId = OId;
	}

}