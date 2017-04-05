package com.hnrw.entity;

public class ExamPaper4 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 4459161816523672716L;
	private Integer paper4Id;
	private ExamQuestion4 examQuestion4;
	private String paper4Number;
	private Integer paper4Qid;
	private String question4Answer;
	private Integer paper4Choice;

	// Constructors

	/** default constructor */
	public ExamPaper4() {
	}

	/** minimal constructor */
	public ExamPaper4(ExamQuestion4 examQuestion4, String paper4Number, Integer paper4Qid, String question4Answer) {
		this.examQuestion4 = examQuestion4;
		this.paper4Number = paper4Number;
		this.paper4Qid = paper4Qid;
		this.question4Answer = question4Answer;
	}

	/** full constructor */
	public ExamPaper4(ExamQuestion4 examQuestion4, String paper4Number, Integer paper4Qid, String question4Answer,
			Integer paper4Choice) {
		this.examQuestion4 = examQuestion4;
		this.paper4Number = paper4Number;
		this.paper4Qid = paper4Qid;
		this.question4Answer = question4Answer;
		this.paper4Choice = paper4Choice;
	}

	// Property accessors

	public Integer getPaper4Id() {
		return this.paper4Id;
	}

	public void setPaper4Id(Integer paper4Id) {
		this.paper4Id = paper4Id;
	}

	public ExamQuestion4 getExamQuestion4() {
		return this.examQuestion4;
	}

	public void setExamQuestion4(ExamQuestion4 examQuestion4) {
		this.examQuestion4 = examQuestion4;
	}

	public String getPaper4Number() {
		return this.paper4Number;
	}

	public void setPaper4Number(String paper4Number) {
		this.paper4Number = paper4Number;
	}

	public Integer getPaper4Qid() {
		return this.paper4Qid;
	}

	public void setPaper4Qid(Integer paper4Qid) {
		this.paper4Qid = paper4Qid;
	}

	public String getQuestion4Answer() {
		return this.question4Answer;
	}

	public void setQuestion4Answer(String question4Answer) {
		this.question4Answer = question4Answer;
	}

	public Integer getPaper4Choice() {
		return this.paper4Choice;
	}

	public void setPaper4Choice(Integer paper4Choice) {
		this.paper4Choice = paper4Choice;
	}

}