package net.wanho.pojo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by songb on 2019/11/5.
 */
public final class SysConstant implements ApplicationContextAware {
    protected static Log logger = LogFactory.getLog(SysConstant.class);
    public static ApplicationContext application;
    public static String FILE_SEPARATOR = System.getProperty("file.separator");
    public static Properties config = new Properties();
    public static final String SYS_ACCOUNT_DEFAULT_PASWORD = "123456";
    public static final String SYS_RETURN_SUCCESS_CODE = "0000";
    public static final String SYS_RETURN_SUCCESS_MESSAGE = "操作成功";
    public static final String SYS_RETURN_FAILED_CODE = "F999";
    public static final String SYS_RETURN_FAILED_MESSAGE = "操作失败";
    public static final String SYS_RETURN_NO_DATA_CODE = "F990";
    public static final String SYS_RETURN_NO_DATA_MESSAGE = "没返回数据";
    public static final String SYS_RETURN_EXCEPTION_CODE = "EEEE";
    public static final String SYS_SESSION_EXCEPTION_CODE = "E001";
    public static final String SYS_SESSION_EXCEPTION_MESSAGE = "非法会话";
    public static final String SYS_GET_CACHE_ROLE_ERROR_CODE = "E002";
    public static final String SYS_GET_CACHE_ROLE_ERROR_MESSAGE = "获取缓存角色权限失败";
    public static final String UOMP_ACCOUNT_PASSWORD_FAILED_CODE = "F001";
    public static final String UOMP_ACCOUNT_PASSWORD_FAILED_MESSAGE = "登录密码有误";
    public static final String UOMP_ACCOUNT_PASSWORD_OUT_OF_DATE_CODE = "F007";
    public static final String UOMP_ACCOUNT_PASSWORD_OUT_OF_DATE_MESSAGE = "用户密码过期";
    public static final String UOMP_ACCOUNT_NOT_EXIST_CODE = "F002";
    public static final String UOMP_ACCOUNT_NOT_EXIST_MESSAGE = "用户异常或用户不存在";
    public static final String UOMP_ACCOUNT_EXIST_CODE = "F003";
    public static final String UOMP_ACCOUNT_EXIST_MESSAGE = "用户号已存在";
    public static final String UOMP_EMP_NOT_EXIST_CODE = "F004";
    public static final String UOMP_EMP_NOT_EXIST_MESSAGE = "员工不存在";
    public static final String UOMP_EMP_EXIST_CODE = "F005";
    public static final String UOMP_EMP_EXIST_MESSAGE = "员工已存在";
    public static final String UOMP_GET_ROLE_FAILED_CODE = "F006";
    public static final String UOMP_GET_ROLE_FAILED_MESSAGE = "获取用户角色失败";
    public static final String OMNICHAT_JOIN_QUEUE_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_JOIN_QUEUE_SUCCESS_MESSAGE = "加入队列成功";
    public static final String OMNICHAT_EXIT_QUEUE_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_EXIT_QUEUE_SUCCESS_MESSAGE = "退出队列成功";
    public static final String OMNICHAT_JOIN_QUEUE_FAILED_CODE = "OCHAT999";
    public static final String OMNICHAT_JOIN_QUEUE_FAILED_MESSAGE = "加入队列失败";
    public static final String OMNICHAT_EXIT_QUEUE_FAILED_CODE = "OCHAT888";
    public static final String OMNICHAT_EXIT_QUEUE_FAILED_MESSAGE = "退出队列失败";
    public static final String OMNICHAT_QUEUE_CODE_FAILED_CODE = "OCHAT_F_0001";
    public static final String OMNICHAT_QUEUE_CODE_FAILED_MESSAGE = "队列编码无效";
    public static final String OMNICHAT_QUEUE_EXCEPTION_CODE = "OCHAT_E_0001";
    public static final String OMNICHAT_QUEUE_EXCEPTION_MESSAGE = "队列异常";
    public static final String OMNICHAT_AGENT_CHECKIN_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_AGENT_CHECKIN_SUCCESS_MESSAGE = "座席签入成功";
    public static final String OMNICHAT_AGENT_CHECKIN_FAILED_CODE = "OCHAT_F_0002";
    public static final String OMNICHAT_AGENT_CHECKIN_FAILED_MESSAGE = "座席签入失败";
    public static final String OMNICHAT_AGENT_CHECKOUT_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_AGENT_CHECKOUT_SUCCESS_MESSAGE = "座席签出成功";
    public static final String OMNICHAT_AGENT_CHECKOUT_FAILED_CODE = "OCHAT_F_0003";
    public static final String OMNICHAT_AGENT_CHECKOUT_FAILED_MESSAGE = "座席签出失败";
    public static final String OMNICHAT_GET_QUEUE_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_GET_QUEUE_SUCCESS_MESSAGE = "获取队列信息成功";
    public static final String OMNICHAT_GET_QUEUE_FAILED_CODE = "OCHAT_F_0004";
    public static final String OMNICHAT_GET_QUEUE_FAILED_MESSAGE = "获取队列信息失败";
    public static final String OMNICHAT_NO_QUEUE_DATA_CODE = "OCHAT_F_0005";
    public static final String OMNICHAT_NO_QUEUE_DATA_MESSAGE = "没有队列信息";
    public static final String OMNICHAT_AGENT_CHANGE_STATUS_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_AGENT_CHANGE_STATUS_SUCCESS_MESSAGE = "座席改变状态成功";
    public static final String OMNICHAT_AGENT_CHANGE_STATUS_FAILED_CODE = "OCHAT_F_0006";
    public static final String OMNICHAT_AGENT_CHANGE_STATUS_FAILED_MESSAGE = "座席改变状态失败";
    public static final String OMNICHAT_SESSION_CLOSE_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_SESSION_CLOSE_SUCCESS_MESSAGE = "会话结束成功";
    public static final String OMNICHAT_SESSION_CLOSE_FAILED_CODE = "OCHAT_F_0007";
    public static final String OMNICHAT_SESSION_CLOSE_FAILED_MESSAGE = "会话结束失败";
    public static final String OMNICHAT_AGENT_SET_MAX_CONN_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_AGENT_SET_MAX_CONN_SUCCESS_MESSAGE = "设置座席最大连接数成功";
    public static final String OMNICHAT_AGENT_SET_MAX_CONN_FAILED_CODE = "OCHAT_F_0008";
    public static final String OMNICHAT_AGENT_SET_MAX_CONN_FAILED_MESSAGE = "设置座席最大连接数失败 ";
    public static final String OMNICHAT_GET_AGENT_STATUS_SUCCESS_CODE = "0000";
    public static final String OMNICHAT_GET_AGENT_STATUS_MESSAGE = "获取座席状态成功";
    public static final String OMNICHAT_GET_AGENT_STATUS_FAILED_CODE = "OCHAT_F_0009";
    public static final String OMNICHAT_GET_AGENT_STATUS_FAILED_MESSAGE = "获取座席状态失败";
    public static final String MRC_AGENT_HASH_KEY = "MRC_AGENTS_HASH_MAP";
    public static final String MRC_SKILLGROUP_KEY = "MRC_SKILLGROUP";
    public static final String MRC_CUSTOMER_KEY = "MRC_CUSTOMER";
    public static final String MRC_ROOM_HASH_KEY = "MRC_ROOM_HASH_MAP";
    public static final String ACCOUNT_PERMISSIONS_HASH_KEY = "PERMISSIONS_HASH_MAP";
    public static final String ACCOUNT_PASSWORD_ERROR_KEY = "ACCOUNT_PASSWORD_ERROR";
    public static final String UOMP_WEBSOCKET = "UOMP_SOCKET";
    public static Map<String, Object> dictionaryPool;

    public SysConstant() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    public static String getServerIP() {
        String netip = null;
        String localip = null;

        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;

            while(netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration address = ni.getInetAddresses();

                while(address.hasMoreElements()) {
                    ip = (InetAddress)address.nextElement();
                    if(!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    }

                    if(ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                        localip = ip.getHostAddress();
                    }
                }
            }

            return netip != null && !"".equals(netip)?netip:localip;
        } catch (Exception var7) {
            logger.error("获取本地IP地址发生未知异常:{}", var7);
            return null;
        }
    }



    public static Object getBadwordPool() {
        return null;
    }

    static {
        try {
            InputStreamReader in = new InputStreamReader(SysConstant.class.getClassLoader().getResourceAsStream("SysConstant.properties"), "UTF-8");
            config.load(in);
            in.close();
        } catch (IOException var1) {
            ;
        }

        if(config != null) {
            ;
        }

        dictionaryPool = new HashMap();
    }
}
