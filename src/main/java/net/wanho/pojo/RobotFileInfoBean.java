package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 机器人素材库
 * @author songjianfeng
 * @date 2019-07-25
 */
public class RobotFileInfoBean  {
    /**
     * 主键ID 32位UUID
     */
    private String id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小（单位：kb）
     */
    private int fileSize;
    /**
     * 文件存放路径
     */
    private String filePath;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 创建人工号
     */
    private String createAccountCode;
    /**
     * 更新日期
     */
    private Date updateDate;
    /**
     * 更新人工号
     */
    private String updateAccountCode;
    /**
     * 公网访问ULR
     */
    private String publicNetworkUrl;
    /**
     * 局域网访问URL
     */
    private String lanUrl;
    /**
     * 更新人姓名
     */
    private String updateAccountName;
    /**
     * 修改提交是否包含文件
     */
    private boolean hasFile;
    /**
     * 查询条件：开始日期
     */
    private String startDate;
    /**
     * 查询条件：结束日期
     */
    private String endDate;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateAccountCode() {
        return createAccountCode;
    }

    public void setCreateAccountCode(String createAccountCode) {
        this.createAccountCode = createAccountCode;
    }

    /*出参*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateAccountCode() {
        return updateAccountCode;
    }

    public void setUpdateAccountCode(String updateAccountCode) {
        this.updateAccountCode = updateAccountCode;
    }

    public String getPublicNetworkUrl() {
        return publicNetworkUrl;
    }

    public void setPublicNetworkUrl(String publicNetworkUrl) {
        this.publicNetworkUrl = publicNetworkUrl;
    }

    public String getLanUrl() {
        return lanUrl;
    }

    public void setLanUrl(String lanUrl) {
        this.lanUrl = lanUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUpdateAccountName() {
        return updateAccountName;
    }

    public void setUpdateAccountName(String updateAccountName) {
        this.updateAccountName = updateAccountName;
    }

    public boolean isHasFile() {
        return hasFile;
    }

    public void setHasFile(boolean hasFile) {
        this.hasFile = hasFile;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
