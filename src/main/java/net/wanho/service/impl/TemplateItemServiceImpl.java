package net.wanho.service.impl;

import net.wanho.mapper.TemplateItemMapper;
import net.wanho.pojo.TemplateItemBean;
import net.wanho.service.ITemplateItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Service
public class TemplateItemServiceImpl implements ITemplateItemService{
    @Resource
    private TemplateItemMapper templateItemMapper;

    @Override
    public List<TemplateItemBean> searchTemplateItem(TemplateItemBean templateItemBean) {
        return templateItemMapper.searchTemplateItem(templateItemBean);
    }

    @Override
    public int deleteTemplateItem(TemplateItemBean templateItemBean) {
        return templateItemMapper.deleteTemplateItem(templateItemBean);
    }

    @Override
    public int insertTemplateItem(TemplateItemBean templateItemBean) {
        return templateItemMapper.insertTemplateItem(templateItemBean);
    }
}
