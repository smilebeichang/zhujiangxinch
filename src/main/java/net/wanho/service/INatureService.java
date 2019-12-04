package net.wanho.service;

import net.wanho.pojo.NatureBean;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface INatureService {

    List<NatureBean> getNature(NatureBean natureBean);
}
