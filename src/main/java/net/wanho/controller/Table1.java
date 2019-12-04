package net.wanho.controller;

import net.wanho.mapper.TemplateMapper;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.ITemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/10/29.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/table1")
public class Table1 {
    @Resource
    private ITemplateService templateService;

    @RequestMapping(value = "/search1",method = {RequestMethod.POST})
    @ResponseBody
    public List<TemplateBean> search1(@ModelAttribute("templateBean") TemplateBean templateBean){
        List<TemplateBean> pageInfo = templateService.searchTemplate(templateBean);
        return  pageInfo;
    }

    @RequestMapping(value = "/delete1",method = {RequestMethod.POST})
    @ResponseBody
    public int delete1(@ModelAttribute("templateBean") TemplateBean templateBean){
        int index = templateService.deleteTemplate(templateBean);
        return  index;
    }

    @RequestMapping(value = "/addOrUpdate1",method = {RequestMethod.POST})
    @ResponseBody
    public int addOrUpdate1(@ModelAttribute("templateBean") TemplateBean templateBean){
        if(templateBean.getCode()!=null && ""!=templateBean.getCode()){
            templateBean.setCreateDate(new Date());
            int index = templateService.updateTemplate(templateBean);
            return  index;
        }else{
            templateBean.setCode(UUID.randomUUID().toString().substring(0,10));
            templateBean.setCreateDate(new Date());
            int index = templateService.insertTemplate(templateBean);
            return  index;
        }

    }
}
