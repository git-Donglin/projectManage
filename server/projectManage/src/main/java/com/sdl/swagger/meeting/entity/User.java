package com.sdl.swagger.meeting.entity;

/**
 * @author sundonglin
 * @date 2019/10/24 15:37
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.StringUtils;

/**
 * 用户帐号实体类
 *
 * @author 何霄刚
 * @date 2014-3-11
 */

@XmlRootElement()
public class User implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5156307260745361884L;
    private Integer id;// 兼容老版本
    private String moid; // 用户帐号全局唯一ID
    private String email; // 注册邮箱
    private String e164; // E164号
    private String account; // 用户自定义账号，登陆账号
    private String mobile; // 手机，登陆账号
    private String ipRegion; // 允许登陆ip地址段(*.*.*.*.*;......)
    private String jid; // XMPP帐号
    private String password; // 帐号密码
    private String encryptionPassword;
    private String userDomainMoid; // 所属用户域Moid
    private String userDomainName; // 所属用户域名称
    private String serviceDomainMoid; // 服务域Moid
    private String serviceDomainName; // 服务域名称
    private String deviceGuid; // 终端GUID
    private String nuServerId; // 所属NU服务器ID
    private String deviceType; // 终端类型
    private Integer accountType; // 帐号类型，0-自定义账号;1-号码;3-xmpp超级管理员;4-IP地址段;5-监控设备;6-第三方终端
    private Boolean binded; // 是否绑定标识
    private Boolean enable; // 帐号启用禁用标识
    private Boolean isDeleted = false;// 账号被删除标识
    private Date createdAt; // 创建时间
    private Boolean limited; // 是否受限标识
    private String manageUserDomainMoid; // 服务域管理员管理的用户域moid

    private String cloudModelName;//云模式别名，公有云私有云
    private Boolean cloudModelDisplay;//云模式是否显示，显示-1/不显示-0
    private String virMachineroomMoid;//云moid，私有云下为服务域moid，公有云下为混合云ID
    private Integer cloudModelType;//云模式类型，1—私有云，2-公有云


    private Integer rank;

    private String accountSipIdentification;
    private String account323Identification;
    private String e164SipIdentification;
    private String e164323Identification;
    private String terminalRegistration;

    // 用户多个部门
    // key-部门id: value-职位.
    private Map<Integer, EmployeeDepartment> empDepts = new HashMap<Integer, EmployeeDepartment>(0);

    private String policyMoid; // 安全规则moid
    private Date updatePasswordDateTime; // 密码最后修改时间
    /** 是否首次登陆：true-首次登陆（新用户为true） false-非首次登陆（已经登陆过至少一次） */
    private Boolean firstLogin; // 是否首次登录



    /**
     * 判断当前用户帐号对象是否包含指定权限
     */

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid;
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

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Boolean isBinded() {
        return binded;
    }

    public Boolean getBinded() {
        return binded;
    }

    public void setBinded(Boolean binded) {
        this.binded = binded;
    }

    public Boolean isEnable() {
        return enable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getCreatedAt() {
        return (createdAt != null) ? new Date(createdAt.getTime()) : null;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
    }

    public Boolean isLimited() {
        return limited;
    }

    public Boolean getLimited() {
        return limited;
    }

    public void setLimited(Boolean limited) {
        this.limited = limited;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIpRegion() {
        return ipRegion;
    }

    public void setIpRegion(String ipRegion) {
        this.ipRegion = ipRegion;
    }

    public String getUserDomainMoid() {
        return userDomainMoid;
    }

    public void setUserDomainMoid(String userDomainMoid) {
        this.userDomainMoid = userDomainMoid;
    }

    public String getUserDomainName() {
        return userDomainName;
    }

    public void setUserDomainName(String userDomainName) {
        this.userDomainName = userDomainName;
    }

    public String getServiceDomainMoid() {
        return serviceDomainMoid;
    }

    public void setServiceDomainMoid(String serviceDomainMoid) {
        this.serviceDomainMoid = serviceDomainMoid;
    }

    public String getServiceDomainName() {
        return serviceDomainName;
    }

    public void setServiceDomainName(String serviceDomainName) {
        this.serviceDomainName = serviceDomainName;
    }

    public String getDeviceGuid() {
        return deviceGuid;
    }

    public void setDeviceGuid(String deviceGuid) {
        this.deviceGuid = deviceGuid;
    }

    public String getNuServerId() {
        return nuServerId;
    }

    public void setNuServerId(String nuServerId) {
        this.nuServerId = nuServerId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Map<Integer, EmployeeDepartment> getDeptIds() {
        return empDepts;
    }

    public void setDeptIds(Map<Integer, EmployeeDepartment> empDepts) {
        this.empDepts = empDepts;
    }

    public String getManageUserDomainMoid() {
        return manageUserDomainMoid;
    }

    public void setManageUserDomainMoid(String manageUserDomainMoid) {
        this.manageUserDomainMoid = manageUserDomainMoid;
    }

    public String getEncryptionPassword() {
        return encryptionPassword;
    }

    public void setEncryptionPassword(String encryptionPassword) {
        this.encryptionPassword = encryptionPassword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((moid == null) ? 0 : moid.hashCode());
        result = prime * result + ((jid == null) ? 0 : jid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (moid == null) {
            if (other.moid != null)
                return false;
        } else if (!moid.equals(other.moid))
            return false;
        if (jid == null) {
            if (other.jid != null)
                return false;
        } else if (!jid.equals(other.jid))
            return false;
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getAccountSipIdentification() {
        return accountSipIdentification;
    }

    public void setAccountSipIdentification(String accountSipIdentification) {
        this.accountSipIdentification = accountSipIdentification;
    }

    public String getAccount323Identification() {
        return account323Identification;
    }

    public void setAccount323Identification(String account323Identification) {
        this.account323Identification = account323Identification;
    }

    public String getE164SipIdentification() {
        return e164SipIdentification;
    }

    public void setE164SipIdentification(String e164SipIdentification) {
        this.e164SipIdentification = e164SipIdentification;
    }

    public String getE164323Identification() {
        return e164323Identification;
    }

    public void setE164323Identification(String e164323Identification) {
        this.e164323Identification = e164323Identification;
    }

    public String getTerminalRegistration() {
        return terminalRegistration;
    }

    public void setTerminalRegistration(String terminalRegistration) {
        this.terminalRegistration = terminalRegistration;
    }

    public String getPolicyMoid() {
        return policyMoid;
    }

    public void setPolicyMoid(String policyMoid) {
        this.policyMoid = policyMoid;
    }

    public Date getUpdatePasswordDateTime() {
        return updatePasswordDateTime;
    }

    public void setUpdatePasswordDateTime(Date updatePasswordDateTime) {
        this.updatePasswordDateTime = updatePasswordDateTime;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
    public String getCloudModelName() {
        return cloudModelName;
    }

    public void setCloudModelName(String cloudModelName) {
        this.cloudModelName = cloudModelName;
    }


    public Boolean getCloudModelDisplay() {
        return cloudModelDisplay;
    }

    public void setCloudModelDisplay(Boolean cloudModelDisplay) {
        this.cloudModelDisplay = cloudModelDisplay;
    }

    public String getVirMachineroomMoid() {
        return virMachineroomMoid;
    }

    public void setVirMachineroomMoid(String virMachineroomMoid) {
        this.virMachineroomMoid = virMachineroomMoid;
    }

    public Integer getCloudModelType() {
        return cloudModelType;
    }

    public void setCloudModelType(Integer cloudModelType) {
        this.cloudModelType = cloudModelType;
    }


}
