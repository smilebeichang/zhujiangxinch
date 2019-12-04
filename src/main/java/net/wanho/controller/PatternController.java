package net.wanho.controller;

import net.wanho.pojo.Pattern;
import net.wanho.service.IPatternService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/1.
 */
@Controller
@RequestMapping("/pattern")
@CrossOrigin("*")
public class PatternController {
    @Resource
    private IPatternService patternService;

    @RequestMapping(value = "/getPatterns",method = {RequestMethod.GET})
    @ResponseBody
    public List<Pattern> getPatterns(@ModelAttribute("pattern") Pattern pattern){
        List<Pattern> pageInfo = patternService.getPatterns(pattern);
        return  pageInfo;
    }
}
