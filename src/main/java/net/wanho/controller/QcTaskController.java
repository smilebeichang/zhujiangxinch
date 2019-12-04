package net.wanho.controller;

import net.wanho.pojo.QcTaskExtBean;
import net.wanho.service.IQcTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/25.
 */
@Controller
@RequestMapping("/qcTask")
@CrossOrigin("*")
public class QcTaskController {
    @Resource
    private IQcTaskService qcTaskService;

    @RequestMapping(value = "/getQcTaskListByBean",method = {RequestMethod.POST})
    @ResponseBody
    public List<QcTaskExtBean> getQcTaskListByBean(@ModelAttribute("QcTaskExtBean")QcTaskExtBean qcTaskExtBean){
        List<QcTaskExtBean> pageInfo = qcTaskService.getQcTaskListByBean(qcTaskExtBean);
        return  pageInfo;
    }
}
