/**
 * @author sundonglin
 * @date 2019年6月10日 上午11:11:33
 */
package com.sdl.swagger.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sundonglin
 * @date 2019年6月10日 上午11:11:33
 */
@ApiModel(value = "功能信息（Function）", description = "功能信息")
public class Function  implements Serializable{
	
	@ApiModelProperty(value = "功能Id", name = "id")
	private Integer id;
	@ApiModelProperty(value = "功能moid", name = "moid")
	private String moid;
	@ApiModelProperty(value = "项目moid", name = "itemMoid")
	private String itemMoid;
	@ApiModelProperty(value = "功能状态", name = "state")
	private Integer state;
	@ApiModelProperty(value = "功能简称", name = "name")
	private String name;
	@ApiModelProperty(value = "功能周期", name = "period")
	private Integer period;
	@ApiModelProperty(value = "功能波及", name = "affect")
	private String affect;
	@ApiModelProperty(value = "功能负责人", name = "principal")
	private String principal;
	@ApiModelProperty(value = "功能完成内容", name = "content")
	private String content;
	@ApiModelProperty(value = "功能描述", name = "describe")
	private String describe;
	@ApiModelProperty(value = "创建时间", name = "createTime")
	private Date createTime;
	@ApiModelProperty(value = "项目名称", name = "itemNaem")
	private String itemName;
	
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
	public String getItemMoid() {
		return itemMoid;
	}
	public void setItemMoid(String itemMoid) {
		this.itemMoid = itemMoid;
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
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getAffect() {
		return affect;
	}
	public void setAffect(String affect) {
		this.affect = affect;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}
