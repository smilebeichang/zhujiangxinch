package net.wanho.mapper;

import net.wanho.pojo.ConfigBean;

import java.util.List;

/**
 * Created by songb on 2019/10/30.
 */
public interface ConfigMapper {
    List<ConfigBean> getConfig(ConfigBean configBean);
}
