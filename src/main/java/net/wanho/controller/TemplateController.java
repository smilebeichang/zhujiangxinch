package net.wanho.controller;

import net.wanho.pojo.TemplateBean;
import net.wanho.service.ITemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by songb on 2019/10/28.
 */
@Controller
@RequestMapping("/template")
@CrossOrigin("*")
public class TemplateController {
    @Resource
    private ITemplateService templateService;

    @RequestMapping(value = "/searchTemplate",method = {RequestMethod.POST})
    @ResponseBody
    public List<TemplateBean> searchTemplate(@ModelAttribute("templateBean")TemplateBean templateBean){
        List<TemplateBean> pageInfo = templateService.searchTemplate(templateBean);
        return pageInfo;
    }


    @RequestMapping(value = "/deleteTemplate",method = {RequestMethod.POST})
    @ResponseBody
    public int deleteTemplate(@ModelAttribute("templateBean")TemplateBean templateBean){
        int index = templateService.deleteTemplate(templateBean);
        if(index>0){
            return index;
        }
        return 0;
    }

    @RequestMapping(value = "/saveTemplate",method = {RequestMethod.POST})
    @ResponseBody
    public int saveTemplate(@ModelAttribute("templateBean")TemplateBean templateBean){
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        Date date = new Date();//创建一个date对象保存当前时间
        String dateStr = simpleDateFormat.format(date);//format()方法将Date转换成指定格式的String
        System.out.println(dateStr);//2018-08-24 15:37:47:033*/


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        templateBean.setCode(dateStr + "song");
        System.out.println(dateStr+ "song");

        int index = templateService.saveTemplate(templateBean);
        return index;
    }
}
