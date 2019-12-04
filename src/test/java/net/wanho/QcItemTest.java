package net.wanho;

import net.wanho.controller.QcItemController;
import net.wanho.mapper.BaseTest;
import net.wanho.pojo.QcItemBean;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by songb on 2019/10/9.
 */
public class QcItemTest extends BaseTest {
    @Resource
    private QcItemController qcItemController;
    private QcItemBean qcItemBean =new QcItemBean();

    @Test
    public void getQcItemPageByBeanTest(){
        List<QcItemBean> pageInfo = qcItemController.getQcItemPageByBean(qcItemBean);
        assertThat(pageInfo,notNullValue());
        //assertThat(true,pageInfo.size()>0);
    }

    @Test
    public void saveOrUpdateQcItemTest(){
        qcItemBean.setCode("1234");
        qcItemBean.setRemark("20191009");
        int i = qcItemController.saveOrUpdateQcItem(qcItemBean);
        assertEquals(1,i);
    }
    @Test
    public void saveOrUpdateQcItemTest2(){
        qcItemBean.setRemark("201910091628");
        int i = qcItemController.saveOrUpdateQcItem(qcItemBean);
        assertEquals(1,i);
    }

    @Test
    public void deleteQcItemTest(){
        qcItemBean.setCode("0a0b7631-3c4f-4dd5-a767-d9040a956fa5");
        int i = qcItemController.deleteQcItem(qcItemBean);
        assertEquals(i,1);
    }


}
