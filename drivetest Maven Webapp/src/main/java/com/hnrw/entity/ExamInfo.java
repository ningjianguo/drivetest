package com.hnrw.entity;

import java.util.Date;


public class ExamInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1943460621287755109L;
	private Integer infoId;
	private ExamUser examUser;
	private String paperNumber;
	private Date infoStartTime;
	private Date infoStartEnd;
	private Integer infoScore;

	// Constructors

	/** default constructor */
	public ExamInfo() {
	}

	/** full constructor */
	public ExamInfo(ExamUser examUser, String paperNumber, Date infoStartTime,
			Date infoStartEnd, Integer infoScore) {
		this.examUser = examUser;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoStartEnd = infoStartEnd;
		this.infoScore = infoScore;
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

	public Date getInfoStartTime() {
		return this.infoStartTime;
	}

	public void setInfoStartTime(Date infoStartTime) {
		this.infoStartTime = infoStartTime;
	}

	public Date getInfoStartEnd() {
		return this.infoStartEnd;
	}

	public void setInfoStartEnd(Date infoStartEnd) {
		this.infoStartEnd = infoStartEnd;
	}

	public Integer getInfoScore() {
		return this.infoScore;
	}

	public void setInfoScore(Integer infoScore) {
		this.infoScore = infoScore;
	}

}