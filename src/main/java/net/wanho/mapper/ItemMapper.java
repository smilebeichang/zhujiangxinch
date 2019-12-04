package net.wanho.mapper;

import net.wanho.pojo.ItemBean;
import net.wanho.pojo.TemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
public interface ItemMapper {
    List<ItemBean> searchItem(TemplateBean templateBean);
}
