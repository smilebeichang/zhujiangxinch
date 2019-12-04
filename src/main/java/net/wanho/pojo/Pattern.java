package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by songb on 2019/11/1.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pattern {

    /**
     *
     */
    private static final long serialVersionUID = 6357629133640787562L;

    private String code;

    private String parentCode;
    /**
     * 场景ID
     */
    private String intentionCode;
    /**
     * 问题库编号
     */
    private String configCode;

    private String content;
    /**
     * 标准问的问题域（不做持久）
     */
    private String orgcontent;

    private Date createDate;

    private String createAccountCode;

    private String regular;

    private String  common;

    private String  method;
    /**
     * 0 作废； 1：新增；2 发布；3修改； 4 待审核
     */
    private String  status;

    //private String  chanel;

    private String categoryCode;

    private String answercontent;

    private PatternConfig patternConfig;

    private String patternTypeCode ;
    private String menuAnswer;
    private String custNo;
    /**
     * 大类
     */
    private String bigType;
    /**
     * 中类
     */
    private String middleType;
    /**
     * 小类
     */
    private String smallType;
    /**
     * 核心词
     */
    private String coreWord;
    /**
     * 核心词2
     */
    private String coreWord2;
    /**
     * 余弦分数
     */
    private Double yscore;
    /**
     * 存在则记录流水日志
     */
    private String unLog;
}
