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
 * 通话记录
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@XmlRootElement(name = "calllog")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "calllog", description = "通话记录")
public class Calllog extends Model<Calllog> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * guid
     */

    @XmlAttribute
    @ApiModelProperty(value = "guid", dataType = "String")
    private String guid;
    /**
     * 主叫
     */

    @XmlAttribute
    @ApiModelProperty(value = "主叫", dataType = "Integer")
    private Integer fromuser;
    /**
     * 被叫
     */

    @XmlAttribute
    @ApiModelProperty(value = "被叫", dataType = "Integer")
    private Integer touser;
    /**
     * 呼叫开始时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "呼叫开始时间", dataType = "LocalDateTime")
    private LocalDateTime starttime;
    /**
     * 挂断时间
     */

    @XmlAttribute
    @ApiModelProperty(value = "挂断时间", dataType = "LocalDateTime")
    private LocalDateTime endtime;


    public Calllog() {
    }


    public Calllog(
            String guid
            ,
            Integer fromuser
            ,
            Integer touser
            ,
            LocalDateTime starttime
            ,
            LocalDateTime endtime
    ) {
        this.guid = guid;
        this.fromuser = fromuser;
        this.touser = touser;
        this.starttime = starttime;
        this.endtime = endtime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getFromuser() {
        return fromuser;
    }

    public void setFromuser(Integer fromuser) {
        this.fromuser = fromuser;
    }

    public Integer getTouser() {
        return touser;
    }

    public void setTouser(Integer touser) {
        this.touser = touser;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Calllog{" +
                "id=" + id +
                ", guid=" + guid +
                ", fromuser=" + fromuser +
                ", touser=" + touser +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                "}";
    }
}
