package net.wanho.mapper;

import net.wanho.pojo.qcTemplateBean;

import java.util.List;

/**
 * Created by songb on 2019/10/24.
 */
public interface qcTemplateMapper {
    List<qcTemplateBean> queryQcTemplate(qcTemplateBean qcTemplateBean);

    int updateQcTemplate(qcTemplateBean qcTemplateBean);

    int addQcTemplate(qcTemplateBean qcTemplateBean);

    int deleteQcTemplate(qcTemplateBean qcTemplateBean);
}
