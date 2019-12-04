package net.wanho.controller;

import net.wanho.pojo.ItemBean;
import net.wanho.pojo.TemplateBean;
import net.wanho.service.IItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Controller
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {
    @Resource
    private IItemService itemService;

    @RequestMapping(value = "/searchItem",method = {RequestMethod.GET})
    @ResponseBody
    public List<ItemBean> searchItem(@ModelAttribute("templateBean")TemplateBean templateBean){
        List<ItemBean> pageInfo = itemService.searchItem(templateBean);
        return pageInfo;
    }
}
