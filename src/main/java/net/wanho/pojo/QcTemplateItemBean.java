package net.wanho.pojo;




/**
 * 质检模板明细对象
 * @author yuh
 *
 */
public class QcTemplateItemBean  {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4677942065469784063L;

    /**
     * 模板code
     */
    private String templCode;

    /**
     * 指标code
     */
    private String  itemCode;

    /**
     * 指标排序
     */
    private Integer orderNum;

    /**
     * 指标类型
     */
    private String itemType;
    /**
     * 指标类型
     */
    private String itemTypes;

    /**
     * 指标细类
     */
    private String itemSubType;

    /**
     * 指标组别
     */
    private String itemGroup;

    /**
     * 最高分（指标分值）
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
     * 指标内容
     */
    private String itemContent;

    /**
     * 权重
     */
    private Integer itemPercent;

    /**
     * 备注/描述
     */
    private String remark;

    /**
     * 状态(扩充属性)
     */
    private String status;

    /**
     * 模型编号集
     */
    private String modelCodes;

    /**
     * 模型名称集
     */
    private String modelNames;

    /**
     * 模型权重集
     */
    private String modelPercents;


    public String getTemplCode() {
        return templCode;
    }

    public void setTemplCode(String templCode) {
        this.templCode = templCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
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

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Integer getItemPercent() {
        return itemPercent;
    }

    public void setItemPercent(Integer itemPercent) {
        this.itemPercent = itemPercent;
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

    public String getModelCodes() {
        return modelCodes;
    }

    public void setModelCodes(String modelCodes) {
        this.modelCodes = modelCodes;
    }

    public String getModelNames() {
        return modelNames;
    }

    public void setModelNames(String modelNames) {
        this.modelNames = modelNames;
    }

    public String getModelPercents() {
        return modelPercents;
    }

    public void setModelPercents(String modelPercents) {
        this.modelPercents = modelPercents;
    }

    public String getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(String itemTypes) {
        this.itemTypes = itemTypes;
    }

}
