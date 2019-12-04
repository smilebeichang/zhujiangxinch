package net.wanho.pojo;


import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */

public class RobotNavigationTreeNodeBean  extends RobotNavigationBean{
    /**
     * 树节点ID
     */
    private String id;
    /**
     * 数节点内容
     */
    private String text;
    /**
     * 问题
     */
    private List<RobotNavigationTreeNodeBean> children;

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

    /**
     * 关联答案
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<RobotNavigationTreeNodeBean> getChildren() {
        return children;
    }

    public void setChildren(List<RobotNavigationTreeNodeBean> children) {
        this.children = children;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
