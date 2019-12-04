package net.wanho.service;

import net.wanho.pojo.CustomDictionaryBean;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface ICustomDictionaryService {
    List<CustomDictionaryBean> getCustomDictionarys(CustomDictionaryBean customDictionaryBean);

    int updateConfig(CustomDictionaryBean customDictionaryBean);

    int saveConfig(CustomDictionaryBean customDictionaryBean);

    int deleteCustomDictionary(CustomDictionaryBean customDictionaryBean);
}
