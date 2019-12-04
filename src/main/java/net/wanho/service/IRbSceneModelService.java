package net.wanho.service;

import net.wanho.pojo.RbSceneModelBean;

import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
public interface IRbSceneModelService {
    List<RbSceneModelBean> selectRbSceneModelPageByBean(RbSceneModelBean rbSceneModelBean);
}
