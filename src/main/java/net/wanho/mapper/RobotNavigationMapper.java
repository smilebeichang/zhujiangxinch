package net.wanho.mapper;

import net.wanho.pojo.RobotNavigationTreeNodeBean;

import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
public interface RobotNavigationMapper {
    List<RobotNavigationTreeNodeBean> searchNavigationManage(RobotNavigationTreeNodeBean robotNavigationTreeNodeBean);

    List<RobotNavigationTreeNodeBean> getRobotNavigationByParentCode(String parentCode);
}
