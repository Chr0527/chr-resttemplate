package com.chryl.model;

import java.io.Serializable;

/**
 * Created By Chr on 2019/7/15.
 */
public class SbProtModel implements Serializable {

    private static final long serialVersionUID = 2059340923727758421L;
    private Integer protocolId;//protocolId
    private String protocolType;//protocolType
    /**
     * 设备唯一id
     */
    private String sbId;
    /**
     * 所属用户
     */
    private String userId;
    /**
     * 设备名字
     */
    private String sbName;
    /**
     * 设备类型
     */
    private String sbType;
    /**
     * 设备描述
     */
    private String sbDescription;

    /**
     * 设备协议id
     */
    private Integer sbProtocolId;


    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getSbType() {
        return sbType;
    }

    public void setSbType(String sbType) {
        this.sbType = sbType;
    }

    public String getSbDescription() {
        return sbDescription;
    }

    public void setSbDescription(String sbDescription) {
        this.sbDescription = sbDescription;
    }

    public Integer getSbProtocolId() {
        return sbProtocolId;
    }

    public void setSbProtocolId(Integer sbProtocolId) {
        this.sbProtocolId = sbProtocolId;
    }

    @Override
    public String toString() {
        return "SbProtModel{" +
                "protocolId=" + protocolId +
                ", protocolType='" + protocolType + '\'' +
                ", sbId='" + sbId + '\'' +
                ", userId='" + userId + '\'' +
                ", sbName='" + sbName + '\'' +
                ", sbType='" + sbType + '\'' +
                ", sbDescription='" + sbDescription + '\'' +
                ", sbProtocolId=" + sbProtocolId +
                '}';
    }
}
