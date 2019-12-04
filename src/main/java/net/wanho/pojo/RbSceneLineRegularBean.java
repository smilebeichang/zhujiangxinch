package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by songb on 2019/11/8.
 */
public class RbSceneLineRegularBean {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2425396688638838704L;

    /**
     * 主键
     */
    private String code;

    /**
     * 连接线编号
     */
    private String lineCode;
    /**
     * 模型编号
     */
    private String modelCode;
    /**
     * 前置场景ID
     */
    private String fromNodeCode;

    /**
     * 后置场景编号
     */
    private String toNodeCode;
    /**
     * 备注
     */
    private String content;

    /**
     * 创建人用户号
     */
    private String createrCode;

    /**
     * 创建人姓名
     */
    private String createrName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 状态 1 原有的； 2 新增； 0 删除；  么得命这个可以哟
     */
    private Integer status=1;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreaterCode() {
        return createrCode;
    }

    public void setCreaterCode(String createrCode) {
        this.createrCode = createrCode;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result + ((createrCode == null) ? 0 : createrCode.hashCode());
        result = prime * result + ((createrName == null) ? 0 : createrName.hashCode());
        result = prime * result + ((lineCode == null) ? 0 : lineCode.hashCode());
        result = prime * result + ((modelCode == null) ? 0 : modelCode.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        RbSceneLineRegularBean other = (RbSceneLineRegularBean) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (createDate == null) {
            if (other.createDate != null)
                return false;
        } else if (!createDate.equals(other.createDate))
            return false;
        if (createrCode == null) {
            if (other.createrCode != null)
                return false;
        } else if (!createrCode.equals(other.createrCode))
            return false;
        if (createrName == null) {
            if (other.createrName != null)
                return false;
        } else if (!createrName.equals(other.createrName))
            return false;
        if (lineCode == null) {
            if (other.lineCode != null)
                return false;
        } else if (!lineCode.equals(other.lineCode))
            return false;
        if (modelCode == null) {
            if (other.modelCode != null)
                return false;
        } else if (!modelCode.equals(other.modelCode))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    public String getFromNodeCode() {
        return fromNodeCode;
    }

    public void setFromNodeCode(String fromNodeCode) {
        this.fromNodeCode = fromNodeCode;
    }

    public String getToNodeCode() {
        return toNodeCode;
    }

    public void setToNodeCode(String toNodeCode) {
        this.toNodeCode = toNodeCode;
    }

}
