package net.wanho.pojo;

import java.util.Date;

/**
 * Created by songb on 2019/10/31.
 */
public class RobotNavigationBean {
    /**
     * 主键ID 32位UUID
     */
    private String code;
    /**
     * 父节点ID
     */
    private String parentCode;
    /**
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;
    /**
     * 序号（树结构从小到大排列）
     */
    private int orderNo;
    /**
     * 更新日期
     */
    private Date updateDate;
    /**
     * 更新时间
     */
    private String updateAccountCode;

    /**
     * 渠道
     */
    private String channelNo;

    /**
     * 答案类型 ：0 ：自定义     1：关联FAQ的问题答案
     */
    private String answerType;

    /**
     * 关联id
     */
    private String relationCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

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

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getRelationCode() {
        return relationCode;
    }

    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }
}
