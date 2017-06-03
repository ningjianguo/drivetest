package com.hnrw.entity;

public class ExamPaper1 implements java.io.Serializable {

	private static final long serialVersionUID = 8146756585374336320L;
	private String paper1Id;
	private ExamQuestion1 examQuestion1;
	private Integer paper1No;
	private String paper1Number;
	private String question1Answer;
	private Integer paper1Choice;

	// Constructors

	/** default constructor */
	public ExamPaper1() {
	}

	/** minimal constructor */
	public ExamPaper1(String paper1Id, ExamQuestion1 examQuestion1,
			Integer paper1No, String paper1Number,
			String question1Answer) {
		this.paper1Id = paper1Id;
		this.examQuestion1 = examQuestion1;
		this.paper1No = paper1No;
		this.paper1Number = paper1Number;
		this.question1Answer = question1Answer;
	}

	/** full constructor */
	public ExamPaper1(String paper1Id, ExamQuestion1 examQuestion1,
			Integer paper1No, String paper1Number,
			String question1Answer, Integer paper1Choice) {
		this.paper1Id = paper1Id;
		this.examQuestion1 = examQuestion1;
		this.paper1No = paper1No;
		this.paper1Number = paper1Number;
		this.question1Answer = question1Answer;
		this.paper1Choice = paper1Choice;
	}

	// Property accessors

	public String getPaper1Id() {
		return this.paper1Id;
	}

	public void setPaper1Id(String paper1Id) {
		this.paper1Id = paper1Id;
	}

	public ExamQuestion1 getExamQuestion1() {
		return this.examQuestion1;
	}

	public void setExamQuestion1(ExamQuestion1 examQuestion1) {
		this.examQuestion1 = examQuestion1;
	}

	public Integer getPaper1No() {
		return this.paper1No;
	}

	public void setPaper1No(Integer paper1No) {
		this.paper1No = paper1No;
	}

	public String getPaper1Number() {
		return this.paper1Number;
	}

	public void setPaper1Number(String paper1Number) {
		this.paper1Number = paper1Number;
	}

	public String getQuestion1Answer() {
		return this.question1Answer;
	}

	public void setQuestion1Answer(String question1Answer) {
		this.question1Answer = question1Answer;
	}

	public Integer getPaper1Choice() {
		return this.paper1Choice;
	}

	public void setPaper1Choice(Integer paper1Choice) {
		this.paper1Choice = paper1Choice;
	}

}