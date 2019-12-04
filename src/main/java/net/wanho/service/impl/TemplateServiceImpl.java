package net.wanho.service.impl;

import net.wanho.mapper.TemplateMapper;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.ITemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Service
public class TemplateServiceImpl implements ITemplateService {
    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<TemplateBean> searchTemplate(TemplateBean templateBean) {
        return templateMapper.searchTemplate(templateBean);
    }

    @Override
    public int deleteTemplate(TemplateBean templateBean) {
        return templateMapper.deleteTemplate(templateBean);
    }

    @Override
    public int insertTemplate(TemplateBean templateBean) {
        return templateMapper.insertTemplate(templateBean);
    }

    @Override
    public int updateTemplate(TemplateBean templateBean) {
        return templateMapper.updateTemplate(templateBean);
    }

    @Override
    public int saveTemplate(TemplateBean templateBean) {
        return templateMapper.saveTemplate(templateBean);
    }
}
