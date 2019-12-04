package net.wanho.service.impl;

import net.wanho.mapper.QcCaseMapper;
import net.wanho.pojo.QcCaseBean;
import net.wanho.service.IQaCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/10/15.
 */
@Service
public class QaCaseServiceImpl implements IQaCaseService {
    @Autowired
    private QcCaseMapper qcCaseMapper;

    @Override
    public List<QcCaseBean> getQaCaseByBean(QcCaseBean qcCaseBean) {
        return qcCaseMapper.getQaCaseByBean(qcCaseBean);
    }

    @Override
    public int deleteQcCaseByBean(String qcCaseBean) {
        return qcCaseMapper.deleteQcCaseByBean(qcCaseBean);
    }

    @Override
    public int updateQcCaseByBean(QcCaseBean qcCaseBean) {
        return qcCaseMapper.updateQcCaseByBean(qcCaseBean);
    }

    @Override
    public int insertQcCaseByBean(QcCaseBean qcCaseBean) {
        return qcCaseMapper.insertQcCaseByBean(qcCaseBean);
    }
}
