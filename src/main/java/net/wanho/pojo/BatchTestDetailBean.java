package net.wanho.pojo;


import java.util.Date;


public class BatchTestDetailBean {
	/**
     * 主键code
	 */
	private String code;
	/**
	 * 批量测试code
	 */
	private String batchTestCode;
	/**
	 * 问题
	 */
	private String question;
	/**
	 * 答案
	 */
	private String answer;
	/**
	 * 是否命中  1 是  0 否
	 */
	private String isHit;
	/**
	 * 创建日期
	 */
	private Date createDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBatchTestCode() {
		return batchTestCode;
	}

	public void setBatchTestCode(String batchTestCode) {
		this.batchTestCode = batchTestCode;
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

	public String getIsHit() {
		return isHit;
	}

	public void setIsHit(String isHit) {
		this.isHit = isHit;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
