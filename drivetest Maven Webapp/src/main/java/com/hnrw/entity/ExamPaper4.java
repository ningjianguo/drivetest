package com.hnrw.entity;

public class ExamPaper4 implements java.io.Serializable {

	private static final long serialVersionUID = 4862080331836183165L;
	private String paper4Id;
	private ExamQuestion4 examQuestion4;
	private Integer paper4No;
	private String paper4Number;
	private String question4Answer;
	private Integer paper4Choice;

	// Constructors

	/** default constructor */
	public ExamPaper4() {
	}

	/** minimal constructor */
	public ExamPaper4(String paper4Id, ExamQuestion4 examQuestion4,
			Integer paper4No, String paper4Number,
			String question4Answer) {
		this.paper4Id = paper4Id;
		this.examQuestion4 = examQuestion4;
		this.paper4No = paper4No;
		this.paper4Number = paper4Number;
		this.question4Answer = question4Answer;
	}

	/** full constructor */
	public ExamPaper4(String paper4Id, ExamQuestion4 examQuestion4,
			Integer paper4No, String paper4Number,
			String question4Answer, Integer paper4Choice) {
		this.paper4Id = paper4Id;
		this.examQuestion4 = examQuestion4;
		this.paper4No = paper4No;
		this.paper4Number = paper4Number;
		this.question4Answer = question4Answer;
		this.paper4Choice = paper4Choice;
	}

	// Property accessors

	public String getPaper4Id() {
		return this.paper4Id;
	}

	public void setPaper4Id(String paper4Id) {
		this.paper4Id = paper4Id;
	}

	public ExamQuestion4 getExamQuestion4() {
		return this.examQuestion4;
	}

	public void setExamQuestion4(ExamQuestion4 examQuestion4) {
		this.examQuestion4 = examQuestion4;
	}

	public Integer getPaper4No() {
		return this.paper4No;
	}

	public void setPaper4No(Integer paper4No) {
		this.paper4No = paper4No;
	}

	public String getPaper4Number() {
		return this.paper4Number;
	}

	public void setPaper4Number(String paper4Number) {
		this.paper4Number = paper4Number;
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