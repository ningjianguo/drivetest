package com.hnrw.entity;

import java.util.HashSet;
import java.util.Set;


public class ExamQuestion1 implements java.io.Serializable {

	private static final long serialVersionUID = 5762725504786767177L;
	// Fields

	private Integer question1Id;
	private String question1Question;
	private String question1Answer;
	private String question1Item1;
	private String question1Item2;
	private String question1Item3;
	private String question1Item4;
	private String question1Explains;
	private String question1Url;
	private Set examPaper1s = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamQuestion1() {
	}

	/** minimal constructor */
	public ExamQuestion1(String question1Question, String question1Answer,
			String question1Item1, String question1Item2,
			String question1Explains) {
		this.question1Question = question1Question;
		this.question1Answer = question1Answer;
		this.question1Item1 = question1Item1;
		this.question1Item2 = question1Item2;
		this.question1Explains = question1Explains;
	}

	/** full constructor */
	public ExamQuestion1(String question1Question, String question1Answer,
			String question1Item1, String question1Item2,
			String question1Item3, String question1Item4,
			String question1Explains, String question1Url, Set examPaper1s) {
		this.question1Question = question1Question;
		this.question1Answer = question1Answer;
		this.question1Item1 = question1Item1;
		this.question1Item2 = question1Item2;
		this.question1Item3 = question1Item3;
		this.question1Item4 = question1Item4;
		this.question1Explains = question1Explains;
		this.question1Url = question1Url;
		this.examPaper1s = examPaper1s;
	}

	// Property accessors

	public Integer getQuestion1Id() {
		return this.question1Id;
	}

	public void setQuestion1Id(Integer question1Id) {
		this.question1Id = question1Id;
	}

	public String getQuestion1Question() {
		return this.question1Question;
	}

	public void setQuestion1Question(String question1Question) {
		this.question1Question = question1Question;
	}

	public String getQuestion1Answer() {
		return this.question1Answer;
	}

	public void setQuestion1Answer(String question1Answer) {
		this.question1Answer = question1Answer;
	}

	public String getQuestion1Item1() {
		return this.question1Item1;
	}

	public void setQuestion1Item1(String question1Item1) {
		this.question1Item1 = question1Item1;
	}

	public String getQuestion1Item2() {
		return this.question1Item2;
	}

	public void setQuestion1Item2(String question1Item2) {
		this.question1Item2 = question1Item2;
	}

	public String getQuestion1Item3() {
		return this.question1Item3;
	}

	public void setQuestion1Item3(String question1Item3) {
		this.question1Item3 = question1Item3;
	}

	public String getQuestion1Item4() {
		return this.question1Item4;
	}

	public void setQuestion1Item4(String question1Item4) {
		this.question1Item4 = question1Item4;
	}

	public String getQuestion1Explains() {
		return this.question1Explains;
	}

	public void setQuestion1Explains(String question1Explains) {
		this.question1Explains = question1Explains;
	}

	public String getQuestion1Url() {
		return this.question1Url;
	}

	public void setQuestion1Url(String question1Url) {
		this.question1Url = question1Url;
	}

	public Set getExamPaper1s() {
		return this.examPaper1s;
	}

	public void setExamPaper1s(Set examPaper1s) {
		this.examPaper1s = examPaper1s;
	}

}