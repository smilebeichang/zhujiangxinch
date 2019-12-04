package net.wanho.mapper;

import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.QcTemplateItems;

import java.util.List;

/**
 * Created by songb on 2019/10/26.
 */
public interface QcTemplateItemMapper {
    int deleteQcTemplateItem(QcTemplateItemBean qcTemplateItems);

    List<QcTemplateItemBean> queryCheckItems(QcTemplateItemBean qcTemplateItems);
}
