package net.wanho.service;

import net.wanho.pojo.TemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/11/5.
 */
public interface ITemplService {
    List<TemplateBean> searchTempl(TemplateBean templateBean);

    int UpdateTempl(TemplateBean templateBean);

    int saveTempl(TemplateBean templateBean);

    int deleteTempl(TemplateBean templateBean);
}
