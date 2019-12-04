package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 质检任务
 *
 * @author yuh
 *
 */
public class QcTaskBean  {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7067001556802116226L;

    /**
     * code
     */
    private String code;

    /**
     * 模板code
     */
    private String templateCode;

    /**
     * 模板name
     */
    private String templateName;

    /**
     * 质检计划名称
     */
    private String taskName;

    /**
     * 任务组别 add by lhx 2080726
     * <li>信审组</li>
     * <li>催收组</li>
     * <li>客服组</li>
     */
    private String taskGroup;

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    /**
     * 任务类型
     * <li>内部质检</li>
     * <li>外包质检</li>
     */
    private String taskType;
    public static final String IN_TYPE = "in";
    public static final String OUT_TYPE = "out";

    /**
     * 话务类型
     * <li>语音</li>
     * <li>文字</li>
     * <li>vtm</li>
     */
    private String mediaType;
    public static final String AUDIO_TYPE = "audio";
    public static final String CHAT_TYPE = "chat";
    public static final String VIDEO_TYPE = "video";

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 状态
     * <li>invalid:无效</li>
     * <li>edit:编辑</li>
     * <li>publish:发布</li>
     * <li>running:执行</li>
     * <li>finished:完成</li>
     */
    private String status;
    public static final String INVALID_STATUS = "1invalid";//5invalid 改为 0invalid 方便排序
    public static final String END_STATUS = "2end";//4end 改为 0end 方便排序
    public static final String FINISHED_STATUS = "3finished";
    public static final String EDIT_STATUS = "4editing";
    public static final String RUNNING_STATUS = "5running";
    public static final String RUNNINGING_STATUS = "6runninging";

    /**
     * 创建者用户号
     */
    private String creatorCode;

    /**
     * 创建者名称
     */
    private String creatorName;

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

    /**
     * 通话时长区间
     */
    private Integer minSeconds;
    private Integer maxSeconds;

    /**
     * 交易类型（交易码）
     */
    private String tranCode;

    /**
     * 满意度类型
     * <li>all：全部</li>
     * <li>sat：满意</li>
     * <li>gen：一般</li>
     * <li>dis：不满意</li>
     */
    private String satisfaction;
    public static final String ALL_SATISFACTION = "0";
    public static final String SATISFACTION = "1";
    public static final String GEN_SATISFACTION = "2";
    public static final String DIS_SATISFACTION = "3";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getMinSeconds() {
        return minSeconds;
    }

    public void setMinSeconds(Integer minSeconds) {
        this.minSeconds = minSeconds;
    }

    public Integer getMaxSeconds() {
        return maxSeconds;
    }

    public void setMaxSeconds(Integer maxSeconds) {
        this.maxSeconds = maxSeconds;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

}
