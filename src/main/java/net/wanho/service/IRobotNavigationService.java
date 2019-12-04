package net.wanho.service;

import net.wanho.pojo.RobotNavigationTreeNodeBean;

import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
public interface IRobotNavigationService {
    List<RobotNavigationTreeNodeBean> getRobotNavigationTree(RobotNavigationTreeNodeBean robotNavigationTreeNodeBean) throws Exception;
}
