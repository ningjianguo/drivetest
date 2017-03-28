package com.hnrw.entity;

public class ExamPaper1 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6958401068092056670L;
	private Integer paper1Id;
	private ExamQuestion1 examQuestion1;
	private String paper1Number;
	private String question1Answer;
	private Integer paper1Qid;
	private Integer paper1Choice;

	// Constructors

	/** default constructor */
	public ExamPaper1() {
	}

	/** minimal constructor */
	public ExamPaper1(ExamQuestion1 examQuestion1, String paper1Number,
			String question1Answer) {
		this.examQuestion1 = examQuestion1;
		this.paper1Number = paper1Number;
		this.question1Answer = question1Answer;
	}

	/** full constructor */
	public ExamPaper1(ExamQuestion1 examQuestion1, String paper1Number,
			String question1Answer, Integer paper1Choice,Integer paper1Qid) {
		this.examQuestion1 = examQuestion1;
		this.paper1Number = paper1Number;
		this.question1Answer = question1Answer;
		this.paper1Choice = paper1Choice;
		this.paper1Qid = paper1Qid;
	}

	// Property accessors

	public Integer getPaper1Id() {
		return this.paper1Id;
	}

	public void setPaper1Id(Integer paper1Id) {
		this.paper1Id = paper1Id;
	}

	public ExamQuestion1 getExamQuestion1() {
		return this.examQuestion1;
	}

	public void setExamQuestion1(ExamQuestion1 examQuestion1) {
		this.examQuestion1 = examQuestion1;
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

	public Integer getPaper1Qid() {
		return paper1Qid;
	}

	public void setPaper1Qid(Integer paper1Qid) {
		this.paper1Qid = paper1Qid;
	}
	
}