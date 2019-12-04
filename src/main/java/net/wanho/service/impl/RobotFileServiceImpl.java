package net.wanho.service.impl;

import net.wanho.mapper.RobotFileMapper;
import net.wanho.pojo.RobotFileInfoBean;
import net.wanho.service.RobotFileServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/9/30.
 */
@Service
public class RobotFileServiceImpl implements RobotFileServiceI {
    @Resource
    private RobotFileMapper robotFileMapper;

    @Override
    public List<RobotFileInfoBean> selectRobotFilePageByBean(RobotFileInfoBean robotFileInfoBean) {
        return robotFileMapper.selectRobotFilePageByBean(robotFileInfoBean);
    }
}
