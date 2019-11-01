package com.sdl.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *  项目需求类
 * @author sundonglin
 * @date 2018年9月13日 上午10:02:43
 */
@ApiModel(value = "项目需求（ItemDemand）", description = "项目需求")
public class ItemDemand {

    @ApiModelProperty(value = "需求Id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "需求moid", name = "moid")
    private String moid;
    @ApiModelProperty(value = "项目Moid", name = "itemMoid")
    private String itemMoid;
    @ApiModelProperty(value = "需求状态", name = "state")
    private Integer state;
    @ApiModelProperty(value = "需求title", name = "title")
    private String title;
    @ApiModelProperty(value = "需求描述", name = "describe")
    private String describe;
    @ApiModelProperty(value = "创建时间", name = "createDate")
    private Date createDate;
    @ApiModelProperty(value = "开始时间", name = "startDate")
    private Date startDate;
    @ApiModelProperty(value = "结束时间", name = "entDate")
    private Date entDate;
    @ApiModelProperty(value = "需求负责人", name = "principal")
    private String principal;

    private String principalStr; // 负责人名称

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Date getEntDate() {
        return entDate;
    }

    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getItemMoid() {
        return itemMoid;
    }

    public void setItemMoid(String itemMoid) {
        this.itemMoid = itemMoid;
    }

    public String getPrincipalStr() {
        return principalStr;
    }

    public void setPrincipalStr(String principalStr) {
        this.principalStr = principalStr;
    }
}
