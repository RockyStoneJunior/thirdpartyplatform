package com.fanmo.thirdpartyplatform.persistence.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "Account" ,description="B端药师账号")
@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value="B端用户账号，由注册页面注册")
	private String username;

	@ApiModelProperty(value="B端用户密码，由注册页面注册")
 	private String password;

	@ApiModelProperty(value="B端用户手机")
	private String mobile;
	
	//long branch_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date date;

	@ApiModelProperty(value="公众号，小程序或者账号")
	private String name;

	@ApiModelProperty(value="B端用户推码，6位数字", example = "123456")
	private String code;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public long getBranch_id() {
//		return branch_id;
//	}
//
//	public void setBranch_id(long branch_id) {
//		this.branch_id = branch_id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
