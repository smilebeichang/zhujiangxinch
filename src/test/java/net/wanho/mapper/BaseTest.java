package net.wanho.mapper;

/**
 * Created by songb on 2019/10/8.
 */
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *@class_name：BatchTestMapper
 *@param:配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 *@return:
 *@createtime:2019年10月07日
 */
@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration("src/main/java")
// 告诉junit spring配置文件位置
@ContextConfiguration({ "classpath:spring/application-dao.xml", "classpath:spring/application-service.xml","classpath:spring/springmvc.xml"})
public class BaseTest {
}
