package com.hnrw.entity;

import java.util.HashSet;
import java.util.Set;

public class ExamQuestion4 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7829352201109736186L;
	private Integer question4Id;
	private String question4Question;
	private String question4Answer;
	private String question4Item1;
	private String question4Item2;
	private String question4Item3;
	private String question4Item4;
	private String question4Explains;
	private String question4Url;
	private Set examPaper4s = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamQuestion4() {
	}

	/** minimal constructor */
	public ExamQuestion4(String question4Question, String question4Answer, String question4Item1, String question4Item2,
			String question4Explains) {
		this.question4Question = question4Question;
		this.question4Answer = question4Answer;
		this.question4Item1 = question4Item1;
		this.question4Item2 = question4Item2;
		this.question4Explains = question4Explains;
	}

	/** full constructor */
	public ExamQuestion4(String question4Question, String question4Answer, String question4Item1, String question4Item2,
			String question4Item3, String question4Item4, String question4Explains, String question4Url,
			Set examPaper4s) {
		this.question4Question = question4Question;
		this.question4Answer = question4Answer;
		this.question4Item1 = question4Item1;
		this.question4Item2 = question4Item2;
		this.question4Item3 = question4Item3;
		this.question4Item4 = question4Item4;
		this.question4Explains = question4Explains;
		this.question4Url = question4Url;
		this.examPaper4s = examPaper4s;
	}

	// Property accessors

	public Integer getQuestion4Id() {
		return this.question4Id;
	}

	public void setQuestion4Id(Integer question4Id) {
		this.question4Id = question4Id;
	}

	public String getQuestion4Question() {
		return this.question4Question;
	}

	public void setQuestion4Question(String question4Question) {
		this.question4Question = question4Question;
	}

	public String getQuestion4Answer() {
		return this.question4Answer;
	}

	public void setQuestion4Answer(String question4Answer) {
		this.question4Answer = question4Answer;
	}

	public String getQuestion4Item1() {
		return this.question4Item1;
	}

	public void setQuestion4Item1(String question4Item1) {
		this.question4Item1 = question4Item1;
	}

	public String getQuestion4Item2() {
		return this.question4Item2;
	}

	public void setQuestion4Item2(String question4Item2) {
		this.question4Item2 = question4Item2;
	}

	public String getQuestion4Item3() {
		return this.question4Item3;
	}

	public void setQuestion4Item3(String question4Item3) {
		this.question4Item3 = question4Item3;
	}

	public String getQuestion4Item4() {
		return this.question4Item4;
	}

	public void setQuestion4Item4(String question4Item4) {
		this.question4Item4 = question4Item4;
	}

	public String getQuestion4Explains() {
		return this.question4Explains;
	}

	public void setQuestion4Explains(String question4Explains) {
		this.question4Explains = question4Explains;
	}

	public String getQuestion4Url() {
		return this.question4Url;
	}

	public void setQuestion4Url(String question4Url) {
		this.question4Url = question4Url;
	}

	public Set getExamPaper4s() {
		return this.examPaper4s;
	}

	public void setExamPaper4s(Set examPaper4s) {
		this.examPaper4s = examPaper4s;
	}

}