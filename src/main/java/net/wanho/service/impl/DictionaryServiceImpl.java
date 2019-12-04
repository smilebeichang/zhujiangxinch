package net.wanho.service.impl;

import net.wanho.mapper.DictionaryMapper;
import net.wanho.pojo.DictionaryBean;
import net.wanho.service.IDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Resource
    private DictionaryMapper dictionaryMapper;
    @Override
    public List<DictionaryBean> getDictionaryValues(String codePath) {
        return dictionaryMapper.getDictionaryValues(codePath);
    }
}
