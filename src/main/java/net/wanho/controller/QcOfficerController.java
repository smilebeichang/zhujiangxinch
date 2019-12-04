package net.wanho.controller;

import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.QcOfficerBean;
import net.wanho.service.IBatchTestService;
import net.wanho.service.QcOfficerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/qcOfficer")
public class QcOfficerController {
    @Resource
    private QcOfficerService qcOfficerService ;


    /**
     * 批量测试翻页查询
     * @param qcOfficerBean
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getQcOfficerPageByBean", method = { RequestMethod.GET })
    @ResponseBody
    public List<QcOfficerBean> getQcOfficerPageByBean(@ModelAttribute("QcOfficerBean") QcOfficerBean qcOfficerBean)  {

        List<QcOfficerBean> pageinfo =qcOfficerService.getQcOfficerPageByBean(qcOfficerBean);
        return pageinfo;
    }

    //新增
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insertQC", method = { RequestMethod.GET })
    @ResponseBody
    public int insertQC(@ModelAttribute("QcOfficerBean") QcOfficerBean qcOfficerBean)  {
        if(qcOfficerBean.getCode()!=null &&  !qcOfficerBean.getCode().isEmpty()){
            boolean b = qcOfficerService.updateQC(qcOfficerBean);
            if(b){
                return 0;
            }
        }
        int result =qcOfficerService.insertQC(qcOfficerBean);
        return result;
    }


    //新增
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteQc", method = { RequestMethod.GET })
    @ResponseBody
    public int deleteQc(@ModelAttribute("QcOfficerBean") QcOfficerBean qcOfficerBean)  {
        int result =qcOfficerService.deleteQc(qcOfficerBean);
        return result;
    }
}
