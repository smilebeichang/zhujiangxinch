package net.wanho.service.impl;

import net.wanho.mapper.RobotNavigationMapper;
import net.wanho.pojo.NavigationInfoBean;
import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.service.IRobotNavigationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/31.
 */
@Service
public class RobotNavigationServiceImpl implements IRobotNavigationService {
    @Resource
    private RobotNavigationMapper robotNavigationMapper;


    @Override
    public List<RobotNavigationTreeNodeBean> getRobotNavigationTree(RobotNavigationTreeNodeBean robotNavigationTreeNodeBean) throws Exception {
        List<RobotNavigationTreeNodeBean> roots = robotNavigationMapper.searchNavigationManage(robotNavigationTreeNodeBean);
        //这样的话，即使我没有改变数据库数据，也能获得想要结果
        for(RobotNavigationTreeNodeBean p:roots){
            p.setParentCode("0");
            getChildrens(p);
            //或者可以直接查询然后塞进去
            //List<RobotNavigationTreeNodeBean> childrens = robotNavigationMapper.getRobotNavigationByParentCode(p.getCode());
            //p.setChildren(childrens);
        }
        return roots;
    }

    public void getChildrens(RobotNavigationTreeNodeBean robotNavigationTreeNodeBean) throws Exception {
        List<RobotNavigationTreeNodeBean> childrens=this.getRobotNavigationByParentCode(robotNavigationTreeNodeBean.getCode());
        //一级节点字段list塞二级节点
        if(childrens!=null){
            robotNavigationTreeNodeBean.setChildren(childrens);
            //导航树只允许2级无需递归查询
        }
    }
    public List<RobotNavigationTreeNodeBean> getRobotNavigationByParentCode(String parentCode)  throws Exception{
        return  robotNavigationMapper.getRobotNavigationByParentCode(parentCode);
    }
}
