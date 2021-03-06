package net.wanho.mapper;

import net.wanho.pojo.UserInfoBean;
import net.wanho.pojo.UserInfoBean2;

import java.util.List;

/**
 * @description:
 * @author: Mr.songbeichang
 * @create: 2020-02-08 15:33
 **/
public interface UserInfoMapper {
    List<UserInfoBean> searchUserInfo(UserInfoBean userInfoBean);

    int deleteUserInfo(UserInfoBean userInfoBean);

    int updateUserInfo(UserInfoBean userInfoBean);

    int addUserInfo(UserInfoBean userInfoBean);

    List<UserInfoBean2> searchUserInfo2(UserInfoBean2 userInfoBean2);
}



