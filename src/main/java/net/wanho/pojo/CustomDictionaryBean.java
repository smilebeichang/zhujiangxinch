package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by songb on 2019/10/9.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomDictionaryBean {

    /**
     *
     */
    private static final long serialVersionUID = 8719346311780801648L;
    /**
     * 主键
     */
    private String code;
    /**
     * 词
     */
    private String name;
    /**
     * 修改前的词
     */
    private String oldname;
    /**
     * 词性
     */
    private String nature;
    /**
     * 词频
     */
    private int frequency;
    /**
     * 状态0:删除； 1：新增，2 ：发布；3 ：修改
     */
    private String status;
    /**
     * 所属语料库 多选，逗号隔开
     */
    private String patternconf;



}
