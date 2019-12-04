package net.wanho.controller;

import net.wanho.pojo.RbSceneModelBean;
import net.wanho.pojo.ResultBean;
import net.wanho.service.IRbSceneModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songb on 2019/11/8.
 */
@Controller
@RequestMapping("/rbSceneModel")
@CrossOrigin("*")
public class RbSceneModelController {
    @Resource
    private IRbSceneModelService rbSceneModelService;

    @RequestMapping(value = "/selectRbSceneModelPageByBean",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RbSceneModelBean> selectRbSceneModelPageByBean(@ModelAttribute("rbSceneModelBean")RbSceneModelBean rbSceneModelBean){
        ResultBean<RbSceneModelBean> rb = new ResultBean();
        List<RbSceneModelBean> pageInfo = rbSceneModelService.selectRbSceneModelPageByBean(rbSceneModelBean);
        rb.setRows(pageInfo);
        return rb;
    }

}
