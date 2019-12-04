package net.wanho.controller;

import net.wanho.pojo.NavigationInfoBean;
import net.wanho.service.INavigationManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songb on 2019/10/29.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/navigationManage")
public class NavigationManageController {
    @Resource
    private INavigationManageService navigationManageService;

    //ochat_navigation_info
    @RequestMapping(value = "/searchNavigationManage",method = {RequestMethod.POST})
    @ResponseBody
    public List<NavigationInfoBean> searchNavigationManage(@ModelAttribute("navigationInfoBean")NavigationInfoBean navigationInfoBean){
        List<NavigationInfoBean> pageInfo = navigationManageService.searchNavigationManage(navigationInfoBean);
        return pageInfo;
    }

}
