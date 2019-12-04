package net.wanho.mapper;

import net.wanho.pojo.QcItemBean;
import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.qcTemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/10/8.
 */
public interface QcItemMapper {
    List<QcItemBean> getQcItemPageByBean(QcItemBean qcItemBean);

    int updateQcItem(QcItemBean qcItemBean);

    int saveQcItem(QcItemBean qcItemBean);

    int deleteQcItem(QcItemBean qcItemBean);

    List<QcItemBean> getUnCheckQcItemPageByBean(QcTemplateItemBean qcTemplateItemBean);

    List<QcItemBean> queryCheckQcTemplateItems(QcTemplateItemBean qcTemplateItemBean);
}
