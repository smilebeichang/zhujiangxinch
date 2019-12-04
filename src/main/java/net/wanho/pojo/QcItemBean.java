package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 质检指标项
 * @author yuh
 * 
 */
public class QcItemBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5290947440701026583L;

	/**
	 * 主键
	 */
	private String code;
	
	/**
	 * 指标大类
	 */
	private String itemType;
	
	/**
	 * 指标小类（grc暂时不用）
	 */
	private String itemSubType;
	
	/**
	 * 指标分组
	 */
	private String itemGroup;
	
	/**
	 * 指标内容
	 */
	private String itemContent;
	
	/**
	 * 最高分
	 */
	private Integer maxScore;
	
	/**
	 * 合格分数
	 */
	private Integer passScore;
	
	/**
	 * 最低分
	 */
	private Integer minScore;
	
	/**
	 * 标准分值1
	 */
	private Integer scoreLevela;
	
	/**
	 * 标准描述1
	 */
	private String descLevela;
	
	/**
	 * 标准分值2
	 */
	private Integer scoreLevelb;
	
	/**
	 * 标准描述2
	 */
	private String descLevelb;
	
	/**
	 * 标准分值3
	 */
	private Integer scoreLevelc;
	
	/**
	 * 标准描述3
	 */
	private String descLevelc;
	
	/**
	 * 标准分值4
	 */
	private Integer scoreLeveld;
	
	/**
	 * 标准描述4
	 */
	private String descLeveld;
	
	/**
	 * 标准分值5
	 */
	private Integer scoreLevele;
	
	/**
	 * 标准描述5
	 */
	private String descLevele;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 状态
	 * <li>0：无效</li>
	 * <li>1：有效</li>
	 */
	private String status;
	public static final String INVALID_STATUS = "0";
	public static final String VALID_STATUS = "1";
	
	/**
	 * 创建人用户号
	 */
	private String creatorCode;
	
	/**
	 * 创建人姓名
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemSubType() {
		return itemSubType;
	}

	public void setItemSubType(String itemSubType) {
		this.itemSubType = itemSubType;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public Integer getMinScore() {
		return minScore;
	}

	public void setMinScore(Integer minScore) {
		this.minScore = minScore;
	}

	public Integer getScoreLevela() {
		return scoreLevela;
	}

	public void setScoreLevela(Integer scoreLevela) {
		this.scoreLevela = scoreLevela;
	}

	public String getDescLevela() {
		return descLevela;
	}

	public void setDescLevela(String descLevela) {
		this.descLevela = descLevela;
	}

	public Integer getScoreLevelb() {
		return scoreLevelb;
	}

	public void setScoreLevelb(Integer scoreLevelb) {
		this.scoreLevelb = scoreLevelb;
	}

	public String getDescLevelb() {
		return descLevelb;
	}

	public void setDescLevelb(String descLevelb) {
		this.descLevelb = descLevelb;
	}

	public Integer getScoreLevelc() {
		return scoreLevelc;
	}

	public void setScoreLevelc(Integer scoreLevelc) {
		this.scoreLevelc = scoreLevelc;
	}

	public String getDescLevelc() {
		return descLevelc;
	}

	public void setDescLevelc(String descLevelc) {
		this.descLevelc = descLevelc;
	}

	public Integer getScoreLeveld() {
		return scoreLeveld;
	}

	public void setScoreLeveld(Integer scoreLeveld) {
		this.scoreLeveld = scoreLeveld;
	}

	public String getDescLeveld() {
		return descLeveld;
	}

	public void setDescLeveld(String descLeveld) {
		this.descLeveld = descLeveld;
	}

	public Integer getScoreLevele() {
		return scoreLevele;
	}

	public void setScoreLevele(Integer scoreLevele) {
		this.scoreLevele = scoreLevele;
	}

	public String getDescLevele() {
		return descLevele;
	}

	public void setDescLevele(String descLevele) {
		this.descLevele = descLevele;
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
