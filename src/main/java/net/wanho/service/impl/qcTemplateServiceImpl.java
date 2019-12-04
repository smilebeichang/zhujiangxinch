package net.wanho.service.impl;

import net.wanho.pojo.qcTemplateBean;
import net.wanho.service.IQcTemplateService;
import net.wanho.mapper.qcTemplateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/24.
 */
@Service
public class qcTemplateServiceImpl implements IQcTemplateService {
    @Resource
    public qcTemplateMapper qcTemplateMapper;
    @Override
    public List<qcTemplateBean> queryQcTemplate(qcTemplateBean qcTemplateBean) {
        return qcTemplateMapper.queryQcTemplate(qcTemplateBean);
    }

    @Override
    public int updateQcTemplate(qcTemplateBean qcTemplateBean) {
        return qcTemplateMapper.updateQcTemplate(qcTemplateBean);
    }

    @Override
    public int addQcTemplate(qcTemplateBean qcTemplateBean) {
        return qcTemplateMapper.addQcTemplate(qcTemplateBean);
    }

    @Override
    public int deleteQcTemplate(qcTemplateBean qcTemplateBean) {
        return qcTemplateMapper.deleteQcTemplate(qcTemplateBean);
    }
}
