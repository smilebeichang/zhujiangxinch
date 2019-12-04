package net.wanho.controller;

import net.wanho.pojo.ItemBean;
import net.wanho.pojo.TemplateBean;
import net.wanho.pojo.TemplateItemBean;
import net.wanho.service.IItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/29.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/table3")
public class Table3 {
    @Resource
    private IItemService iItemService;

    @RequestMapping(value = "/search3",method = {RequestMethod.POST})
    @ResponseBody
    public List<ItemBean> search3(@ModelAttribute("templateBean") TemplateBean templateBean){
        List<ItemBean> pageInfo = iItemService.searchItem(templateBean);
        return  pageInfo;
    }
}
