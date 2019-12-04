package net.wanho.service.impl;

import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.service.IeTreeService;
import org.springframework.stereotype.Service;
import net.wanho.mapper.eTreeMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
@Service
public class eTreeServiceImpl implements IeTreeService {
    @Resource
    private eTreeMapper eTreeMapper;

    @Override
    public List<RobotNavigationTreeNodeBean> getRobotNavigationTree() {
        //一级节点查询
        List<RobotNavigationTreeNodeBean> rootInfo = eTreeMapper.getRobotNavigationTree();
        //二级节点查询，并塞到一级节点的children
        for (RobotNavigationTreeNodeBean rb2:rootInfo) {
            rb2.setParentCode("0");
            List<RobotNavigationTreeNodeBean> secondInfo = eTreeMapper.getSecondTree(rb2.getCode());
            rb2.setChildren(secondInfo);
        }
        return rootInfo;
    }
}
