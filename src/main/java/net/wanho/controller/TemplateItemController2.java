package net.wanho.controller;

import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.pojo.TemplateBean2;
import net.wanho.pojo.TemplateItemBean;
import net.wanho.service.IQcTemplate2Service;
import net.wanho.service.ITemplateItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/12.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/templateItem2")
public class TemplateItemController2 {
    @Resource
    private ITemplateItemService templateItemService;

    @RequestMapping(value = "/search2",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<TemplateItemBean> search1(@ModelAttribute("templateItemBean")TemplateItemBean templateItemBean){
        ResultBean<TemplateItemBean> rb = new ResultBean();
        try {
            List<TemplateItemBean> pageInfo = templateItemService.searchTemplateItem(templateItemBean);
            if (pageInfo!=null && pageInfo.size()>0) {
                rb.setTotal((long) pageInfo.size());
                rb.setRows(pageInfo);
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
