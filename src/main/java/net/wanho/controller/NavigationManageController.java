package net.wanho.controller;

import net.wanho.pojo.NavigationInfoBean;
import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.pojo.TemplateBean2;
import net.wanho.service.INavigationManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by songb on 2019/10/29.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/navigationManage")
public class NavigationManageController {
    @Resource
    private INavigationManageService navigationManageService;

    @RequestMapping(value = "/searchNavigationManage",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<NavigationInfoBean> searchNavigationManage(@ModelAttribute("navigationInfoBean")NavigationInfoBean navigationInfoBean){
        ResultBean<NavigationInfoBean> rb = new ResultBean<>();
        if(navigationInfoBean.getName()!=null && "".equals(navigationInfoBean.getName())){
            navigationInfoBean.setName("%"+navigationInfoBean.getName()+"%");
        }
        try {
            List<NavigationInfoBean> pageInfo = navigationManageService.searchNavigationManage(navigationInfoBean);
            if (pageInfo!=null && pageInfo.size()>0){
                rb.setRows(pageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb;
    }


    @RequestMapping(value = "/deleteDemo",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<NavigationInfoBean>  deleteDemo(@ModelAttribute("navigationInfoBean")NavigationInfoBean navigationInfoBean){
        ResultBean<NavigationInfoBean> rb = new ResultBean<>();
        int  index = navigationManageService.deleteDemo(navigationInfoBean);
        if (index >0){
            rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
        }else{
            rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
        }
        return  rb;
    }


    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<NavigationInfoBean> addOrUpdate1(@ModelAttribute("navigationInfoBean")NavigationInfoBean navigationInfoBean){
        ResultBean<NavigationInfoBean> rb = new ResultBean<>();
        int index;
        if (navigationInfoBean.getCode()!=null && !"".equals(navigationInfoBean.getCode())) {
            index = navigationManageService.updateDemo(navigationInfoBean);
        }else{
            navigationInfoBean.setCode(UUID.randomUUID().toString().replace("-","").substring(0,10));
            index =navigationManageService.addDemo(navigationInfoBean);
        }
        try {
            if (index>0) {
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }else {
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb;
    }
}
