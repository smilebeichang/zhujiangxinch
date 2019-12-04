package net.wanho.controller;

import net.wanho.pojo.QcCaseBean;
import net.wanho.service.IQaCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by songb on 2019/10/15.
 */
@Controller
@RequestMapping("/QcCase")
public class QaCaseController {
    @Autowired
    private IQaCaseService iQcCaseService;

    @RequestMapping(value = "/getQcCaseByBean",method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin("*")
    public List<QcCaseBean> getQaCaseByBean(@ModelAttribute("QcCaseBean") QcCaseBean qcCaseBean){
        List<QcCaseBean> pageInfo = iQcCaseService.getQaCaseByBean(qcCaseBean);
        return  pageInfo;
    }

    @RequestMapping(value = "/deleteQcCaseByBean",method = {RequestMethod.POST})
    @ResponseBody
    public int deleteQcCaseByBean(@ModelAttribute("QcCaseBean") QcCaseBean qcCaseBean){
        int index = iQcCaseService.deleteQcCaseByBean(qcCaseBean.getUniqueSerialNo().toString());
        return  index;
    }

    @RequestMapping(value = "/saveOrUpdateQcCaseByBean",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin("*")
    public int saveOrUpdateQcCaseByBean(@ModelAttribute("QcCaseBean") QcCaseBean qcCaseBean){
        if (qcCaseBean.getUniqueSerialNo()!=null && qcCaseBean.getUniqueSerialNo()!=""){
            int index = iQcCaseService.updateQcCaseByBean(qcCaseBean);
            return  index;
        }else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String uniqueSerialNo = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            //String uniqueSerialNo = System.currentTimeMillis();
            qcCaseBean.setUniqueSerialNo(uniqueSerialNo);
            int index = iQcCaseService.insertQcCaseByBean(qcCaseBean);
            return  index;
        }
    }

}
