package net.wanho.service.impl;

import net.wanho.mapper.UserInfoMapper;
import net.wanho.pojo.UserInfoBean;
import net.wanho.pojo.UserInfoBean2;
import net.wanho.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Mr.songbeichang
 * @create: 2020-02-08 15:31
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoBean> searchUserInfo(UserInfoBean userInfoBean) {
        return userInfoMapper.searchUserInfo(userInfoBean);
    }

    @Override
    public int deleteUserInfo(UserInfoBean userInfoBean) {
        return userInfoMapper.deleteUserInfo(userInfoBean);
    }

    @Override
    public int updateUserInfo(UserInfoBean userInfoBean) {
        return userInfoMapper.updateUserInfo(userInfoBean);
    }

    @Override
    public int addUserInfo(UserInfoBean userInfoBean) {
        return userInfoMapper.addUserInfo(userInfoBean);
    }

    @Override
    public List<UserInfoBean2> searchUserInfo2(UserInfoBean2 userInfoBean2) {
        return userInfoMapper.searchUserInfo2(userInfoBean2);
    }

}



