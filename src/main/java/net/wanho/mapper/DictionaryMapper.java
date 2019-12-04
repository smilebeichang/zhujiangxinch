package net.wanho.mapper;

import net.wanho.pojo.DictionaryBean;

import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
public interface DictionaryMapper {
    List<DictionaryBean> getDictionaryValues(String path);
}
