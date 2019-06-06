package com.cn.huazai.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@XmlRootElement(name = "imei")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "imei", description = "")
public class Imei extends Model<Imei> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 用户手机串号
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户手机串号", dataType = "String")
    private String imei;
    /**
     * 串号激活时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "串号激活时间", dataType = "LocalDateTime")
    private LocalDateTime activatetime;
    /**
     * 串号激活号码
     */

    @XmlAttribute
    @ApiModelProperty(value = "串号激活号码", dataType = "Long")
    private Long activatenumber;
    /**
     * 串号到期时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "串号到期时间", dataType = "LocalDateTime")
    private LocalDateTime expiretime;
    /**
     * 归属地id
     */

    @XmlAttribute
    @ApiModelProperty(value = "归属地id", dataType = "Integer")
    private Integer locationId;
    /**
     * SIM卡串号
     */

    @XmlAttribute
    @ApiModelProperty(value = "SIM卡串号", dataType = "String")
    private String imsi;
    /**
     * 使用tfcard， 0：不用，1：使用
     */

    @XmlAttribute
    @ApiModelProperty(value = "使用tfcard， 0：不用，1：使用", dataType = "Integer")
    private Integer useTfcard;


    public Imei() {
    }


    public Imei(
            String imei
            ,
            LocalDateTime activatetime
            ,
            Long activatenumber
            ,
            LocalDateTime expiretime
            ,
            Integer locationId
            ,
            String imsi
            ,
            Integer useTfcard
    ) {
        this.imei = imei;
        this.activatetime = activatetime;
        this.activatenumber = activatenumber;
        this.expiretime = expiretime;
        this.locationId = locationId;
        this.imsi = imsi;
        this.useTfcard = useTfcard;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public LocalDateTime getActivatetime() {
        return activatetime;
    }

    public void setActivatetime(LocalDateTime activatetime) {
        this.activatetime = activatetime;
    }

    public Long getActivatenumber() {
        return activatenumber;
    }

    public void setActivatenumber(Long activatenumber) {
        this.activatenumber = activatenumber;
    }

    public LocalDateTime getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(LocalDateTime expiretime) {
        this.expiretime = expiretime;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Integer getUseTfcard() {
        return useTfcard;
    }

    public void setUseTfcard(Integer useTfcard) {
        this.useTfcard = useTfcard;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Imei{" +
                "id=" + id +
                ", imei=" + imei +
                ", activatetime=" + activatetime +
                ", activatenumber=" + activatenumber +
                ", expiretime=" + expiretime +
                ", locationId=" + locationId +
                ", imsi=" + imsi +
                ", useTfcard=" + useTfcard +
                "}";
    }
}
