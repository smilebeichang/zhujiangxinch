package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by songb on 2019/10/30.
 */

public class ConfigBean implements Serializable {
    private static final long serialVersionUID = 2550493586192892222L;

    private String code;

    private String chanel;

    private String name;
    /**
     * 包含的词性逗号(,)隔开
     */
    private String filePatch;

    private String hadNature;
    /**
     * 需要加载的同义词的词性
     */
    private String synonymNature;
    /**
     * 上下保持的词性
     */
    private String contentNature;


    private String dealClassName;
    /**
     * 平均得分
     */
    private float avgscore;

    /**
     * 匹配得分
     */
    private float matchscore;
    /**
     * 回答前缀
     */
    private String presentence;
    /**
     * 回答后缀
     */
    private String sufsentence;
    /**
     * 第一次不存在答案回答
     */
    private String nomatch;
    /**
     * 第二次无答案提示
     */
    private String nomatch2;
    /**
     * 第三次无答案提示
     */
    private String nomatch3;
    /**
     * 转人工关键词
     */
    private String toAgentWords;
    /**
     * 转人工提示交互次数上限
     */
    private int ingeractiveToAgentNum;

    private String wcsentence;
    /**
     * 场景code
     */
    private String sceneBusinessCode;

    private Date createDate;
    /**
     *无法回答转人工次数上限
     */
    private int noAnswerNum;
    /*
    @JsonIgnoreProperties(value={"patternConfigRelates"})
    private List<PatternConfigRelate> patternConfigRelates;
    */

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePatch() {
        return filePatch;
    }

    public void setFilePatch(String filePatch) {
        this.filePatch = filePatch;
    }

    public String getHadNature() {
        return hadNature;
    }

    public void setHadNature(String hadNature) {
        this.hadNature = hadNature;
    }

    public String getSynonymNature() {
        return synonymNature;
    }

    public void setSynonymNature(String synonymNature) {
        this.synonymNature = synonymNature;
    }

    public String getContentNature() {
        return contentNature;
    }

    public void setContentNature(String contentNature) {
        this.contentNature = contentNature;
    }

    public String getDealClassName() {
        return dealClassName;
    }

    public void setDealClassName(String dealClassName) {
        this.dealClassName = dealClassName;
    }

    public float getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(float avgscore) {
        this.avgscore = avgscore;
    }

    public float getMatchscore() {
        return matchscore;
    }

    public void setMatchscore(float matchscore) {
        this.matchscore = matchscore;
    }

    public String getPresentence() {
        return presentence;
    }

    public void setPresentence(String presentence) {
        this.presentence = presentence;
    }

    public String getSufsentence() {
        return sufsentence;
    }

    public void setSufsentence(String sufsentence) {
        this.sufsentence = sufsentence;
    }

    public String getNomatch() {
        return nomatch;
    }

    public void setNomatch(String nomatch) {
        this.nomatch = nomatch;
    }

    public String getNomatch2() {
        return nomatch2;
    }

    public void setNomatch2(String nomatch2) {
        this.nomatch2 = nomatch2;
    }

    public String getNomatch3() {
        return nomatch3;
    }

    public void setNomatch3(String nomatch3) {
        this.nomatch3 = nomatch3;
    }

    public String getToAgentWords() {
        return toAgentWords;
    }

    public void setToAgentWords(String toAgentWords) {
        this.toAgentWords = toAgentWords;
    }

    public int getIngeractiveToAgentNum() {
        return ingeractiveToAgentNum;
    }

    public void setIngeractiveToAgentNum(int ingeractiveToAgentNum) {
        this.ingeractiveToAgentNum = ingeractiveToAgentNum;
    }

    public String getWcsentence() {
        return wcsentence;
    }

    public void setWcsentence(String wcsentence) {
        this.wcsentence = wcsentence;
    }

    public String getSceneBusinessCode() {
        return sceneBusinessCode;
    }

    public void setSceneBusinessCode(String sceneBusinessCode) {
        this.sceneBusinessCode = sceneBusinessCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getNoAnswerNum() {
        return noAnswerNum;
    }

    public void setNoAnswerNum(int noAnswerNum) {
        this.noAnswerNum = noAnswerNum;
    }
}
