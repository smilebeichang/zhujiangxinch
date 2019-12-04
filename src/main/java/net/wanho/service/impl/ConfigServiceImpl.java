package net.wanho.service.impl;

import net.wanho.mapper.ConfigMapper;
import net.wanho.pojo.ConfigBean;
import net.wanho.service.IConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/30.
 */
@Service
public class ConfigServiceImpl implements IConfigService {

    @Resource
    private ConfigMapper configMapper;


    @Override
    public List<ConfigBean> getConfig(ConfigBean configBean) {
        return configMapper.getConfig(configBean);
    }
}
