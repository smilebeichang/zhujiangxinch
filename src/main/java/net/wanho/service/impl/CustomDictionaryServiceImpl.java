package net.wanho.service.impl;

import net.wanho.mapper.CustomDictionaryMapper;
import net.wanho.pojo.CustomDictionaryBean;
import net.wanho.service.ICustomDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
@Service
public class CustomDictionaryServiceImpl implements ICustomDictionaryService {
    @Autowired
    private CustomDictionaryMapper customDictionaryMapper;


    @Override
    public List<CustomDictionaryBean> getCustomDictionarys(CustomDictionaryBean customDictionaryBean) {
        return customDictionaryMapper.getCustomDictionarys(customDictionaryBean);
    }

    @Override
    public int updateConfig(CustomDictionaryBean customDictionaryBean) {
        return customDictionaryMapper.updateConfig(customDictionaryBean);
    }

    @Override
    public int saveConfig(CustomDictionaryBean customDictionaryBean) {
        return customDictionaryMapper.saveConfig(customDictionaryBean);
    }

    @Override
    public int deleteCustomDictionary(CustomDictionaryBean customDictionaryBean) {
        return customDictionaryMapper.deleteCustomDictionary(customDictionaryBean);
    }
}
