package net.wanho.service.impl;

import net.wanho.mapper.QcTemplateItemMapper;
import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.QcTemplateItems;
import net.wanho.service.IQcTemplateItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/26.
 */
@Service
public class QcTemplateItemServiceImpl implements IQcTemplateItemService  {
    @Resource
    private QcTemplateItemMapper qcTemplateItemMapper;

    @Override
    public int deleteQcTemplateItem(QcTemplateItemBean qcTemplateItems) {
        return qcTemplateItemMapper.deleteQcTemplateItem(qcTemplateItems);
    }

    @Override
    public List<QcTemplateItemBean> queryCheckItems(QcTemplateItemBean qcTemplateItems) {
        return qcTemplateItemMapper.queryCheckItems(qcTemplateItems);
    }
}
