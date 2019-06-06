package com.cn.huazai.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "users", description = "")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "userid", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer userid;
    /**
     * 用户名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户名称", dataType = "String")
    private String username;
    /**
     * 昵称
     */

    @XmlAttribute
    @ApiModelProperty(value = "昵称", dataType = "String")
    private String nickname;
    /**
     * 工号
     */

    @XmlAttribute
    @ApiModelProperty(value = "工号", dataType = "String")
    private String employeeid;
    /**
     * 头像（头像地址）
     */

    @XmlAttribute
    @ApiModelProperty(value = "头像（头像地址）", dataType = "String")
    private String avatar;
    /**
     * 密码MD5，保留兼容语音通话
     */

    @XmlAttribute
    @ApiModelProperty(value = "密码MD5，保留兼容语音通话", dataType = "String")
    private String secret;
    /**
     * SHA256计算的密码hash值
     */

    @XmlAttribute
    @ApiModelProperty(value = "SHA256计算的密码hash值", dataType = "String")
    private String password;
    /**
     * 默认频道
     */

    @XmlAttribute
    @ApiModelProperty(value = "默认频道", dataType = "Integer")
    private Integer defaultchannel;
    /**
     * 0 禁用 1 启用 2 到期
     */

    @XmlAttribute
    @ApiModelProperty(value = "0 禁用 1 启用 2 到期", dataType = "Integer")
    private Integer enable;
    /**
     * 用户类型，“1”表示记时注册用户，“2表示终身用户”
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户类型，“1”表示记时注册用户，“2表示终身用户”", dataType = "Integer")
    private Integer type;
    /**
     * 创建者（管理员）的ID
     */

    @XmlAttribute
    @ApiModelProperty(value = "创建者（管理员）的ID", dataType = "Integer")
    private Integer createid;
    /**
     * 用户到期时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户到期时间", dataType = "LocalDateTime")
    private LocalDateTime maturitytime;
    /**
     * 用户手机串号ID外键
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户手机串号ID外键", dataType = "Integer")
    private Integer imeiid;
    /**
     * 上次登录时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "上次登录时间", dataType = "LocalDateTime")
    private LocalDateTime lastlogintime;
    /**
     * 邮箱地址，和emm一致，可以用来登录
     */

    @XmlAttribute
    @ApiModelProperty(value = "邮箱地址，和emm一致，可以用来登录", dataType = "String")
    private String email;
    /**
     * 用户标志，目前用来作为客户端本地数据库的密码
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户标志，目前用来作为客户端本地数据库的密码", dataType = "String")
    private String uuid;
    /**
     * 公钥
     */

    @XmlAttribute
    @ApiModelProperty(value = "公钥", dataType = "String")
    private String pubkey;
    /**
     * 加密卡
     */

    @XmlAttribute
    @ApiModelProperty(value = "加密卡", dataType = "Integer")
    private Integer sdcardid;
    /**
     * 手机号码,可以用来登录
     */

    @XmlAttribute
    @ApiModelProperty(value = "手机号码,可以用来登录", dataType = "String")
    private String mobile;
    /**
     * 个性签名
     */

    @XmlAttribute
    @ApiModelProperty(value = "个性签名", dataType = "String")
    private String signInfo;
    /**
     * 1男2女0未知
     */

    @XmlAttribute
    @ApiModelProperty(value = "1男2女0未知", dataType = "Boolean")
    private Boolean gender;
    /**
     * 所属部门Id
     */
    @TableField("departId")

    @XmlAttribute
    @ApiModelProperty(value = "所属部门Id", dataType = "Integer")
    private Integer departId;
    /**
     * 创建时间，单位秒
     */

    @XmlAttribute
    @ApiModelProperty(value = "创建时间，单位秒", dataType = "Integer")
    private Integer created;
    /**
     * 更新时间，单位秒
     */

    @XmlAttribute
    @ApiModelProperty(value = "更新时间，单位秒", dataType = "Integer")
    private Integer updated;
    /**
     * 验证码
     */

    @XmlAttribute
    @ApiModelProperty(value = "验证码", dataType = "String")
    private String verificationcode;
    /**
     * 登录错误次数
     */

    @XmlAttribute
    @ApiModelProperty(value = "登录错误次数", dataType = "Integer")
    private Integer loginerrorcount;
    /**
     * 验证码过期时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "验证码过期时间", dataType = "Long")
    private Long codeexpirationtime;
    /**
     * 可见组id
     */
    @TableField("visiable_user_group_Id")

    @XmlAttribute
    @ApiModelProperty(value = "可见组id", dataType = "Integer")
    private Integer visiableUserGroupId;


    public Users() {
    }


    public Users(
            Integer userid
            ,
            String username
            ,
            String nickname
            ,
            String employeeid
            ,
            String avatar
            ,
            String secret
            ,
            String password
            ,
            Integer defaultchannel
            ,
            Integer enable
            ,
            Integer type
            ,
            Integer createid
            ,
            LocalDateTime maturitytime
            ,
            Integer imeiid
            ,
            LocalDateTime lastlogintime
            ,
            String email
            ,
            String uuid
            ,
            String pubkey
            ,
            Integer sdcardid
            ,
            String mobile
            ,
            String signInfo
            ,
            Boolean gender
            ,
            Integer departId
            ,
            Integer created
            ,
            Integer updated
            ,
            String verificationcode
            ,
            Integer loginerrorcount
            ,
            Long codeexpirationtime
            ,
            Integer visiableUserGroupId
    ) {
        this.userid = userid;
        this.username = username;
        this.nickname = nickname;
        this.employeeid = employeeid;
        this.avatar = avatar;
        this.secret = secret;
        this.password = password;
        this.defaultchannel = defaultchannel;
        this.enable = enable;
        this.type = type;
        this.createid = createid;
        this.maturitytime = maturitytime;
        this.imeiid = imeiid;
        this.lastlogintime = lastlogintime;
        this.email = email;
        this.uuid = uuid;
        this.pubkey = pubkey;
        this.sdcardid = sdcardid;
        this.mobile = mobile;
        this.signInfo = signInfo;
        this.gender = gender;
        this.departId = departId;
        this.created = created;
        this.updated = updated;
        this.verificationcode = verificationcode;
        this.loginerrorcount = loginerrorcount;
        this.codeexpirationtime = codeexpirationtime;
        this.visiableUserGroupId = visiableUserGroupId;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDefaultchannel() {
        return defaultchannel;
    }

    public void setDefaultchannel(Integer defaultchannel) {
        this.defaultchannel = defaultchannel;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreateid() {
        return createid;
    }

    public void setCreateid(Integer createid) {
        this.createid = createid;
    }

    public LocalDateTime getMaturitytime() {
        return maturitytime;
    }

    public void setMaturitytime(LocalDateTime maturitytime) {
        this.maturitytime = maturitytime;
    }

    public Integer getImeiid() {
        return imeiid;
    }

    public void setImeiid(Integer imeiid) {
        this.imeiid = imeiid;
    }

    public LocalDateTime getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(LocalDateTime lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public Integer getSdcardid() {
        return sdcardid;
    }

    public void setSdcardid(Integer sdcardid) {
        this.sdcardid = sdcardid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }

    public Integer getLoginerrorcount() {
        return loginerrorcount;
    }

    public void setLoginerrorcount(Integer loginerrorcount) {
        this.loginerrorcount = loginerrorcount;
    }

    public Long getCodeexpirationtime() {
        return codeexpirationtime;
    }

    public void setCodeexpirationtime(Long codeexpirationtime) {
        this.codeexpirationtime = codeexpirationtime;
    }

    public Integer getVisiableUserGroupId() {
        return visiableUserGroupId;
    }

    public void setVisiableUserGroupId(Integer visiableUserGroupId) {
        this.visiableUserGroupId = visiableUserGroupId;
    }

    @Override
    protected Serializable pkVal() {
        return this.userid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username=" + username +
                ", nickname=" + nickname +
                ", employeeid=" + employeeid +
                ", avatar=" + avatar +
                ", secret=" + secret +
                ", password=" + password +
                ", defaultchannel=" + defaultchannel +
                ", enable=" + enable +
                ", type=" + type +
                ", createid=" + createid +
                ", maturitytime=" + maturitytime +
                ", imeiid=" + imeiid +
                ", lastlogintime=" + lastlogintime +
                ", email=" + email +
                ", uuid=" + uuid +
                ", pubkey=" + pubkey +
                ", sdcardid=" + sdcardid +
                ", mobile=" + mobile +
                ", signInfo=" + signInfo +
                ", gender=" + gender +
                ", departId=" + departId +
                ", created=" + created +
                ", updated=" + updated +
                ", verificationcode=" + verificationcode +
                ", loginerrorcount=" + loginerrorcount +
                ", codeexpirationtime=" + codeexpirationtime +
                ", visiableUserGroupId=" + visiableUserGroupId +
                "}";
    }
}
