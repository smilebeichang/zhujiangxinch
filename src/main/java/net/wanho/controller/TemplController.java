package net.wanho.controller;

import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.ITemplService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/11/5.
 */
@Controller
@RequestMapping("/templ")
@CrossOrigin("*")
public class TemplController {
    @Resource
    private ITemplService templ;

    @RequestMapping(value = "/searchTempl",method = {RequestMethod.POST})
    @ResponseBody
    private ResultBean<TemplateBean> searchTempl(@ModelAttribute("templateBean")TemplateBean templateBean){
        ResultBean<TemplateBean> rb = new ResultBean();
        try {
            List<TemplateBean> pageInfo = templ.searchTempl(templateBean);
            if(pageInfo!=null && pageInfo.size()>0){
                rb.setRows(pageInfo);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }else {
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb;
    }

    @RequestMapping(value = "/saveOrUpdateTempl",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateBean> saveOrUpdateTempl(@ModelAttribute("templateBean")TemplateBean templateBean){
        ResultBean<TemplateBean> rb = new ResultBean<TemplateBean>();
        boolean flag = (templateBean.getCode()!=null && ""!=templateBean.getCode());
        int index;
        try {
            if(flag){
                templateBean.setCreateDate(new Date());
                index = templ.UpdateTempl(templateBean);
            }else{
                templateBean.setCode(UUID.randomUUID().toString().replace("-","").substring(0,8));
                templateBean.setCreateDate(new Date());
                index = templ.saveTempl(templateBean);
            }
            if(index >0){
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }else{
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return  rb;
    }

    @RequestMapping(value = "/deleteTempl",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateBean> deleteTempl(@ModelAttribute("templateBean")TemplateBean templateBean){
        ResultBean<TemplateBean> rb = new ResultBean<TemplateBean>();
        int index;
        try {
            index = templ.deleteTempl(templateBean);
            if(index >0){
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }else{
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return  rb;
    }
}
