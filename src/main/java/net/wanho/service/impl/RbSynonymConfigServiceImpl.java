package net.wanho.service.impl;

import net.wanho.mapper.RbSynonymConfigMapper;
import net.wanho.pojo.RbSynonymConfigBean;
import net.wanho.service.RbSynonymConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/6.
 */
@Service
public class RbSynonymConfigServiceImpl implements RbSynonymConfigServiceI{
    @Autowired
    private RbSynonymConfigMapper rbSynonymConfigMapper;

    @Override
    public List<RbSynonymConfigBean> getRbSynonymConfigs(RbSynonymConfigBean rbSynonymConfigBean) {
        return rbSynonymConfigMapper.getRbSynonymConfigs(rbSynonymConfigBean);
    }

    @Override
    public void saveRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean) {
        rbSynonymConfigMapper.saveRbSynonymConfig(rbSynonymConfigBean);
    }

    @Override
    public void UpdateRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean) {
        rbSynonymConfigMapper.UpdateRbSynonymConfig(rbSynonymConfigBean);


    }

    @Override
    public void deleteSynonym(String code) {
        rbSynonymConfigMapper.deleteSynonym(code);
    }
}
