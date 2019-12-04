package net.wanho.service.impl;

import net.wanho.mapper.SessionLogMapper;
import net.wanho.pojo.RobotConversationLogBean;
import net.wanho.pojo.SessionLog;
import net.wanho.service.ISessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/9/29.
 */
@Service
public class SessionLogServiceImpl implements ISessionLogService {
    @Autowired
    private SessionLogMapper sessionLogMapper;
    @Override
    public List<RobotConversationLogBean> selectSessionLogByBean(RobotConversationLogBean robotConversationLogBean) {
        return sessionLogMapper.selectSessionLogByBean(robotConversationLogBean);
    }

    @Override
    public List<SessionLog> getSessionLogs(SessionLog sessionLog) {
        return sessionLogMapper.getSessionLogs(sessionLog);
    }
}
