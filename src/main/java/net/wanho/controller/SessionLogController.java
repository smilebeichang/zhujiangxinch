package net.wanho.controller;

import net.wanho.pojo.ResultBean;
import net.wanho.pojo.RobotConversationLogBean;
import net.wanho.pojo.SessionLog;
import net.wanho.pojo.SysConstant;
import net.wanho.service.ISessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
@CrossOrigin
@Controller
@RequestMapping("sessionLog")
public class SessionLogController  {
    @Autowired
    private ISessionLogService iSessionLogService;


    /*
    *    Java中String类型转换成数据库中的日期类型，添加到数据库
      //创建sdf对象，指定日期格式类型
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//sdf将字符串转化成java.util.Date
	java.util.Date parse=null;
	try {
		parse = sdf.parse(date);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	//java.util.Date转换成long
	long time = parse.getTime();

	//将long转换为java.sql.Date
	Date date2 = new Date(time);
    * */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/selectSessionLogByBean",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RobotConversationLogBean> selectSessionLogByBean (@ModelAttribute("RobotConversationLogBean") RobotConversationLogBean robotConversationLogBean){
            ResultBean<RobotConversationLogBean> rb = new ResultBean<RobotConversationLogBean>();

            List<RobotConversationLogBean> pageinfo;
            try {
                pageinfo = iSessionLogService.selectSessionLogByBean(robotConversationLogBean);
                if(pageinfo!=null && pageinfo.size()>0){
                    rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                    rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                    rb.setRows(pageinfo);
                    rb.setTotal((long) pageinfo.size());
                }else{
                    rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                    rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
                rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
            }
            return rb;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getSessionLogs",method = {RequestMethod.GET})
    @ResponseBody
    public List<SessionLog> getSessionLogs (@ModelAttribute()  SessionLog sessionLog){
        List<SessionLog> pageinfo = iSessionLogService.getSessionLogs(sessionLog);
        return  pageinfo;
    }



}
