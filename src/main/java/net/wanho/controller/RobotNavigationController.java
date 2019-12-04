package net.wanho.controller;

import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.service.IRobotNavigationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
@Controller
@RequestMapping("/robotNavigation")
@CrossOrigin("*")
public class RobotNavigationController {
    @Resource
    private IRobotNavigationService robotNavigationService;

    @RequestMapping(value = "getRobotNavigationTree",method = {RequestMethod.GET})
    @ResponseBody
    //页面传过来的 RobotNavigationTreeNodeBean  没有任何意义
    public RobotNavigationTreeNodeBean getRobotNavigationTree(@ModelAttribute("robotNavigationTreeNodeBean")RobotNavigationTreeNodeBean robotNavigationTreeNodeBean) throws Exception {
        List<RobotNavigationTreeNodeBean> pageInfo = robotNavigationService.getRobotNavigationTree(robotNavigationTreeNodeBean);
        //这样说来，我可以完美复制任何一个页面
        RobotNavigationTreeNodeBean bean1 = new RobotNavigationTreeNodeBean();
        bean1.setId("0");     //这一步和impl里的 p.setParentCode("0")相互对应
        bean1.setText("导航维护");
        bean1.setChildren(pageInfo);
        return bean1;
    }
}
