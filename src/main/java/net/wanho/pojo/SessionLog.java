package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SessionLog  {

    /**
     *
     */
    private static final long serialVersionUID = -2494895463645674114L;

    private String code;
    /**
     * 客户号
     */
    private String custNo;
    private String custName;//客户姓名
    private String phone;    //客户手机号
    private String sessionID;//会话号

    private String patternCode;// 记录唯一返回或者点击；无答案或者列表为空

    private String custSent;//客户请求, JSON格式

    private Date recordDate;//发送时间

    private String answerContent;//机器人返回记录 JSON格式   这个格式是怎么保存以及存进去的？

    private Integer requestType;//请求方式 0 提问，1 点击，2 重新查询

    private Integer responseType;//返回方式 0 无答案；1 唯一；2 点击，3 列表，4 大类列表
    private String chanel;//渠道
    /**
     * 开始时间，用于查询不落库
     */
    private String startDate;
    /**
     * 结束时间，用于查询不落库
     */
    private String endDate;

    private Integer count;//统计不过数据库

    //聊天记录评价
    private String  satisfiedType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPatternCode() {
        return patternCode;
    }

    public void setPatternCode(String patternCode) {
        this.patternCode = patternCode;
    }

    public String getCustSent() {
        return custSent;
    }

    public void setCustSent(String custSent) {
        this.custSent = custSent;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getResponseType() {
        return responseType;
    }

    public void setResponseType(Integer responseType) {
        this.responseType = responseType;
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSatisfiedType() {
        return satisfiedType;
    }

    public void setSatisfiedType(String satisfiedType) {
        this.satisfiedType = satisfiedType;
    }
}
