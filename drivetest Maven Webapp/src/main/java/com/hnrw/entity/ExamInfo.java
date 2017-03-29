package com.hnrw.entity;


public class ExamInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -870416719131872121L;
	private Integer infoId;
	private ExamUser examUser;
	private String paperNumber;
	private String infoStartTime;
	private String infoEndTime;
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
			String infoEndTime, Integer infoScore, Integer infoType) {
		this.examUser = examUser;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoEndTime = infoEndTime;
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

	public String getInfoEndTime() {
		return infoEndTime;
	}

	public void setInfoEndTime(String infoEndTime) {
		this.infoEndTime = infoEndTime;
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