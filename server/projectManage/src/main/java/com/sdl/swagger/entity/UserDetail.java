package com.sdl.swagger.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDetail", description = "用户信息", parent = User.class)
public class UserDetail extends User implements Serializable{
	
	@ApiModelProperty(value = "地址", name = "address", example="宝山")
	private String address;
	@ApiModelProperty(value = "电话", name = "phone", example = "123456789")
	private String phone;
	@ApiModelProperty(value = "邮箱", name = "email", example = "123456@qq.com")
	private String email;
	
	
	public UserDetail() {
		super();
	}


	public UserDetail(int userId, String name, String age, String pwd, String address, 
			String phone, String email, String date, String deptName,String moid) {
		super();
		this.setUserId(userId);
		this.setName(name);
		this.setAge(age);
		this.setPassword(pwd);
		this.setCreateTime(date);
		this.setDeptName(deptName);
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.setMoid(moid);
	}
	
	/**
	 * 使用指定对象的值更新本身对应属性的null值
	 * @param bean
	 * @throws Exception
	 */
	public UserDetail updateNullFromBean(UserDetail bean) {
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			if (fields != null) {
				for (Field field : fields) {
					if (field.get(this) == null) {
						field.set(this, field.get(bean));
					}
				}
			}
		} catch (Exception e) {
		}
		return this;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	
	
}
