package net.wanho.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/16.
 */
@Resource
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private int sid;
    private String sname;
    private int sage;
    private String sgender;
    private String saddress;

    private Card card;
    private Integer classId;
    private StuClass stuClass;
    private List<Score> scores;

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
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date beginTime;
    /**
     * 会话结束时间
     */
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;











}
