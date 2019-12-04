package net.wanho.service;

import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.pojo.TemplateBean2;

import java.util.List;

/**
 * Created by songb on 2019/11/12.
 */
public interface IQcTemplate2Service {
    List<TemplateBean2> searchByBean(TemplateBean2 templateBean2);

    int update1(TemplateBean2 templateBean2);

    int add1(TemplateBean2 templateBean2);

    int delete1(TemplateBean2 templateBean2);

    List<RobotNavigationTreeNodeBean> searchTree() throws Exception;
}
