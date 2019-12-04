package net.wanho.service;

import net.wanho.pojo.QcCaseBean;

import java.util.List;

/**
 * Created by songb on 2019/10/15.
 */
public interface IQaCaseService {

    List<QcCaseBean> getQaCaseByBean(QcCaseBean qcCaseBean);

    int deleteQcCaseByBean(String id);

    int updateQcCaseByBean(QcCaseBean qcCaseBean);

    int insertQcCaseByBean(QcCaseBean qcCaseBean);
}
