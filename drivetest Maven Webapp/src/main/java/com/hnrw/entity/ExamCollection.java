package com.hnrw.entity;

public class ExamCollection implements java.io.Serializable {

	private static final long serialVersionUID = 4723991617724312222L;
	private String collectionId;
	private ExamUser examUser;
	private String collectionQid;
	// Constructors

	/** default constructor */
	public ExamCollection() {
	}

	/** full constructor */
	public ExamCollection(String collectionId, ExamUser examUser,
			String collectionQid) {
		this.collectionId = collectionId;
		this.examUser = examUser;
		this.collectionQid = collectionQid;
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

	public String getCollectionQid() {
		return this.collectionQid;
	}

	public void setCollectionQid(String collectionQid) {
		this.collectionQid = collectionQid;
	}

}