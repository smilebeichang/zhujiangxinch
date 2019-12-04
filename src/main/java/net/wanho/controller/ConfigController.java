package net.wanho.controller;

import net.wanho.pojo.ConfigBean;
import net.wanho.service.IConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/10/30.
 */
@Controller
@RequestMapping("/config")
@CrossOrigin("*")
public class ConfigController {
    @Resource
    private IConfigService configService;

    @RequestMapping(value = "/getConfig",method = {RequestMethod.POST})
    @ResponseBody
    public List<ConfigBean> getConfig(@ModelAttribute("configBean")ConfigBean configBean){
        List<ConfigBean> pageInfo = configService.getConfig(configBean);
        return pageInfo;
    }
}
