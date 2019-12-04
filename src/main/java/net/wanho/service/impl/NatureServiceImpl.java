package net.wanho.service.impl;

import net.wanho.mapper.NatureMapper;
import net.wanho.pojo.NatureBean;
import net.wanho.service.INatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
@Service
public class NatureServiceImpl implements INatureService {
    @Autowired
    private NatureMapper natureMapper;

    @Override
    public List<NatureBean> getNature(NatureBean natureBean) {
        return natureMapper.getNature(natureBean);
    }
}
