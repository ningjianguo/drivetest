package com.hnrw.entity;

import java.util.Date;

public class ExamInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -870416719131872121L;
	private Integer infoId;
	private ExamUser examUser;
	private String paperNumber;
	private String infoStartTime;
	private String infoStartEnd;
	private Integer infoScore;
	private Integer infoType;

	// Constructors

	/** default constructor */
	public ExamInfo() {
	}

	/** minimal constructor */
	public ExamInfo(ExamUser examUser, String paperNumber, String infoStartTime,
			Integer infoType) {
		this.examUser = examUser;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoType = infoType;
	}

	/** full constructor */
	public ExamInfo(ExamUser examUser, String paperNumber, String infoStartTime,
			String infoStartEnd, Integer infoScore, Integer infoType) {
		this.examUser = examUser;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoStartEnd = infoStartEnd;
		this.infoScore = infoScore;
		this.infoType = infoType;
	}

	// Property accessors

	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public ExamUser getExamUser() {
		return this.examUser;
	}

	public void setExamUser(ExamUser examUser) {
		this.examUser = examUser;
	}

	public String getPaperNumber() {
		return this.paperNumber;
	}

	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}

	public String getInfoStartTime() {
		return this.infoStartTime;
	}

	public void setInfoStartTime(String infoStartTime) {
		this.infoStartTime = infoStartTime;
	}

	public String getInfoStartEnd() {
		return this.infoStartEnd;
	}

	public void setInfoStartEnd(String infoStartEnd) {
		this.infoStartEnd = infoStartEnd;
	}

	public Integer getInfoScore() {
		return this.infoScore;
	}

	public void setInfoScore(Integer infoScore) {
		this.infoScore = infoScore;
	}

	public Integer getInfoType() {
		return this.infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

}