package com.hnrw.entity;

public class ExaminationUser implements java.io.Serializable {

	private static final long serialVersionUID = -8185814703255108214L;
	
	private Integer userId;
	private String userAccountName;
	private String userAccountPassword;
	private String userRole;
	private String userName;
	private String userEmail;

	// Constructors

	/** default constructor */
	public ExaminationUser() {
	}

	/** minimal constructor */
	public ExaminationUser(Integer userId, String userAccountName,
			String userAccountPassword, String userRole) {
		this.userId = userId;
		this.userAccountName = userAccountName;
		this.userAccountPassword = userAccountPassword;
		this.userRole = userRole;
	}

	/** full constructor */
	public ExaminationUser(Integer userId, String userAccountName,
			String userAccountPassword, String userRole, String userName,
			String userEmail) {
		this.userId = userId;
		this.userAccountName = userAccountName;
		this.userAccountPassword = userAccountPassword;
		this.userRole = userRole;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
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

}