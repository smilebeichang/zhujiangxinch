package net.wanho.service;

import net.wanho.pojo.NavigationInfoBean;

import java.util.List;

/**
 * Created by songb on 2019/10/29.
 */
public interface INavigationManageService {
    List<NavigationInfoBean> searchNavigationManage(NavigationInfoBean navigationInfoBean);
    int deleteDemo(NavigationInfoBean navigationInfoBean);
    int updateDemo(NavigationInfoBean navigationInfoBean);
    int addDemo(NavigationInfoBean navigationInfoBean);

}
