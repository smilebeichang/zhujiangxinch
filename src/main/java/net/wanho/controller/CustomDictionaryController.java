package net.wanho.controller;

import net.wanho.pojo.CustomDictionaryBean;
import net.wanho.service.ICustomDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/10/9.
 */
@Controller
@RequestMapping("/customDictionary")
public class CustomDictionaryController {
    @Autowired
    private ICustomDictionaryService iCustomDictionaryService;

    @RequestMapping(value = "/getCustomDictionarys",method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin("*")
    public List<CustomDictionaryBean> getCustomDictionarys(CustomDictionaryBean customDictionaryBean){
        List<CustomDictionaryBean> pageInfo = iCustomDictionaryService.getCustomDictionarys(customDictionaryBean);
        return  pageInfo;
    }


    @RequestMapping(value = "/addConfig",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin("*")
    public int addConfig(@ModelAttribute("CustomDictionaryBean") CustomDictionaryBean customDictionaryBean){
        if (customDictionaryBean.getCode()!=null && customDictionaryBean.getCode()!=""){
            int uIndex = iCustomDictionaryService.updateConfig(customDictionaryBean);
            return uIndex;
        }else{
            String code = UUID.randomUUID().toString().substring(0,8);
            customDictionaryBean.setCode(code);
            customDictionaryBean.setStatus("2");
            int sIndex = iCustomDictionaryService.saveConfig(customDictionaryBean);
            return sIndex;
        }
    }

    @RequestMapping(value = "/deleteCustomDictionary",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin("*")
    public int deleteCustomDictionary(@ModelAttribute("CustomDictionaryBean") CustomDictionaryBean customDictionaryBean){
        return iCustomDictionaryService.deleteCustomDictionary(customDictionaryBean);

    }
}
