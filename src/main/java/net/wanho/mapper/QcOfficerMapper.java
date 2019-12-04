package net.wanho.mapper;

import net.wanho.pojo.QcOfficerBean;

import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
public interface QcOfficerMapper {
    List<QcOfficerBean> getQcOfficerPageByBean(QcOfficerBean qcOfficerBean);

    int insertQC(QcOfficerBean qcOfficerBean);

    int deleteQc(QcOfficerBean qcOfficerBean);

    boolean updateQC(QcOfficerBean qcOfficerBean);
}
