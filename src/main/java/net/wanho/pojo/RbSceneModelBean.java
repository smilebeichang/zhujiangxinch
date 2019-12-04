package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by songb on 2019/11/8.
 */
public class RbSceneModelBean {
    /**
     * 主键
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String mark;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建者CODE
     */
    private String createCode;

    /**
     * 状态
     */
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateCode() {
        return createCode;
    }

    public void setCreateCode(String createCode) {
        this.createCode = createCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
