package net.wanho.mapper;

import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.BatchTestDetailBean;

import java.util.List;

/**
 * @author SONGBEICHANG
 * Created by songb on 2019/9/26.
 */
public interface BatchTestMapper {
    List<BatchTestBean> getBatchTestPage(BatchTestBean batchTestBean);

    List<BatchTestBean> findAll();

    int insert(BatchTestBean batchTestBean);

    boolean update(BatchTestBean batchTestBean);

    void delete(BatchTestBean batchTestBean);

    List<BatchTestDetailBean> getBatchTestDetailPage(BatchTestBean batchTestBean);

    int addBatchTestDetail(List<BatchTestDetailBean> list);
}
