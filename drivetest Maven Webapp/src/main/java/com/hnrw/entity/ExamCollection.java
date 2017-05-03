package com.hnrw.entity;

public class ExamCollection implements java.io.Serializable {

	private static final long serialVersionUID = 3076441817496783359L;
	private Integer collectionId;
	private ExamUser examUser;
	private Integer collectionQid;
	private Integer collectionType;

	// Constructors

	/** default constructor */
	public ExamCollection() {
	}

	/** full constructor */
	public ExamCollection(Integer collectionId, ExamUser examUser,
			Integer collectionQid, Integer collectionType) {
		this.collectionId = collectionId;
		this.examUser = examUser;
		this.collectionQid = collectionQid;
		this.collectionType = collectionType;
	}

	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
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