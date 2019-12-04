package net.wanho.controller;

import net.wanho.pojo.qcTemplateBean;
import net.wanho.service.IQcTemplateService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/10/24.
 */
@Controller
@CrossOrigin("*")
public class QcTemplateController {
    @Resource
    private IQcTemplateService qcTemplateService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //自定义格式
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/queryQcTemplate",method = {RequestMethod.POST })
    @ResponseBody
    @CrossOrigin("*")
    public List<qcTemplateBean> queryQcTemplate(@ModelAttribute("qcTemplateBean") qcTemplateBean qcTemplateBean) {
        List<qcTemplateBean> pageInfo = qcTemplateService.queryQcTemplate(qcTemplateBean);
        return pageInfo;
    }

    @RequestMapping(value = "/addOrUpdate",method={RequestMethod.POST})
    @ResponseBody
    public int addOrUpdate(@ModelAttribute("qcTemplateBean")qcTemplateBean qcTemplateBean){
        String code = qcTemplateBean.getCODE();
        int index;
        if(code!=null  && ""!=code){
             qcTemplateBean.setUPDATE_DATE(new Date());
             index = qcTemplateService.updateQcTemplate(qcTemplateBean);
        }else{
            qcTemplateBean.setCODE(UUID.randomUUID().toString().replaceAll("-", "").substring(0,9));
            qcTemplateBean.setCREATE_DATE(new Date());
            index = qcTemplateService.addQcTemplate(qcTemplateBean);
        }
        return index;
    }

    @RequestMapping(value = "/deleteQcTemplate",method = {RequestMethod.POST})
    @ResponseBody
    public int deleteQcTemplate(@ModelAttribute("qcTemplateBean")qcTemplateBean qcTemplateBean){
        int index = qcTemplateService.deleteQcTemplate(qcTemplateBean);
        return index;
    }
}
