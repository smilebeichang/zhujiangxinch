package net.wanho.service.impl;

import net.wanho.mapper.QcTemplate2Mapper;
import net.wanho.pojo.RobotNavigationTreeNodeBean;
import net.wanho.pojo.TemplateBean2;
import net.wanho.service.IQcTemplate2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by songb on 2019/11/12.
 */
@Service
public class QcTemplate2Impl implements IQcTemplate2Service {
    @Resource
    private QcTemplate2Mapper qcTemplate2Mapper;

    @Override
    public List<TemplateBean2> searchByBean(TemplateBean2 templateBean2) {
        return qcTemplate2Mapper.searchByBean(templateBean2);
    }

    @Override
    public int update1(TemplateBean2 templateBean2) {
        return qcTemplate2Mapper.update1(templateBean2);
    }

    @Override
    public int add1(TemplateBean2 templateBean2) {
        return qcTemplate2Mapper.add1(templateBean2);
    }

    @Override
    public int delete1(TemplateBean2 templateBean2) {
        return qcTemplate2Mapper.delete1(templateBean2);
    }

    @Override
    public List<RobotNavigationTreeNodeBean> searchTree() throws Exception {
        List<RobotNavigationTreeNodeBean> pageInfo = qcTemplate2Mapper.searchRootTree();

        //增强for循环
        /*for (RobotNavigationTreeNodeBean p:pageInfo ) {
            p.setParentCode("0");
            p.setChildren(this.searchChildrenTree(p.getCode()));
        }*/
        //迭代器
        /*Iterator<RobotNavigationTreeNodeBean> it=pageInfo.iterator();
        while(it.hasNext()) {
            it.setParentCode("0");
            it.setChildren(this.searchChildrenTree(it.getCode()));
        }*/

        //使用lambda表达式写法一
        pageInfo.forEach(str->str.setParentCode("0"));
        pageInfo.forEach(str->str.setChildren(this.searchChildrenTree(str.getCode())));
        return pageInfo;
    }


    public List<RobotNavigationTreeNodeBean> searchChildrenTree(String parentCode) {

        return qcTemplate2Mapper.searchChildrenTree(parentCode);
    }



}
