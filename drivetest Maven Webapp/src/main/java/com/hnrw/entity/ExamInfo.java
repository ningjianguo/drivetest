package com.hnrw.entity;

public class ExamInfo implements java.io.Serializable {

	private static final long serialVersionUID = 73672985671647157L;
	private String infoId;
	private ExamUser examUser;
	private Integer infoNo;
	private String paperNumber;
	private String infoStartTime;
	private String infoEndTime;
	private Integer infoScore;
	private Integer infoType;
	private String infoStartEnd;

	// Constructors

	/** default constructor */
	public ExamInfo() {
	}

	/** minimal constructor */
	public ExamInfo(String infoId, ExamUser examUser, Integer infoNo,
			String paperNumber, String infoStartTime, Integer infoType) {
		this.infoId = infoId;
		this.examUser = examUser;
		this.infoNo = infoNo;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoType = infoType;
	}

	/** full constructor */
	public ExamInfo(String infoId, ExamUser examUser, Integer infoNo,
			String paperNumber, String infoStartTime, String infoEndTime,
			Integer infoScore, Integer infoType, String infoStartEnd) {
		this.infoId = infoId;
		this.examUser = examUser;
		this.infoNo = infoNo;
		this.paperNumber = paperNumber;
		this.infoStartTime = infoStartTime;
		this.infoEndTime = infoEndTime;
		this.infoScore = infoScore;
		this.infoType = infoType;
		this.infoStartEnd = infoStartEnd;
	}

	// Property accessors

	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public ExamUser getExamUser() {
		return this.examUser;
	}

	public void setExamUser(ExamUser examUser) {
		this.examUser = examUser;
	}

	public Integer getInfoNo() {
		return this.infoNo;
	}

	public void setInfoNo(Integer infoNo) {
		this.infoNo = infoNo;
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
		return this.infoEndTime;
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

	public String getInfoStartEnd() {
		return this.infoStartEnd;
	}

	public void setInfoStartEnd(String infoStartEnd) {
		this.infoStartEnd = infoStartEnd;
	}

}