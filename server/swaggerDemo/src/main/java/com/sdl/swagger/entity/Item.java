/**
 * @author sundonglin
 * @date 2019年6月10日 上午11:11:33
 */
package com.sdl.swagger.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sundonglin
 * @date 2019年6月10日 上午11:11:33
 */
@ApiModel(value = "项目信息（Item）", description = "项目信息")
public class Item implements Serializable{
	
	@ApiModelProperty(value = "项目Id", name = "id")
	private Integer id;
	@ApiModelProperty(value = "项目moid", name = "moid")
	private String moid;
	@ApiModelProperty(value = "项目状态", name = "state")
	private Integer state;
	@ApiModelProperty(value = "项目名称", name = "name")
	private String name;
	@ApiModelProperty(value = "项目地址", name = "address")
	private String address;
	@ApiModelProperty(value = "项目周期", name = "period")
	private Integer period;
	/*@ApiModelProperty(value = "项目波及", name = "affect")
	private String affect;*/
	@ApiModelProperty(value = "项目负责人", name = "principal")
	private String principal;
	@ApiModelProperty(value = "项目完成内容", name = "content")
	private String content;
	@ApiModelProperty(value = "项目描述", name = "describe")
	private String describe;
	@ApiModelProperty(value = "创建时间", name = "createTime")
	private Date createTime;
	@ApiModelProperty(value = "项目版本", name = "version")
	private String version;
	@ApiModelProperty(value = "功能信息", name = "functions")
	private List<Function> functions = new ArrayList<Function>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMoid() {
		return moid;
	}
	public void setMoid(String moid) {
		this.moid = moid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	

}
