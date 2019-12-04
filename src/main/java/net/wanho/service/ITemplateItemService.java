package net.wanho.service;

import net.wanho.pojo.TemplateItemBean;

import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
public interface ITemplateItemService {
    List<TemplateItemBean> searchTemplateItem(TemplateItemBean templateItemBean);

    int deleteTemplateItem(TemplateItemBean templateItemBean);

    int insertTemplateItem(TemplateItemBean templateItemBean);
}
