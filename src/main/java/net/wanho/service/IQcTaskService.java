package net.wanho.service;

import net.wanho.pojo.QcTaskExtBean;

import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
public interface IQcTaskService {
    List<QcTaskExtBean> getQcTaskListByBean(QcTaskExtBean qcTaskExtBean);
}
