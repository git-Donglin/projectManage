/**
 * @author sundonglin
 * @date 2018年9月13日 上午10:02:43
 */
package com.sdl.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sundonglin
 * @date 2018年9月13日 上午10:02:43
 */
@ApiModel(value = "部门信息（Dept）", description = "部门信息")
public class Dept {
	@ApiModelProperty(name = "id", value = "部门id")
	private Integer id;
	@ApiModelProperty(name = "name", value = "部门名称")
	private String name;
	
	
	
	public Dept() {
		super();
	}

	public Dept(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void toDept(Dept dept) {
		this.id = dept.getId();
		this.name = dept.name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
