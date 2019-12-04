package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by songb on 2019/10/15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QcCaseBean {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5670912935803427690L;

    /**
     * 话务会话流水
     */
    private String uniqueSerialNo;

    /**
     * 话务类型
     * <li>语音</li>
     * <li>在线</li>
     * <li>vtm</li>
     */
    private String mediaType;
    public static final String AUDIO_TYPE = "audio";
    public static final String CHAT_TYPE = "chat";
    public static final String VIDEO_TYPE = "video";

    /**
     * 案例类型
     * <li>fine：正面</li>
     * <li>awful：反面</li>
     */
    private String caseType;
    public static final String FINE_CASE = "fine";
    public static final String AWFUL_CASE = "awful";

    /**
     * 业务大类
     */
    private String busiType;

    /**
     * 业务细项
     */
    private String busiSubType;

    /**
     * 关联质检记录编号
     */
    private String qcRecordCode;

    /**
     * 质检得分
     */
    private Float qcScore;

    /**
     * 关联小结编号
     */
    private String sumNo;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户电话
     */
    private String custPhone;

    /**
     * 坐席用户号
     */
    private String accountCode;

    /**
     * 坐席姓名
     */
    private String empName;

    /**
     * 记录人用户号
     */
    private String recorderCode;

    /**
     * 记录人姓名
     */
    private String recorderName;

    /**
     * 记录时间
     */
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     * 录入原因
     */
    private String reason;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人用户号
     */
    private String updaterCode;

    /**
     * 修改人姓名
     */
    private String updaterName;

    /**
     * 修改后内容
     */
    private String updateReason;

}
