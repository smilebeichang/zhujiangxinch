package net.wanho.controller;

import net.wanho.pojo.RbSceneLineRegularBean;
import net.wanho.pojo.ResultBean;
import net.wanho.service.IRbSceneLineRegularService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by songb on 2019/11/8.
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/rbSceneLineRegular")
public class RbSceneLineRegularController {
    @Resource
    private IRbSceneLineRegularService rbSceneLineRegularService;

    @RequestMapping(value = "/selectRbSceneLineRegular",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RbSceneLineRegularBean> selectRbSceneLineRegular (@ModelAttribute("rbSceneLineRegularBean")RbSceneLineRegularBean rbSceneLineRegularBean){
        List<RbSceneLineRegularBean> pageInfo = rbSceneLineRegularService.selectRbSceneLineRegular(rbSceneLineRegularBean);
        ResultBean<RbSceneLineRegularBean> rb = new ResultBean();
        rb.setRows(pageInfo);
        return  rb;
    }


    @RequestMapping(value = "/addLineRegularBatch",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RbSceneLineRegularBean> addLineRegularBatch (@RequestBody Map<String,List<RbSceneLineRegularBean>> regulars){
        ResultBean<RbSceneLineRegularBean> rb = new ResultBean();
        int index = rbSceneLineRegularService.addLineRegularBatch(regulars.get("add"));
        rbSceneLineRegularService.updateLineRegularBatch(regulars.get("update"));
        rb.setTotal((long) index);
        return  rb;
    }
}
