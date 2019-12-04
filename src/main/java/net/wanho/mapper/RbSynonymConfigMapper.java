package net.wanho.mapper;

import net.wanho.pojo.RbSynonymConfigBean;

import java.util.List;

/**
 * Created by songb on 2019/10/6.
 */
public interface RbSynonymConfigMapper {
    List<RbSynonymConfigBean> getRbSynonymConfigs(RbSynonymConfigBean rbSynonymConfigBean);

    void UpdateRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean);

    void saveRbSynonymConfig(RbSynonymConfigBean rbSynonymConfigBean);

    void deleteSynonym(String code);
}
