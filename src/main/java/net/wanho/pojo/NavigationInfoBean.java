package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by songb on 2019/10/29.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NavigationInfoBean {
    /**
     *
     */
    private static final long serialVersionUID = 3304786268269988433L;

    /**
     * 主键
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 局域网图标地址
     */
    private String ioncLink;

    /**
     * 公网图标地址
     */
    private String ioncLinkOnline;

    /**
     * 序号
     */
    private String serial;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 链接
     */
    private String url;

    /**
     * 渠道
     */
    private String chanel;

    /**
     * 状态 0：无效   1：有效
     */
    private String status;
}
