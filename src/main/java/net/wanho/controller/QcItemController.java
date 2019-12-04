package net.wanho.controller;

import net.wanho.pojo.QcItemBean;
import net.wanho.pojo.QcTemplateItemBean;
import net.wanho.pojo.qcTemplateBean;
import net.wanho.service.QcItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/10/8.
 */
@Controller
@RequestMapping("/qcItem")
public class QcItemController {
    @Resource
    private QcItemService qcItemService;

    @CrossOrigin("*")
    @RequestMapping(value = "/getQcItemPageByBean",method = {RequestMethod.POST})
    @ResponseBody
    public List<QcItemBean> getQcItemPageByBean(@ModelAttribute("qcItemBean")QcItemBean qcItemBean){
        List<QcItemBean> pageInfo = qcItemService.getQcItemPageByBean(qcItemBean);
        return pageInfo;
    }



    @CrossOrigin("*")
    @RequestMapping(value = "/saveOrUpdateQcItem",method = {RequestMethod.POST})
    @ResponseBody
    public int saveOrUpdateQcItem(@ModelAttribute("qcItemBean")QcItemBean qcItemBean){
        if (qcItemBean.getCode()!=null  && qcItemBean.getCode()!=""){
            int u = qcItemService.updateQcItem(qcItemBean);
            return u;
        }else{
            String s1 = UUID.randomUUID().toString();
            qcItemBean.setCode(s1);
            //Date now = new Date();
            Date time = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            //String s = dateFormat.format(now);
            try {
                time= sdf.parse(sdf.format(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            qcItemBean.setCreateDate(time);
            int s = qcItemService.saveQcItem(qcItemBean);
            return s;
        }
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/deleteQcItem",method = {RequestMethod.POST})
    @ResponseBody
    public int deleteQcItem(@ModelAttribute("qcItemBean")QcItemBean qcItemBean){
            int s = qcItemService.deleteQcItem(qcItemBean);
            return s;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getUnCheckQcItemPageByBean",method = {RequestMethod.POST})
    @ResponseBody
    public List<QcItemBean> getUnCheckQcItemPageByBean(@ModelAttribute("QcTemplateItemBean")QcTemplateItemBean qcTemplateItemBean){
        List<QcItemBean> pageInfo = qcItemService.getUnCheckQcItemPageByBean(qcTemplateItemBean);
        return pageInfo;
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/queryCheckItems",method = {RequestMethod.POST})
    @ResponseBody
    public List<QcItemBean> queryCheckQcTemplateItems(@ModelAttribute("QcTemplateItemBean")QcTemplateItemBean qcTemplateItemBean){
        List<QcItemBean> pageInfo = qcItemService.queryCheckQcTemplateItems(qcTemplateItemBean);
        return pageInfo;
    }

}
