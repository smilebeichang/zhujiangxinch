package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by songb on 2019/10/9.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatternConfig {
    /*居然可以少一个字段*/
    private static final long serialVersionUID = -1433313364578455401L;

    private static final String table_pre = "RB_PATTERN_INFO_";

    private String code;

    private String name;

    private Date createDate;

    private String createAccountCode;


    private String  common;
}
