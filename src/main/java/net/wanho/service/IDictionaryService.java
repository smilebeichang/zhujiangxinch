package net.wanho.service;

import net.wanho.pojo.DictionaryBean;

import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
public interface IDictionaryService {
    List<DictionaryBean> getDictionaryValues(String codePath);
}
