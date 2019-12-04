package net.wanho.service.impl;

import net.wanho.mapper.QcOfficerMapper;
import net.wanho.pojo.QcOfficerBean;
import net.wanho.service.QcOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
@Service
public class QcOfficerServiceImpl implements QcOfficerService {
    @Autowired
    private QcOfficerMapper qcOfficerMapper;


    @Override
    public List<QcOfficerBean> getQcOfficerPageByBean(QcOfficerBean qcOfficerBean) {
        return qcOfficerMapper.getQcOfficerPageByBean(qcOfficerBean);
    }

    @Override
    public int insertQC(QcOfficerBean qcOfficerBean) {
        return qcOfficerMapper.insertQC(qcOfficerBean);
    }

    @Override
    public int deleteQc(QcOfficerBean qcOfficerBean) {
        return qcOfficerMapper.deleteQc(qcOfficerBean);
    }

    @Override
    public boolean updateQC(QcOfficerBean qcOfficerBean) {
        return qcOfficerMapper.updateQC(qcOfficerBean);
    }
}
