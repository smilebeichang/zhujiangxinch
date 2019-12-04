package net.wanho.service;

import net.wanho.pojo.RbSynonymConfigBean;

import java.util.List;

/**
 * Created by songb on 2019/10/6.
 */
public interface RbSynonymConfigServiceI {
    List<RbSynonymConfigBean> getRbSynonymConfigs(RbSynonymConfigBean rbSynonymConfigBean);

    void saveRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean);

    void UpdateRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean);

    void deleteSynonym(String code);
}
