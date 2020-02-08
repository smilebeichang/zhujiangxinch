package net.wanho.service;

import net.wanho.pojo.UserInfoBean;

import java.util.List;

/**
 * Created by songb on 2020/2/8.
 */
public interface IUserInfoService {
    List<UserInfoBean> searchUserInfo(UserInfoBean userInfoBean);

    int deleteUserInfo(UserInfoBean userInfoBean);

    int updateUserInfo(UserInfoBean userInfoBean);

    int addUserInfo(UserInfoBean userInfoBean);
}
