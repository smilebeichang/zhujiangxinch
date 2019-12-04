package net.wanho;

import net.wanho.mapper.BaseTest;
import net.wanho.pojo.BatchTestBean;
import net.wanho.service.IBatchTestService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by songb on 2019/10/8.
 */
public class BatchTest2 extends BaseTest {
    private BatchTestBean batchTestBean;
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
        /*User user=new User();*/
        batchTestBean.setCode("carry");   //到这一步就报错了，空指针
        int index = iBatchTestService.insert(batchTestBean);
        assertThat(index,nullValue());

    }

}
