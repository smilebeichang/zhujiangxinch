package net.wanho.service.impl;

import net.wanho.mapper.RbSceneLineRegularMapper;
import net.wanho.pojo.RbSceneLineRegularBean;
import net.wanho.service.IRbSceneLineRegularService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
@Service
public class RbSceneLineRegularServiceImpl implements IRbSceneLineRegularService {
    @Resource
    private RbSceneLineRegularMapper rbSceneLineRegularMapper;

    @Override
    public List<RbSceneLineRegularBean> selectRbSceneLineRegular(RbSceneLineRegularBean rbSceneLineRegularBean) {
        return rbSceneLineRegularMapper.selectRbSceneLineRegular(rbSceneLineRegularBean);
    }

    @Override
    public int addLineRegularBatch(List<RbSceneLineRegularBean> list) {
        //应该是在这边实现三元运算符的嵌套
        return rbSceneLineRegularMapper.addLineRegularBatch(list);
    }

    @Override
    public int updateLineRegularBatch(List<RbSceneLineRegularBean> list) {
        return rbSceneLineRegularMapper.updateLineRegularBatch(list);
    }
}
