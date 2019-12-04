package net.wanho.controller;

import net.wanho.pojo.RobotFileInfoBean;
import net.wanho.service.RobotFileServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/9/30.
 */
@CrossOrigin
@Controller
@RequestMapping("/robotFile")
public class RobotFileController {
    @Resource
    private RobotFileServiceI robotFileServiceI;

    @RequestMapping(value = "/selectRobotFilePageByBean",method = {RequestMethod.GET})
    @ResponseBody
    public List<RobotFileInfoBean> selectRobotFilePageByBean(RobotFileInfoBean robotFileInfoBean){
        List<RobotFileInfoBean> pageinfo = robotFileServiceI.selectRobotFilePageByBean(robotFileInfoBean);
        return pageinfo;
    }




}
