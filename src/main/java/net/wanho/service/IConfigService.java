package net.wanho.service;

import net.wanho.pojo.ConfigBean;

import java.util.List;

/**
 * Created by songb on 2019/10/30.
 */
public interface IConfigService {
    List<ConfigBean> getConfig(ConfigBean configBean);
}
