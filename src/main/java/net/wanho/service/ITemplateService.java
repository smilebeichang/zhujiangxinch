package net.wanho.service;

import net.wanho.pojo.TemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
public interface ITemplateService {
    List<TemplateBean> searchTemplate(TemplateBean templateBean);

    int deleteTemplate(TemplateBean templateBean);

    int insertTemplate(TemplateBean templateBean);

    int updateTemplate(TemplateBean templateBean);

    int saveTemplate(TemplateBean templateBean);
}
