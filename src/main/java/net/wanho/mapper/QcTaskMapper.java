package net.wanho.mapper;

import net.wanho.pojo.QcTaskExtBean;

import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
public interface QcTaskMapper {
    List<QcTaskExtBean> getQcTaskListByBean(QcTaskExtBean qcTaskExtBean);
}
