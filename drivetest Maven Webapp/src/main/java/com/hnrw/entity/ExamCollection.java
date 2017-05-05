package com.hnrw.entity;

public class ExamCollection implements java.io.Serializable {

	private static final long serialVersionUID = 4723991617724312222L;
	private String collectionId;
	private ExamUser examUser;
	private Integer collectionQid;
	private Integer collectionType;

	// Constructors

	/** default constructor */
	public ExamCollection() {
	}

	/** full constructor */
	public ExamCollection(String collectionId, ExamUser examUser,
			Integer collectionQid, Integer collectionType) {
		this.collectionId = collectionId;
		this.examUser = examUser;
		this.collectionQid = collectionQid;
		this.collectionType = collectionType;
	}

	// Property accessors

	public String getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public ExamUser getExamUser() {
		return this.examUser;
	}

	public void setExamUser(ExamUser examUser) {
		this.examUser = examUser;
	}

	public Integer getCollectionQid() {
		return this.collectionQid;
	}

	public void setCollectionQid(Integer collectionQid) {
		this.collectionQid = collectionQid;
	}

	public Integer getCollectionType() {
		return this.collectionType;
	}

	public void setCollectionType(Integer collectionType) {
		this.collectionType = collectionType;
	}

}