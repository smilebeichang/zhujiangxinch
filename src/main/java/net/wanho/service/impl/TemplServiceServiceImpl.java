package net.wanho.service.impl;

import net.wanho.mapper.TemplMapper;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.ITemplService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/5.
 */
@Service
public class TemplServiceServiceImpl implements ITemplService {
    @Resource
    private TemplMapper templMapper;

    @Override
    public List<TemplateBean> searchTempl(TemplateBean templateBean) {
        return templMapper.searchTempl(templateBean);
    }

    @Override
    public int UpdateTempl(TemplateBean templateBean) {
        return templMapper.UpdateTempl(templateBean);
    }

    @Override
    public int saveTempl(TemplateBean templateBean) {
        return templMapper.saveTempl(templateBean);
    }

    @Override
    public int deleteTempl(TemplateBean templateBean) {
        return templMapper.deleteTempl(templateBean);
    }
}
