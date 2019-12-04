package net.wanho.service.impl;

import net.wanho.mapper.NavigationManageMapper;
import net.wanho.pojo.NavigationInfoBean;
import net.wanho.service.INavigationManageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/29.
 */
@Service
public class NavigationManageServiceImpl implements INavigationManageService {
    @Resource
    private NavigationManageMapper navigationManageMapper;
    @Override
    public List<NavigationInfoBean> searchNavigationManage(NavigationInfoBean navigationInfoBean) {
        return navigationManageMapper.searchNavigationManage(navigationInfoBean);
    }
}
