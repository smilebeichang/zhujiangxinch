package net.wanho.pojo;

import java.util.List;


/**
 * 质检任务扩展
 *
 * @author yuh
 *
 */
public class QcTaskExtBean  extends QcTaskBean{

    /**
     * 创建时间（导出）
     */
    private String createTime;

    /**
     * 开始时间（查询条件） string vs date  不知道是故意的还是忘记了
     */
    private String beginTime;

    /**
     * 结束时间（查询条件）
     */
    private String endTime;

    /**
     * 质检员用户号
     */
    private String officerCode;

    /**
     * 被质检人用户号
     */
    private String parterCode;

    /**
     * 模板对象
     */
    private qcTemplateBean template;

    /**
     * 任务状态（in查询条件）
     */
    private String inStatus;

    //////////////任务导出扩展属性//////////////
    /**
     * 任务总质检量
     */
    private Integer totalQcNum;

    /**
     * 完成质检量
     */
    private Integer finishedQcNum;

    /**
     * 未完成质检量
     */
    private Integer unfinishedQcNum;

    /**
     * 质检员列表
     */
    private List<QcOfficerBean> officerList;



    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOfficerCode() {
        return officerCode;
    }

    public void setOfficerCode(String officerCode) {
        this.officerCode = officerCode;
    }

    public String getParterCode() {
        return parterCode;
    }

    public void setParterCode(String parterCode) {
        this.parterCode = parterCode;
    }

    public qcTemplateBean getTemplate() {
        return template;
    }

    public void setTemplate(qcTemplateBean template) {
        this.template = template;
    }

    public List<QcOfficerBean> getOfficerList() {
        return officerList;
    }

    public void setOfficerList(List<QcOfficerBean> officerList) {
        this.officerList = officerList;
    }

    public String getInStatus() {
        return inStatus;
    }

    public void setInStatus(String inStatus) {
        this.inStatus = inStatus;
    }

    public Integer getTotalQcNum() {
        return totalQcNum;
    }

    public void setTotalQcNum(Integer totalQcNum) {
        this.totalQcNum = totalQcNum;
    }

    public Integer getFinishedQcNum() {
        return finishedQcNum;
    }

    public void setFinishedQcNum(Integer finishedQcNum) {
        this.finishedQcNum = finishedQcNum;
    }

    public Integer getUnfinishedQcNum() {
        return unfinishedQcNum;
    }

    public void setUnfinishedQcNum(Integer unfinishedQcNum) {
        this.unfinishedQcNum = unfinishedQcNum;
    }

}

