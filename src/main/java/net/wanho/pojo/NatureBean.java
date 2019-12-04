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
public class NatureBean {
    /**
     *
     */
    private static final long serialVersionUID = 3924802334475576886L;
    /**
     * 主键
     */
    private String code;
    /**
     * 名字
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
