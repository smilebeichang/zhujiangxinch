package net.wanho.pojo;

import lombok.*;

import java.util.Date;

/**
 * Created by songb on 2019/11/12.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class TemplateBean2 {
    private String code;
    private String  templateName;
    private String creatorCode ;
    private String creatorName;
    private Date createDate;
    private Date  updateDate;
    private String status;
    private String remark;
    private String templateType;
    private String  itemGroup;

    private Date  beginTime;
    private Date  endTime;



}
