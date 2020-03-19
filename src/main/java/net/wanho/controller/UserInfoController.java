package net.wanho.controller;

import net.wanho.dto.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.pojo.UserInfoBean;
import net.wanho.pojo.UserInfoBean2;
import net.wanho.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @description: user
 * @author: Mr.songbeichang
 * @create: 2020-02-08 15:08
 **/
@Controller
@CrossOrigin("*")
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/searchUserInfo",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<UserInfoBean> searchUserInfo(@ModelAttribute("userInfoBean")UserInfoBean userInfoBean){
        ResultBean<UserInfoBean> rb = new ResultBean<>();
        try {
            List<UserInfoBean> list = userInfoService.searchUserInfo(userInfoBean);
            if(list!=null && list.size()>0){
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                rb.setRows(list);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
            }else {
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb ;
    }



    @RequestMapping(value = "/deleteUserInfo",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<UserInfoBean> deleteUserInfo(@ModelAttribute("userInfoBean")UserInfoBean userInfoBean){
        ResultBean<UserInfoBean> rb = new ResultBean<>();
        try {
            int  index = userInfoService.deleteUserInfo(userInfoBean);
            if(index>0){
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
            }else {
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb ;
    }


    @RequestMapping(value = "/addOrUpdateUserInfo",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<UserInfoBean> addOrUpdateUserInfo(@ModelAttribute("userInfoBean")UserInfoBean userInfoBean){
        ResultBean<UserInfoBean> rb = new ResultBean<>();
        try {
            int index ;
            if(userInfoBean.getUserCode()!=null && userInfoBean.getUserCode()!=""){
               index = userInfoService.updateUserInfo(userInfoBean);
            }else{
                userInfoBean.setUserCode(UUID.randomUUID().toString().substring(1,4));
                index = userInfoService.addUserInfo(userInfoBean);
            }
            if(index>0){
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
            }else {
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb ;
    }


    @RequestMapping(value = "/searchUserInfo2",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<UserInfoBean2> searchUserInfo2(@ModelAttribute("userInfoBean2")UserInfoBean2 userInfoBean2){
        ResultBean<UserInfoBean2> rb = new ResultBean<>();
        try {
            List<UserInfoBean2> list = userInfoService.searchUserInfo2(userInfoBean2);
            if(list!=null && list.size()>0){
                rb.setRows(list);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }else {
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }
        return rb ;
    }
}



