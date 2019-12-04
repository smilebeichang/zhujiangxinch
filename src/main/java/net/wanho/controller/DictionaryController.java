package net.wanho.controller;

import net.wanho.pojo.DictionaryBean;
import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songb on 2019/10/25.
 */
@Controller
@RequestMapping("/dictionary")
@CrossOrigin("*")
public class DictionaryController {
    @Resource
    private IDictionaryService dictionaryService;

    @RequestMapping(value = "/getDictionaryValuesMap",method = {RequestMethod.GET})
    @ResponseBody
    public ResultBean<DictionaryBean> getDictionaryValuesMap(String codePath){
        ResultBean<DictionaryBean> rb = new ResultBean<DictionaryBean>();
        List<DictionaryBean> list = this.dictionaryService.getDictionaryValues(codePath);
        try {
            if(list!=null&&list.size()>0){
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
                rb.setTotal((long) list.size());
                rb.setRows(list);
            }else{
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rb.setReturnCode(SysConstant.SYS_RETURN_EXCEPTION_CODE);
            rb.setReturnMessage(SysConstant.SYS_SESSION_EXCEPTION_MESSAGE);
        }


        //List<DictionaryBean> list = null;
        return rb;
    }

}
