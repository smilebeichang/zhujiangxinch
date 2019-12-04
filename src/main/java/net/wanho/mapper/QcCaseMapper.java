package net.wanho.mapper;

import net.wanho.pojo.QcCaseBean;

import java.util.List;

/**
 * Created by songb on 2019/10/15.
 */
public interface QcCaseMapper {
     List<QcCaseBean> getQaCaseByBean(QcCaseBean qcCaseBean);

    int deleteQcCaseByBean(String qcCaseBean);

    int updateQcCaseByBean(QcCaseBean qcCaseBean);

    int insertQcCaseByBean(QcCaseBean qcCaseBean);
}
