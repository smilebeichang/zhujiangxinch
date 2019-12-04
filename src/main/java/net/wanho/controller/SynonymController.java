package net.wanho.controller;

import net.wanho.pojo.RandomUtil;
import net.wanho.pojo.RbSynonymConfigBean;
import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.service.RbSynonymConfigServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by songb on 2019/10/6.
 */
@Controller
@RequestMapping(value = "/synonym")
@CrossOrigin(origins = "*")
public class SynonymController {
    @Resource
    private RbSynonymConfigServiceI rbSynonymConfigServiceI;

    /**
    * @Description: 
    * @Param: 
    * @return: 
    * @Author: Mr.SongBeichang
    * @Date: 2019/12/1
    */
    @RequestMapping(value = "/getRbSynonymConfigs",method = {RequestMethod.POST})
    @ResponseBody
    public ResultBean<RbSynonymConfigBean> getRbSynonymConfigs(RbSynonymConfigBean rbSynonymConfigBean){
        ResultBean<RbSynonymConfigBean> rb = new ResultBean<>();
        List<RbSynonymConfigBean> pageinfo = rbSynonymConfigServiceI.getRbSynonymConfigs(rbSynonymConfigBean);
        rb.setRows(pageinfo);
        rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
        return rb;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/saveOrUpdateRbSynonymConfig",method = {RequestMethod.GET})
    @ResponseBody
    public void saveOrUpdateRbSynonymConfig(@ModelAttribute()RbSynonymConfigBean rbSynonymConfigBean,@RequestParam(required = false) String code){

        if(rbSynonymConfigBean.getCode()!=null&&!rbSynonymConfigBean.getCode().isEmpty()){
            rbSynonymConfigServiceI.UpdateRbSynonymConfig(rbSynonymConfigBean);
        }else{
            rbSynonymConfigBean.setCreateDate(new Date());
            rbSynonymConfigBean.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0,9));
            rbSynonymConfigBean.setStatus("1");
            rbSynonymConfigServiceI.saveRbSynonymConfig(rbSynonymConfigBean);
        }
    }

    @RequestMapping(value = "/deleteSynonym",method = {RequestMethod.POST})
    @ResponseBody
    public void deleteSynonym(@RequestParam(required = false) String code){

        rbSynonymConfigServiceI.deleteSynonym(code);

    }
}
