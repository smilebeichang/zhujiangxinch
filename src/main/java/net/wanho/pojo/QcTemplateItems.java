package net.wanho.pojo;

/**
 * Created by songb on 2019/10/26.
 */
public class QcTemplateItems {
    private String  templCode;
    private String  itemCode;
    private String  itemType;
    private int     maxScore;
    private String  itemContent;
    private String  remark;

    public String getTemplCode() {
        return templCode;
    }

    public void setTemplCode(String templCode) {
        this.templCode = templCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemlCode) {
        this.itemCode = itemCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
