package net.wanho.controller;

import net.wanho.pojo.TemplateBean;
import net.wanho.pojo.TemplateItemBean;
import net.wanho.service.ITemplateItemService;
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
@RequestMapping("/table2")
public class Table2 {
    @Resource
    private ITemplateItemService templateItemService;

    @RequestMapping(value = "/search2",method = {RequestMethod.POST})
    @ResponseBody
    public List<TemplateItemBean> search2(@ModelAttribute("templateItemBean") TemplateItemBean templateItemBean){
        List<TemplateItemBean> pageInfo = templateItemService.searchTemplateItem(templateItemBean);
        return  pageInfo;
    }


    @RequestMapping(value = "/add2",method = {RequestMethod.POST})
    @ResponseBody
    public int add2(@ModelAttribute("templateItemBean") TemplateItemBean templateItemBean){

            int index = templateItemService.insertTemplateItem(templateItemBean);
            return  index;
    }

    @RequestMapping(value = "/delete2",method = {RequestMethod.POST})
    @ResponseBody
    public int delete2(@ModelAttribute("templateItemBean") TemplateItemBean templateItemBean){

        int index = templateItemService.deleteTemplateItem(templateItemBean);
        return  index;
    }
}
