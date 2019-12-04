package net.wanho.controller;

import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.service.IeTreeService;
import org.apache.taglibs.standard.tag.el.core.SetTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
@Controller
@RequestMapping("/eTree")
@CrossOrigin("*")
public class eTreeController {
    @Resource
    private IeTreeService ieTreeService;

    @RequestMapping(value = "/getRobotNavigationTree",method = {RequestMethod.GET})
    @ResponseBody
    public RobotNavigationTreeNodeBean getRobotNavigationTree(){
        List<RobotNavigationTreeNodeBean> pageInfo = ieTreeService.getRobotNavigationTree();
        RobotNavigationTreeNodeBean rb = new RobotNavigationTreeNodeBean();
        rb.setId("0");              //id,test,content是否可以自己设置字段
        rb.setText("根目录");
        rb.setChildren(pageInfo);
        return  rb;
    }
}
