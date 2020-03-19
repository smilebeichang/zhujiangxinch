package net.wanho.mapper;

import net.wanho.pojo.NavigationInfoBean;

import java.util.List;

/**
 * Created by songb on 2019/10/29.
 */
public interface NavigationManageMapper {

    List<NavigationInfoBean> searchNavigationManage(NavigationInfoBean navigationInfoBean);

    int deleteDemo(NavigationInfoBean navigationInfoBean);
    int updateDemo(NavigationInfoBean navigationInfoBean);
    int addDemo(NavigationInfoBean navigationInfoBean);
}
