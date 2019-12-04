package net.wanho.mapper;

import net.wanho.pojo.RobotConversationLogBean;
import net.wanho.pojo.SessionLog;

import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
public interface SessionLogMapper {
    List<RobotConversationLogBean> selectSessionLogByBean(RobotConversationLogBean robotConversationLogBean);

    List<SessionLog> getSessionLogs(SessionLog sessionLog);
}
