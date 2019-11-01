package com.sdl.swagger.meeting.entity;

/**
 * @author sundonglin
 * @date 2019/10/24 15:02
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 用户帐号实体类
 *
 * @author 何霄刚
 * @date 2014-3-11
 */

@XmlRootElement()
public class UserVO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1996458333496649607L;
    private Integer id;// 兼容老版本
    private String moid; // 用户帐号全局唯一ID
    private String email; // 注册邮箱
    private String e164; // E164号
    private String account; // 用户自定义账号，登陆账号
    private String mobile; // 手机，登陆账号
    private String ipRegion; // 允许登陆ip地址段(*.*.*.*.*;......)
    private String jid; // XMPP帐号
    private String encryptionPassword; // 帐号密码
    private String password; // 帐号密码
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
    private Boolean isDeleted = false; // 账号是否被删除
    private Date createdAt; // 创建时间
    private Boolean limited; // 是否受限标识
    private String manageUserDomainMoid; // 服务域管理员管理的用户域moid

    private String name; // 用户真实姓名
    private String seat; // 座位
    private String extNum; // 分机
    private String brief; // 简介
    private String fullPy; // 用户姓名拼音
    private String sex; // 性别
    private String jobNum; // 用户编号/工号
    private Date dateOfBirth; // 出生日期
    private String fax; // 传真
    private String policyMoid; // 安全规则moid
    private Date updatePasswordDateTime; // 密码最后修改时间
    /** 是否首次登陆：true-首次登陆（新用户为true） false-非首次登陆（已经登陆过至少一次） */
    private Boolean firstLogin; // 是否首次登录
    // private String officeLocation; // 办公地址

    private Date validityPeriod; // E164号的有效期
    private String restrictUsedOn; // E164号限制登录的设备类型（列表）
    private Integer restrictStrategy; // E164号限制登录使用的策略；1：可以在指定的设备类型列表上登录使用；0：可以在指定的设备类型及更低级设备上登录使用

    private String portrait32; // 头像URL，32*32
    private String portrait40; // 头像URL，40*40
    private String portrait64; // 头像URL，64*64
    private String portrait128; // 头像URL，128*128
    private String portrait256; // 头像URL，256*256

    private Boolean enableHDMeeting; // 1080P高清会议权限
    // private Boolean enableH265; // H265权限
    private Boolean enableHD = false; // 高清
    private Boolean enableFullHD = false; // 全高清
    private Boolean enableUltraHD = false; // 4K
    private Boolean enableCall = false; // 电话呼叫
    private Boolean enableRoam = false; // 漫游
    private Boolean enableSatellite = false; // 卫星线路
    private Boolean enableSatelliteP2P = false; // 卫星线路 点对点会议
    private Boolean userDomainAdmin = false; // 用户域管理员
    private Boolean enableWeibo = false; // 微博
    private Boolean enableWebRtc = false;// webRtc会议
    private Boolean weiboAdmin = false; // 微博管理员
    private Boolean enableMeeting = false; // 会管
    private Boolean meetingAdmin = false; // 会管管理员
    private Boolean enableMeetingSMS = false; // 会管短信
    private Boolean enableBMC = false; // BMC
    private Boolean enableUMC = false; // UMC
    private Boolean enableDCS = false; // DCS
    private Boolean enableVRS = false; // VRS
    private Boolean enableNM = false; // NM
    private Boolean enableDoms = false; // DOMS
    private Boolean enableKIS = false; // KIS
    private Boolean enableVenueMonitor = false; // 会场监控权限
    private Boolean serviceDomainAdmin = false; // 服务域管理员
    private Boolean defaultServiceDomainAdmin = false; // 默认的服务域管理员
    private Boolean defaultUserDomainAdmin = false; // 默认的用户域管理员
    private Boolean enableOut = false; // 出局
    private Boolean enableIncoming = false; // 入局
    private Boolean dcsAdmin = false; // dcs管理员
    private Boolean vrsAdmin = false; // vrs管理员
    private Boolean vrsDefaultAdmin = false; // vrs默认管理管理员
    private Boolean nmAdmin = false; // nm管理员
    private Boolean domsAdmin = false; // doms管理员
    private Boolean kisAdmin = false; // kis管理员
    private Boolean kisDefaultAdmin = false; //kis默认管理员
    private Boolean enableVideo = false; // VRS子权限(录像)
    private Boolean enableLive = false; // VRS子权限(直播)
    private Boolean enablePlay = false; // VRS子权限(放像)
    private Boolean enableUnicat = false; // VRS子权限(点播)
    private Boolean enableDownload = false; // VRS子权限(下载)
    private Boolean enableWatch = false; // VRS子权限(会议直播)
    private Boolean enableAutoCreateMeeting = false; // 自主创会权限
    private Boolean enablePublicCloudAccess = false; // 公有云接入权限

    private Boolean cmsApproval = false; // 会管会议审批权限
    private Boolean editName = false; // 修改姓名标识（针对所有用户域内账号）
    private Integer rank;
    private String accountSipIdentification;
    private String account323Identification;
    private String e164SipIdentification;
    private String e164323Identification;
    private String terminalRegistration;// 使用标识，2代表使用账户，1代表使用e164,0代表都不使用
    private String virMachineroomMoid;//云moid，私有云下为服务域moid，公有云下为混合云ID
    private Boolean cloudModelDisplay;//云模式是否显示，显示-1/不显示-0
    private String cloudModelName;//混合云名称，sp2暂时为公有云私有云
    private Integer cloudModelType;//云模式类型，1—私有云，2-公有云
    // 用户多个部门
    private List<EmployeeDepartment> depts = new ArrayList<EmployeeDepartment>(0);

    private Map<Integer, EmployeeDepartment> empDepts;

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

    public void setBinded(Boolean binded) {
        this.binded = binded;
    }

    public Boolean isEnable() {
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

    public List<EmployeeDepartment> getDepts() {
        return depts;
    }

    public void setDepts(List<EmployeeDepartment> depts) {
        this.depts = depts;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getExtNum() {
        return extNum;
    }

    public void setExtNum(String extNum) {
        this.extNum = extNum;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFullPy() {
        return fullPy;
    }

    public void setFullPy(String fullPy) {
        this.fullPy = fullPy;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Date getDateOfBirth() {
        return (dateOfBirth != null) ? new Date(dateOfBirth.getTime()) : null;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = (dateOfBirth != null) ? new Date(dateOfBirth.getTime()) : null;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    // public String getOfficeLocation() {
    // return officeLocation;
    // }
    //
    // public void setOfficeLocation(String officeLocation) {
    // this.officeLocation = officeLocation;
    // }

    public Date getValidityPeriod() {
        return (validityPeriod != null) ? new Date(validityPeriod.getTime()) : null;
    }

    public void setValidityPeriod(Date validityPeriod) {
        this.validityPeriod = (validityPeriod != null) ? new Date(validityPeriod.getTime()) : null;
    }

    public String getRestrictUsedOn() {
        return restrictUsedOn;
    }

    public void setRestrictUsedOn(String restrictUsedOn) {
        this.restrictUsedOn = restrictUsedOn;
    }

    public Integer getRestrictStrategy() {
        return restrictStrategy;
    }

    public void setRestrictStrategy(Integer restrictStrategy) {
        this.restrictStrategy = restrictStrategy;
    }

    public String getPortrait32() {
        return portrait32;
    }

    public void setPortrait32(String portrait32) {
        this.portrait32 = portrait32;
    }

    public String getPortrait40() {
        return portrait40;
    }

    public void setPortrait40(String portrait40) {
        this.portrait40 = portrait40;
    }

    public String getPortrait64() {
        return portrait64;
    }

    public void setPortrait64(String portrait64) {
        this.portrait64 = portrait64;
    }

    public String getPortrait128() {
        return portrait128;
    }

    public void setPortrait128(String portrait128) {
        this.portrait128 = portrait128;
    }

    public String getPortrait256() {
        return portrait256;
    }

    public void setPortrait256(String portrait256) {
        this.portrait256 = portrait256;
    }

    public Boolean getEnableHD() {
        return enableHD;
    }

    public void setEnableHD(Boolean enableHD) {
        this.enableHD = enableHD;
    }

    public Boolean getEnableCall() {
        return enableCall;
    }

    public void setEnableCall(Boolean enableCall) {
        this.enableCall = enableCall;
    }

    public Boolean getEnableRoam() {
        return enableRoam;
    }

    public void setEnableRoam(Boolean enableRoam) {
        this.enableRoam = enableRoam;
    }

    public Boolean getEnableSatellite() {
        return enableSatellite;
    }

    public void setEnableSatellite(Boolean enableSatellite) {
        this.enableSatellite = enableSatellite;
    }

    public Boolean getEnableSatelliteP2P() {
        return enableSatelliteP2P;
    }

    public void setEnableSatelliteP2P(Boolean enableSatelliteP2P) {
        this.enableSatelliteP2P = enableSatelliteP2P;
    }

    public Boolean getUserDomainAdmin() {
        return userDomainAdmin;
    }

    public void setUserDomainAdmin(Boolean userDomainAdmin) {
        this.userDomainAdmin = userDomainAdmin;
    }

    public Boolean getEnableHDMeeting() {
        return enableHDMeeting;
    }

    public void setEnableHDMeeting(Boolean enableHDMeeting) {
        this.enableHDMeeting = enableHDMeeting;
    }

    // public Boolean getEnableH265() {
    // return enableH265;
    // }
    //
    // public void setEnableH265(Boolean enableH265) {
    // this.enableH265 = enableH265;
    // }

    public Boolean getEnableWeibo() {
        return enableWeibo;
    }

    public void setEnableWeibo(Boolean enableWeibo) {
        this.enableWeibo = enableWeibo;
    }

    public Boolean getWeiboAdmin() {
        return weiboAdmin;
    }

    public void setWeiboAdmin(Boolean weiboAdmin) {
        this.weiboAdmin = weiboAdmin;
    }

    public Boolean getEnableMeeting() {
        return enableMeeting;
    }

    public void setEnableMeeting(Boolean enableMeeting) {
        this.enableMeeting = enableMeeting;
    }

    public Boolean getMeetingAdmin() {
        return meetingAdmin;
    }

    public void setMeetingAdmin(Boolean meetingAdmin) {
        this.meetingAdmin = meetingAdmin;
    }

    public Boolean getEnableMeetingSMS() {
        return enableMeetingSMS;
    }

    public void setEnableMeetingSMS(Boolean enableMeetingSMS) {
        this.enableMeetingSMS = enableMeetingSMS;
    }

    public Boolean getEnableBMC() {
        return enableBMC;
    }

    public void setEnableBMC(Boolean enableBMC) {
        this.enableBMC = enableBMC;
    }

    public Boolean getEnableUMC() {
        return enableUMC;
    }

    public void setEnableUMC(Boolean enableUMC) {
        this.enableUMC = enableUMC;
    }

    public Boolean getEnableDCS() {
        return enableDCS;
    }

    public void setEnableDCS(Boolean enableDCS) {
        this.enableDCS = enableDCS;
    }

    public Boolean getEnableVRS() {
        return enableVRS;
    }

    public void setEnableVRS(Boolean enableVRS) {
        this.enableVRS = enableVRS;
    }

    public Boolean getEnableNM() {
        return enableNM;
    }

    public void setEnableNM(Boolean enableNM) {
        this.enableNM = enableNM;
    }

    public Boolean getEnableDoms() {
        return enableDoms;
    }

    public void setEnableDoms(Boolean enableDoms) {
        this.enableDoms = enableDoms;
    }

    public Boolean getEnableKIS() {
        return enableKIS;
    }

    public void setEnableKIS(Boolean enableKIS) {
        this.enableKIS = enableKIS;
    }

    public Boolean getEnableVenueMonitor() {
        return enableVenueMonitor;
    }

    public void setEnableVenueMonitor(Boolean enableVenueMonitor) {
        this.enableVenueMonitor = enableVenueMonitor;
    }

    public Boolean getServiceDomainAdmin() {
        return serviceDomainAdmin;
    }

    public void setServiceDomainAdmin(Boolean serviceDomainAdmin) {
        this.serviceDomainAdmin = serviceDomainAdmin;
    }

    public Boolean getDefaultServiceDomainAdmin() {
        return defaultServiceDomainAdmin;
    }

    public void setDefaultServiceDomainAdmin(Boolean defaultServiceDomainAdmin) {
        this.defaultServiceDomainAdmin = defaultServiceDomainAdmin;
    }

    public Boolean getDefaultUserDomainAdmin() {
        return defaultUserDomainAdmin;
    }

    public void setDefaultUserDomainAdmin(Boolean defaultUserDomainAdmin) {
        this.defaultUserDomainAdmin = defaultUserDomainAdmin;
    }

    public Boolean getEnableOut() {
        return enableOut;
    }

    public void setEnableOut(Boolean enableOut) {
        this.enableOut = enableOut;
    }

    public Boolean getEnableIncoming() {
        return enableIncoming;
    }

    public void setEnableIncoming(Boolean enableIncoming) {
        this.enableIncoming = enableIncoming;
    }

    public Boolean getBinded() {
        return binded;
    }

    public Boolean getEnable() {
        return enable;
    }

    public Boolean getLimited() {
        return limited;
    }

    public Boolean getDcsAdmin() {
        return dcsAdmin;
    }

    public void setDcsAdmin(Boolean dcsAdmin) {
        this.dcsAdmin = dcsAdmin;
    }

    public Boolean getVrsAdmin() {
        return vrsAdmin;
    }

    public void setVrsAdmin(Boolean vrsAdmin) {
        this.vrsAdmin = vrsAdmin;
    }

    public Boolean getVrsDefaultAdmin() {
        return vrsDefaultAdmin;
    }

    public void setVrsDefaultAdmin(Boolean vrsDefaultAdmin) {
        this.vrsDefaultAdmin = vrsDefaultAdmin;
    }

    public Boolean getNmAdmin() {
        return nmAdmin;
    }

    public void setNmAdmin(Boolean nmAdmin) {
        this.nmAdmin = nmAdmin;
    }

    public Boolean getDomsAdmin() {
        return domsAdmin;
    }

    public void setDomsAdmin(Boolean domsAdmin) {
        this.domsAdmin = domsAdmin;
    }

    public Boolean getKisAdmin() {
        return kisAdmin;
    }

    public void setKisAdmin(Boolean kisAdmin) {
        this.kisAdmin = kisAdmin;
    }

    public Boolean getKisDefaultAdmin() {
        return kisDefaultAdmin;
    }

    public void setKisDefaultAdmin(Boolean kisDefaultAdmin) {
        this.kisDefaultAdmin = kisDefaultAdmin;
    }

    public Boolean getEnableVideo() {
        return enableVideo;
    }

    public void setEnableVideo(Boolean enableVideo) {
        this.enableVideo = enableVideo;
    }

    public Boolean getEnableLive() {
        return enableLive;
    }

    public void setEnableLive(Boolean enableLive) {
        this.enableLive = enableLive;
    }

    public Boolean getEnableUnicat() {
        return enableUnicat;
    }

    public void setEnableUnicat(Boolean enableUnicat) {
        this.enableUnicat = enableUnicat;
    }

    public Boolean getEnableDownload() {
        return enableDownload;
    }

    public void setEnableDownload(Boolean enableDownload) {
        this.enableDownload = enableDownload;
    }

    public Boolean getEnablePlay() {
        return enablePlay;
    }

    public void setEnablePlay(Boolean enablePlay) {
        this.enablePlay = enablePlay;
    }

    public Boolean getCmsApproval() {
        return cmsApproval;
    }

    public void setCmsApproval(Boolean cmsApproval) {
        this.cmsApproval = cmsApproval;
    }

    public Map<Integer, EmployeeDepartment> getEmpDepts() {
        return empDepts;
    }

    public void setEmpDepts(Map<Integer, EmployeeDepartment> empDepts) {
        this.empDepts = empDepts;
    }

    public String getManageUserDomainMoid() {
        return manageUserDomainMoid;
    }

    public void setManageUserDomainMoid(String manageUserDomainMoid) {
        this.manageUserDomainMoid = manageUserDomainMoid;
    }

    public Boolean getEditName() {
        return editName;
    }

    public void setEditName(Boolean editName) {
        this.editName = editName;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getEnableWebRtc() {
        return enableWebRtc;
    }

    public void setEnableWebRtc(Boolean enableWebRtc) {
        this.enableWebRtc = enableWebRtc;
    }

    public Boolean getEnableWatch() {
        return enableWatch;
    }

    public void setEnableWatch(Boolean enableWatch) {
        this.enableWatch = enableWatch;
    }

    public Boolean getEnableFullHD() {
        return enableFullHD;
    }

    public void setEnableFullHD(Boolean enableFullHD) {
        this.enableFullHD = enableFullHD;
    }

    public Boolean getEnableUltraHD() {
        return enableUltraHD;
    }

    public void setEnableUltraHD(Boolean enableUltraHD) {
        this.enableUltraHD = enableUltraHD;
    }

    public String getEncryptionPassword() {
        return encryptionPassword;
    }

    public void setEncryptionPassword(String encryptionPassword) {
        this.encryptionPassword = encryptionPassword;
    }
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public Boolean getEnableAutoCreateMeeting() {
        return enableAutoCreateMeeting;
    }

    public void setEnableAutoCreateMeeting(Boolean enableAutoCreateMeeting) {
        this.enableAutoCreateMeeting = enableAutoCreateMeeting;
    }

    public Boolean getEnablePublicCloudAccess() {
        return enablePublicCloudAccess;
    }

    public void setEnablePublicCloudAccess(Boolean enablePublicCloudAccess) {
        this.enablePublicCloudAccess = enablePublicCloudAccess;
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

    public Boolean getCloudModelDisplay() {
        return cloudModelDisplay;
    }

    public void setCloudModelDisplay(Boolean cloudModelDisplay) {
        this.cloudModelDisplay = cloudModelDisplay;
    }

    public String getVirMachineroomMoid() {
        return virMachineroomMoid;
    }

    public String getCloudModelName() {
        return cloudModelName;
    }

    public void setVirMachineroomMoid(String virMachineroomMoid) {
        this.virMachineroomMoid = virMachineroomMoid;
    }

    public void setCloudModelName(String cloudModelName) {
        this.cloudModelName = cloudModelName;
    }

    public Integer getCloudModelType() {
        return cloudModelType;
    }

    public void setCloudModelType(Integer cloudModelType) {
        this.cloudModelType = cloudModelType;
    }
}
