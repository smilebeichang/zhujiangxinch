package net.wanho.mapper;

import net.wanho.pojo.RbSceneModelBean;

import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
public interface RbSceneModelMapper {
    List<RbSceneModelBean> selectRbSceneModelPageByBean(RbSceneModelBean rbSceneModelBean);
}
