package com.sdl.swagger.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {
	
	@ApiModelProperty(value = "用户Id", name = "userId")
	private int userId;
	@ApiModelProperty(value = "用户名", name = "name")
	private String name;
	@ApiModelProperty(value = "密码", name = "pwd")
	private String pwd;
	@ApiModelProperty(value = "年龄", name = "age")
	private String age;
	@ApiModelProperty(value = "创建时间", name = "create")
	private String create;
	@ApiModelProperty(value = "所属部门", name = "deptName")
	private String deptName;
	
	
	public User() {
		super();
	}
	public User(int userId, String name, String pwd, String age, String create, String deptName) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.create = create;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
