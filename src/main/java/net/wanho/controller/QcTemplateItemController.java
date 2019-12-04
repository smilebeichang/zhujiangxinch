package net.wanho.controller;

import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.QcTemplateItems;
import net.wanho.service.IQcTemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/26.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/qcTemplate/QcTemplateItem")
public class QcTemplateItemController {
    @Autowired
    private IQcTemplateItemService qcTemplateItemService;

    @RequestMapping(value = "/deleteQcTemplateItem",method = {RequestMethod.POST})
    @ResponseBody
    public int  deleteQcTemplateItem(QcTemplateItemBean qcTemplateItems){
        int index = qcTemplateItemService.deleteQcTemplateItem(qcTemplateItems);
        return index;
    }


    @RequestMapping(value = "/queryCheckItems",method = {RequestMethod.GET})
    @ResponseBody
    public List<QcTemplateItemBean> queryCheckItems(QcTemplateItemBean qcTemplateItems){
        List<QcTemplateItemBean> pageInfo = qcTemplateItemService.queryCheckItems(qcTemplateItems);
        return pageInfo;
    }
}
