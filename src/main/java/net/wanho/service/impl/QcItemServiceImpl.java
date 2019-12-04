package net.wanho.service.impl;

import net.wanho.mapper.QcItemMapper;
import net.wanho.pojo.QcItemBean;
import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.qcTemplateBean;
import net.wanho.service.QcItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/10/8.
 */
@Service
public class QcItemServiceImpl implements QcItemService {
    @Autowired
    private QcItemMapper qcItemMapper;

    @Override
    public List<QcItemBean> getQcItemPageByBean(QcItemBean qcItemBean) {
        return qcItemMapper.getQcItemPageByBean(qcItemBean);
    }

    @Override
    public int updateQcItem(QcItemBean qcItemBean) {
        return qcItemMapper.updateQcItem(qcItemBean);
    }

    @Override
    public int saveQcItem(QcItemBean qcItemBean) {
        return qcItemMapper.saveQcItem(qcItemBean);
    }

    @Override
    public int deleteQcItem(QcItemBean qcItemBean) {
        return qcItemMapper.deleteQcItem(qcItemBean);
    }

    @Override
    public List<QcItemBean> getUnCheckQcItemPageByBean(QcTemplateItemBean qcTemplateItemBean) {
        return qcItemMapper.getUnCheckQcItemPageByBean(qcTemplateItemBean);
    }

    @Override
    public List<QcItemBean> queryCheckQcTemplateItems(QcTemplateItemBean qcTemplateItemBean) {
        return qcItemMapper.queryCheckQcTemplateItems(qcTemplateItemBean);
    }
}
