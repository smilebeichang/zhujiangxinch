package net.wanho.controller;

import net.wanho.pojo.NatureBean;
import net.wanho.service.INatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
@Controller
@RequestMapping("/nature")
public class NatureController {
    @Autowired
    private INatureService iNatureService;

    @RequestMapping(value = "/getNatures",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin(origins="*")
    public List<NatureBean> getNatures(@ModelAttribute("NatureBean") NatureBean natureBean){
        List<NatureBean> pageInfo = iNatureService.getNature(natureBean);
        return  pageInfo;
    }
}
