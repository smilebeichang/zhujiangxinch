package net.wanho.mapper;

import net.wanho.pojo.RobotFileInfoBean;

import java.util.List;

/**
 * Created by songb on 2019/9/30.
 */
public interface RobotFileMapper {
    List<RobotFileInfoBean> selectRobotFilePageByBean(RobotFileInfoBean robotFileInfoBean);
}
