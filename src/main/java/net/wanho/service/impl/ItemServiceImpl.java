package net.wanho.service.impl;

import net.wanho.mapper.ItemMapper;
import net.wanho.pojo.ItemBean;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Service
public class ItemServiceImpl implements IItemService {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<ItemBean> searchItem(TemplateBean templateBean) {
        return itemMapper.searchItem(templateBean);
    }
}
