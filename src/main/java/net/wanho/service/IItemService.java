package net.wanho.service;

import net.wanho.pojo.ItemBean;
import net.wanho.pojo.TemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
public interface IItemService {
    List<ItemBean> searchItem(TemplateBean templateBean);
}
