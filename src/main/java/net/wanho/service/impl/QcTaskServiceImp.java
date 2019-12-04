package net.wanho.service.impl;

import net.wanho.mapper.QcTaskMapper;
import net.wanho.pojo.QcTaskExtBean;
import net.wanho.service.IQcTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
@Service
public class QcTaskServiceImp implements IQcTaskService {
    @Resource
    private QcTaskMapper qcTaskMapper;
    @Override
    public List<QcTaskExtBean> getQcTaskListByBean(QcTaskExtBean qcTaskExtBean) {
        return qcTaskMapper.getQcTaskListByBean(qcTaskExtBean);
    }
}
