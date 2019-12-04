package net.wanho.controller;

import net.wanho.pojo.TemplateBean;
import net.wanho.pojo.TemplateItemBean;
import net.wanho.service.ITemplateItemService;
import net.wanho.service.ITemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Controller
@RequestMapping("/templateItem")
@CrossOrigin("*")
public class TemplateItemController {
    @Resource
    private ITemplateItemService templateItemService;

    @RequestMapping(value = "/searchTemplateItem",method = {RequestMethod.GET})
    @ResponseBody
    public List<TemplateItemBean> searchTemplateItem(@ModelAttribute("templateItemBean")TemplateItemBean templateItemBean){
        List<TemplateItemBean> pageInfo = templateItemService.searchTemplateItem(templateItemBean);
        return pageInfo;
    }


    @RequestMapping(value = "/deleteTemplateItem",method = {RequestMethod.POST})
    @ResponseBody
    public int deleteTemplateItem(@ModelAttribute("templateItemBean")TemplateItemBean templateItemBean){
        int index = templateItemService.deleteTemplateItem(templateItemBean);
        return  index;
    }
}
