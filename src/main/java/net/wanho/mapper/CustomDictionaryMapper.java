package net.wanho.mapper;


import net.wanho.pojo.CustomDictionaryBean;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface CustomDictionaryMapper {


    List<CustomDictionaryBean> getCustomDictionarys(CustomDictionaryBean customDictionaryBean);

    int updateConfig(CustomDictionaryBean customDictionaryBean);

    int saveConfig(CustomDictionaryBean customDictionaryBean);

    int deleteCustomDictionary(CustomDictionaryBean customDictionaryBean);
}
