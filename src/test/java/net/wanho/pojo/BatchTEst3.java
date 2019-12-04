package net.wanho.pojo;

import net.wanho.mapper.BaseTest;
import net.wanho.service.IBatchTestService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by songb on 2019/10/8.
 */
public class BatchTEst3 extends BaseTest {

    @Resource
    private IBatchTestService iBatchTestService; //注意，这里要用接口，因为用到了spring的AOP



    @Test
    public void findAllTest(){
        List<BatchTestBean> all = iBatchTestService.findAll();
        //assertThat(all,nullValue());
        assertThat(all,notNullValue());


    }

    @Test
    public  void insertTest(){
        BatchTestBean batchTestBean =new BatchTestBean();
        batchTestBean.setCode("carry2");   //到这一步就报错了，空指针
        int index = iBatchTestService.insert(batchTestBean);
        assertThat(index,notNullValue());
    }

    @Test
    public  void update(){
        BatchTestBean batchTestBean =new BatchTestBean();
        batchTestBean.setCode("carry2");   //到这一步就报错了，空指针
        batchTestBean.setName("carry2");   //到这一步就报错了，空指针
        batchTestBean.setChannelNo("carry2");   //到这一步就报错了，空指针
        boolean b = iBatchTestService.update(batchTestBean);
        Assert.assertEquals(b,true);
    }

    @Test
    public void deleteTest(){
        BatchTestBean batchTestBean = new BatchTestBean();
        batchTestBean.setCode("carry2");
        int flag = verInsertData(batchTestBean);
        Assert.assertEquals(1,flag);
    }


    public  int verInsertData(BatchTestBean batchTestBean) {
        int flag = 1;
        try {
            iBatchTestService.delete(batchTestBean);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return flag;
    }


}
