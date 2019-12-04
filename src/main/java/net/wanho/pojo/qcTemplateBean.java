package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by songb on 2019/10/24.
 */
public class qcTemplateBean {
    private String CODE;
    private String TEMPL_NAME;
    private String CREATOR_CODE;
    private String CREATOR_NAME;
    private Date CREATE_DATE;
    private Date UPDATE_DATE;
    private String STATUS;
    private String REMARK;
    private String TEMPL_TYPE;
    private String ITEM_GROUP;


    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getTEMPL_NAME() {
        return TEMPL_NAME;
    }

    public void setTEMPL_NAME(String TEMPL_NAME) {
        this.TEMPL_NAME = TEMPL_NAME;
    }

    public String getCREATOR_CODE() {
        return CREATOR_CODE;
    }

    public void setCREATOR_CODE(String CREATOR_CODE) {
        this.CREATOR_CODE = CREATOR_CODE;
    }

    public String getCREATOR_NAME() {
        return CREATOR_NAME;
    }

    public void setCREATOR_NAME(String CREATOR_NAME) {
        this.CREATOR_NAME = CREATOR_NAME;
    }

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }


    public Date getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(Date UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getTEMPL_TYPE() {
        return TEMPL_TYPE;
    }

    public void setTEMPL_TYPE(String TEMPL_TYPE) {
        this.TEMPL_TYPE = TEMPL_TYPE;
    }

    public String getITEM_GROUP() {
        return ITEM_GROUP;
    }

    public void setITEM_GROUP(String ITEM_GROUP) {
        this.ITEM_GROUP = ITEM_GROUP;
    }
}
