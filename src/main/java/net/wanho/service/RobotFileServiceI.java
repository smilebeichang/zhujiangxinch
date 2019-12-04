package net.wanho.service;

import net.wanho.pojo.RobotFileInfoBean;

import java.util.List;

/**
 * Created by songb on 2019/9/30.
 */
public interface RobotFileServiceI {
    List<RobotFileInfoBean> selectRobotFilePageByBean(RobotFileInfoBean robotFileInfoBean);
}
