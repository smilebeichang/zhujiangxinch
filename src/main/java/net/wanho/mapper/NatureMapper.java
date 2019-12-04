package net.wanho.mapper;

import net.wanho.pojo.NatureBean;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface NatureMapper {
    List<NatureBean> getNature(NatureBean natureBean);
}
