package net.wanho.service;

import net.wanho.pojo.RbSceneLineRegularBean;

import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
public interface IRbSceneLineRegularService {
    List<RbSceneLineRegularBean> selectRbSceneLineRegular(RbSceneLineRegularBean rbSceneLineRegularBean);

    int addLineRegularBatch(List<RbSceneLineRegularBean> list);

    int updateLineRegularBatch(List<RbSceneLineRegularBean> list);
}
