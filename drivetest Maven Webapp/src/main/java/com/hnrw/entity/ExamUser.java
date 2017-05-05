package com.hnrw.entity;

import java.util.HashSet;
import java.util.Set;

public class ExamUser implements java.io.Serializable {

	private static final long serialVersionUID = 672813022472652081L;
	private String userId;
	private String userAccountName;
	private String userAccountPassword;
	private String userRole;
	private String userName;
	private String userEmail;
	private Set examCollections = new HashSet(0);
	private Set examInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamUser() {
	}

	/** minimal constructor */
	public ExamUser(String userId, String userAccountName,
			String userAccountPassword, String userRole) {
		this.userId = userId;
		this.userAccountName = userAccountName;
		this.userAccountPassword = userAccountPassword;
		this.userRole = userRole;
	}

	/** full constructor */
	public ExamUser(String userId, String userAccountName,
			String userAccountPassword, String userRole, String userName,
			String userEmail, Set examCollections, Set examInfos) {
		this.userId = userId;
		this.userAccountName = userAccountName;
		this.userAccountPassword = userAccountPassword;
		this.userRole = userRole;
		this.userName = userName;
		this.userEmail = userEmail;
		this.examCollections = examCollections;
		this.examInfos = examInfos;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAccountName() {
		return this.userAccountName;
	}

	public void setUserAccountName(String userAccountName) {
		this.userAccountName = userAccountName;
	}

	public String getUserAccountPassword() {
		return this.userAccountPassword;
	}

	public void setUserAccountPassword(String userAccountPassword) {
		this.userAccountPassword = userAccountPassword;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set getExamCollections() {
		return this.examCollections;
	}

	public void setExamCollections(Set examCollections) {
		this.examCollections = examCollections;
	}

	public Set getExamInfos() {
		return this.examInfos;
	}

	public void setExamInfos(Set examInfos) {
		this.examInfos = examInfos;
	}

}