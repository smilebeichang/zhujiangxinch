package net.wanho.service.impl;


import net.wanho.mapper.BatchTestMapper;
import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.BatchTestDetailBean;
import net.wanho.service.IBatchTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 批量测试服务类
 * @author songjianfeng
 */
@Service("batchTestService")
public  class  BatchTestServiceImpl  implements IBatchTestService {


	@Autowired
	private BatchTestMapper batchTestMapper;

	@Override
	public List<BatchTestBean> getBatchTestPage(BatchTestBean batchTestBean){
		return batchTestMapper.getBatchTestPage(batchTestBean);
	}

	@Override
	public List<BatchTestBean> findAll() {
		return batchTestMapper.findAll();
	}

    @Override
    public int insert(BatchTestBean batchTestBean) {
        return batchTestMapper.insert(batchTestBean);
    }

	@Override
	public  boolean update(BatchTestBean batchTestBean) {
		return batchTestMapper.update(batchTestBean);
	}

	@Override
	public void delete(BatchTestBean batchTestBean) {
		batchTestMapper.delete(batchTestBean);
	}

    @Override
    public List<BatchTestDetailBean> getBatchTestDetailPage(BatchTestBean batchTestBean) {
        return batchTestMapper.getBatchTestDetailPage(batchTestBean);
    }

    @Override
    public int addBatchTestDetail(List<BatchTestDetailBean> list) {
        return batchTestMapper.addBatchTestDetail(list);
    }

}
