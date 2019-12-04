package net.wanho.controller;

import net.wanho.pojo.ResultBean;
import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.pojo.SysConstant;
import net.wanho.pojo.TemplateBean2;
import net.wanho.service.IQcTemplate2Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/11/12.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/qcTemplate2")
public class QcTemplateController2 {
    @Resource
    private IQcTemplate2Service qcTemplate2;

    @RequestMapping(value = "/search1",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateBean2> search1(@ModelAttribute("templateBean2")TemplateBean2 templateBean2){
        ResultBean<TemplateBean2> rb = new ResultBean();

        try {
            List<TemplateBean2> pageInfo = qcTemplate2.searchByBean(templateBean2);
            if (pageInfo!=null && pageInfo.size()>0) {
                rb.setTotal((long) pageInfo.size());
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


    @RequestMapping(value = "/addOrUpdate1",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateBean2> addOrUpdate1(@ModelAttribute("templateBean2")TemplateBean2 templateBean2){
        ResultBean<TemplateBean2> rb = new ResultBean();
        int index;
        if (templateBean2.getCode()!=null && ""!=templateBean2.getCode()) {
            templateBean2.setUpdateDate(new Date());
            index = qcTemplate2.update1(templateBean2);
        }else{
            templateBean2.setUpdateDate(new Date());
            templateBean2.setCode(UUID.randomUUID().toString().replace("-","").substring(0,10));
            index =qcTemplate2.add1(templateBean2);
        }
        try {
            if (index>0) {
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
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

    @RequestMapping(value = "/delete1",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateBean2> delete1(@ModelAttribute("templateBean2")TemplateBean2 templateBean2){
        ResultBean<TemplateBean2> rb = new ResultBean();
        int index;

        try {
            index = qcTemplate2.delete1(templateBean2);
            if (index>0) {
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



    @RequestMapping(value = "/searchTree",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RobotNavigationTreeNodeBean> searchTree(){
        ResultBean<RobotNavigationTreeNodeBean> rb = new ResultBean();
        try {
            List<RobotNavigationTreeNodeBean> pageInfo = qcTemplate2.searchTree();
            if (pageInfo!=null && pageInfo.size()>0) {

                RobotNavigationTreeNodeBean rt = new RobotNavigationTreeNodeBean();
                rt.setId("0");
                rt.setText("导航");
                rt.setChildren(pageInfo);

                rb.setBean(rt);
                rb.setRows(pageInfo);
                rb.setTotal((long) pageInfo.size());
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



}
