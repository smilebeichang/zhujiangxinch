package net.wanho.mapper;

import net.wanho.pojo.RbSceneLineRegularBean;

import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
public interface RbSceneLineRegularMapper {
    List<RbSceneLineRegularBean> selectRbSceneLineRegular(RbSceneLineRegularBean rbSceneLineRegularBean);

    int addLineRegularBatch(List<RbSceneLineRegularBean> list);

    int updateLineRegularBatch(List<RbSceneLineRegularBean> list);
}
