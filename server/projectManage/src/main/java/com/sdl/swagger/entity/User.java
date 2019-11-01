package com.sdl.swagger.entity;

import java.io.Serializable;
import java.util.Date;

import com.sdl.swagger.meeting.entity.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {

	@ApiModelProperty(value = "用户Id", name = "userId")
	private int userId;
	private String moid;// moid
	@ApiModelProperty(value = "用户名", name = "name")
	private String name;
	@ApiModelProperty(value = "密码", name = "password")
	private String password;
	@ApiModelProperty(value = "年龄", name = "age")
	private String age;
	@ApiModelProperty(value = "创建时间", name = "create")
	private String createTime;
	@ApiModelProperty(value = "所属部门", name = "deptName")
	private String deptName;


	private String email; // 注册邮箱
	private String e164; // E164号
	private String account; // 用户自定义账号，登陆账号
	private String mobile; // 手机，登陆账号
	private Boolean enable; // 帐号启用禁用标识
	private Boolean isDeleted;// 账号被删除标识
	
	
	public User() {
		super();
	}
	public User(int userId, String name, String password, String age, String create, String deptName) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.createTime = create;
	}

	public static User toUser(UserVO userVO){
		User user = new User();
		user.setAccount(userVO.getAccount());
		user.setPassword(userVO.getPassword());
		user.setDeleted(userVO.getIsDeleted());
		user.setEnable(userVO.getEnable());
		user.setEmail(userVO.getEmail());
		user.setMoid(userVO.getMoid());
		user.setE164(userVO.getE164());
		user.setMobile(userVO.getMobile());
		user.setName(userVO.getName());
		return user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getMoid() {
		return moid;
	}

	public void setMoid(String moid) {
		this.moid = moid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getE164() {
		return e164;
	}

	public void setE164(String e164) {
		this.e164 = e164;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}
}
