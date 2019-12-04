package net.wanho.service;


import com.github.pagehelper.PageInfo;
import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.BatchTestDetailBean;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * 批量测试服务类
 * @author songjianfeng
 * @date 2019-08-22
 */
public interface IBatchTestService {

	/**
	 * 批量测试翻页查询
	 *
	 * @param batchTestBean
	 * @return
	 */
	List<BatchTestBean> getBatchTestPage(BatchTestBean batchTestBean);


	List<BatchTestBean> findAll();

	int insert(BatchTestBean batchTestBean);

	 boolean update(BatchTestBean batchTestBean);

	void delete(BatchTestBean batchTestBean);

    List<BatchTestDetailBean> getBatchTestDetailPage(BatchTestBean batchTestBean);

    int addBatchTestDetail(List<BatchTestDetailBean> list);
}