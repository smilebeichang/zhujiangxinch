package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by songb on 2019/9/29.
 */
public class QcOfficerBean {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6693362576008756276L;

    /**
     * 主键
     */
    private String code;

    /**
     * 质检员用户号
     */
    private String officerCode;

    /**
     * 质检员姓名
     */
    private String officerName;

    /**
     * 业务组
     */
    private String businessGroupCode ;

    /**
     * 创建人用户号
     */
    private String creatorCode ;

    /**
     * 备注
     */
    private String creatorName;

    /**
     * 质检员类型
     * <li>0：普通质检员</li>
     * <li>1：质检管理员</li>
     */
    private String officerType;
    public static final String LEVEL_OFFICER = "officer";
    public static final String LEVEL_MANAGER = "manager";

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOfficerCode() {
        return officerCode;
    }

    public void setOfficerCode(String officerCode) {
        this.officerCode = officerCode;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getBusinessGroupCode() {
        return businessGroupCode;
    }

    public void setBusinessGroupCode(String businessGroupCode) {
        this.businessGroupCode = businessGroupCode;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getOfficerType() {
        return officerType;
    }

    public void setOfficerType(String officerType) {
        this.officerType =officerType;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
