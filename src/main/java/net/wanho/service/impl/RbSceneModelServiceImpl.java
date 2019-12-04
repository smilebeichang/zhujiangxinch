package net.wanho.service.impl;

import net.wanho.mapper.RbSceneModelMapper;
import net.wanho.pojo.RbSceneModelBean;
import net.wanho.service.IRbSceneModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
@Service
public class RbSceneModelServiceImpl implements IRbSceneModelService {
    @Resource
    private RbSceneModelMapper rbSceneModelMapper;


    @Override
    public List<RbSceneModelBean> selectRbSceneModelPageByBean(RbSceneModelBean rbSceneModelBean) {
        return rbSceneModelMapper.selectRbSceneModelPageByBean( rbSceneModelBean);
    }
}
