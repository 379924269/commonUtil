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
 * 消息记录，新版本已经不再需要
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@XmlRootElement(name = "msglog")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "msglog", description = "消息记录，新版本已经不再需要")
public class Msglog extends Model<Msglog> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
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
     * 消息类型
     */

    @XmlAttribute
    @ApiModelProperty(value = "消息类型", dataType = "Boolean")
    private Boolean msgtype;


    public Msglog() {
    }


    public Msglog(
            Integer fromuser
            ,
            Integer touser
            ,
            LocalDateTime starttime
            ,
            Boolean msgtype
    ) {
        this.fromuser = fromuser;
        this.touser = touser;
        this.starttime = starttime;
        this.msgtype = msgtype;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean isMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Boolean msgtype) {
        this.msgtype = msgtype;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Msglog{" +
                "id=" + id +
                ", fromuser=" + fromuser +
                ", touser=" + touser +
                ", starttime=" + starttime +
                ", msgtype=" + msgtype +
                "}";
    }
}
