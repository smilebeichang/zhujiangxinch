package net.wanho.controller;

import net.wanho.pojo.PatternConfig;
import net.wanho.service.IPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
@Controller
@RequestMapping("/patternConfig")
public class PatternConfigController {
    @Autowired
    private IPatternService iPatternService;


    @RequestMapping(value = "/getPatternConfigs",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<PatternConfig> getPatternConfigs(@ModelAttribute("PatternConfig")PatternConfig patternConfig){
        List<PatternConfig> pageInfo = iPatternService.getPatternConfigs(patternConfig);
        return pageInfo;
    }

}
