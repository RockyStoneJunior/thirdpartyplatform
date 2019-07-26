package com.fanmo.thirdpartyplatform.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class LoginHistory {
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	
	@Column(name = "branch_name")
	private String branchNname;
	
	@Column(name = "branch_id")
	private Long branchId;
	
	@Column(name = "login_date")
	private Date loginDate;

	@Column(name = "logout_date")
	private Date logoutDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBranchNname() {
		return branchNname;
	}

	public void setBranchNname(String branchNname) {
		this.branchNname = branchNname;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
}
