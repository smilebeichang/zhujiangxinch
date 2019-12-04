package net.wanho;

import net.wanho.controller.QcOfficerController;
import net.wanho.mapper.BaseTest;
import net.wanho.mapper.QcOfficerMapper;
import net.wanho.pojo.AutowriedConfig;
import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.QcOfficerBean;
import net.wanho.service.IBatchTestService;
import net.wanho.service.QcOfficerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by songb on 2019/10/8.
 */

public class QCOfficerTest extends BaseTest {
    private QcOfficerBean qcOfficerBean = new QcOfficerBean();
    @Resource
    private QcOfficerService qcOfficerService; //注意，这里要用接口，因为用到了spring的AOP
    @Resource
    private QcOfficerMapper qcOfficerMapper;  //Dao层上的测试
    @Resource
    private QcOfficerController qcOfficerController; //Controller层测试
    /*@Autowired
    private QcOfficerBean qcOfficerBean;*/

    /*private AnnotationConfigApplicationContext  annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AutowriedConfig.class);
    QcOfficerBean qcOfficerBean = annotationConfigApplicationContext.getBean(QcOfficerBean.class);*/




    @Test
    public void getQcOfficerPageByBeanTest(){
        List<QcOfficerBean> all = qcOfficerService.getQcOfficerPageByBean(qcOfficerBean);
        assertThat(all,notNullValue());
    }

    @Test
    public  void insertQCTest(){
        qcOfficerBean.setCode("carry");   //到这一步就报错了，空指针
        qcOfficerBean.setOfficerName("carry");
        qcOfficerBean.setRemark("carry");
        int index = qcOfficerService.insertQC(qcOfficerBean);
        Assert.assertEquals(1,index);
    }

    @Test
    public  void updateQCTest(){
        qcOfficerBean.setCode("123123");   //到这一步就报错了，空指针
        qcOfficerBean.setOfficerName("carry2");
        qcOfficerBean.setRemark("carry2");
        boolean b = qcOfficerService.updateQC(qcOfficerBean);
        Assert.assertEquals(true,b);
    }

    @Test
    public  void deleteQcTest(){
        qcOfficerBean.setCode("123124");   //到这一步就报错了，空指针
        int i = qcOfficerService.deleteQc(qcOfficerBean);
        assertThat(i,notNullValue());
    }

    @Test
    public void ControllerGetQcOfficerPageByBeanTest(){
        List<QcOfficerBean> all = qcOfficerController.getQcOfficerPageByBean(qcOfficerBean);
        assertThat(all,notNullValue());
    }

    @Test
    public  void ControllerUpdateQCTest(){
        qcOfficerBean.setCode("carry7");   //code有值，但数据库中不存在，所以执行update操作，然后返回false。
        qcOfficerBean.setOfficerName("carry5");
        qcOfficerBean.setRemark("carry5");
        int i = qcOfficerController.insertQC(qcOfficerBean);
        Assert.assertEquals(1,i);
    }

}
