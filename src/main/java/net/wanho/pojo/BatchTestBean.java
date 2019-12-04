package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;


/**
 * 批量测试bean
 * @author songjianfeng
 * @date 2019-08-21
 */
@Repository
public class BatchTestBean {

	/**
	 * 主键code
	 */
	private String code;

	/**
	 * 批次名称
	 */
	private String name;

	/**
	 * 创建日期
	 */
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createDate;

	/**
	 * 创建人工号
	 */
	private String createAccountCode;

	/**
	 * 问题数量
	 */
	private int questionNum;

	/**
	 * 命中数量
	 */
	private int  hitNum;
	/**
	 * 渠道编码
	 */
	private String  channelNo;
	/**
	 * 状态  1 待处理  2 处理中  3  处理完毕
	 */
	private String status;
	/**
	 * 会话开始时间
	 */

	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date beginTime;
	/**
	 * 会话结束时间
	 */
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endTime;


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

	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public int getHitNum() {
		return hitNum;
	}

	public void setHitNum(int hitNum) {
		this.hitNum = hitNum;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}
