package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 机器人会话信息
 * @author songjianfeng
 * @date
 */
public class RobotConversationLogBean {
    /**
     * 会话sessionId
     */
    private String code;
    /**
     *渠道编码
     */
    private String  channelNo;
    /**
     * 微信openId
     */
    private String openId;
    /**
     * 微信昵称
     */
    private String nickName;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 会话开始时间
     */
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")         //入参  是将String转换成Date，一般前台给后台传值时用
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") //出参 将Date转换成String 一般后台传值给前台时
    private Date beginTime;
    /**
     * 会话结束时间
     */
   /* @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")*/
    private Date endTime;
    /**
     * 消息数
     */
    private int msgNum;
    /**
     * 点赞数
     */
    private int likeNum;
    /**
     * 点踩数
     */
    private int treadNum;
    /**
     * 最后一次交互时间
     */
    private Date lastSendTime;

    /**
     * 是否在线 1 在线 0 离线
     */
    private String onlineFlag;
    /**
     * 回答不上数量
     */
    private int noAnswerNum;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getTreadNum() {
        return treadNum;
    }

    public void setTreadNum(int treadNum) {
        this.treadNum = treadNum;
    }

    public Date getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(Date lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    public String getOnlineFlag() {
        return onlineFlag;
    }

    public void setOnlineFlag(String onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    public int getNoAnswerNum() {
        return noAnswerNum;
    }

    public void setNoAnswerNum(int noAnswerNum) {
        this.noAnswerNum = noAnswerNum;
    }
}
