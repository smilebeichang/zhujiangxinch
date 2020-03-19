package net.wanho.controller;


import net.wanho.pojo.BatchTestBean;
import net.wanho.pojo.BatchTestDetailBean;
import net.wanho.pojo.ResultBean;
import net.wanho.pojo.SysConstant;
import net.wanho.service.IBatchTestService;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



/**
 * 批量测试controller
 * @author songjianfeng
 * @date 2019-08-21
 */
@CrossOrigin("*")
@Controller
@RequestMapping(value = "/batchTest")
public class BatchTestController  {


    @Resource
    private IBatchTestService batchTestService;

    /**
     * 批量测试翻页查询
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getBatchTestPage", method = { RequestMethod.GET })
    @ResponseBody
    public List<BatchTestBean> getBatchTestPage(@ModelAttribute("BatchTestBean") BatchTestBean batchTestBean){
        return batchTestService.getBatchTestPage(batchTestBean);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/findAll")
    @ResponseBody
    public List<BatchTestBean> findAll(){
        return batchTestService.findAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert", method = { RequestMethod.POST })
    @ResponseBody
    public int insert(BatchTestBean batchTestBean){
        return batchTestService.insert(batchTestBean);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(BatchTestBean batchTestBean){
        return batchTestService.update(batchTestBean);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(BatchTestBean batchTestBean){
         batchTestService.delete(batchTestBean);
    }


    @RequestMapping("/getBatchTestDetailPage")
    @ResponseBody
    public List<BatchTestDetailBean> getBatchTestDetailPage(@ModelAttribute("BatchTestBean")BatchTestBean batchTestBean){
        return batchTestService.getBatchTestDetailPage(batchTestBean);
    }


    @RequestMapping(value = "/upLoadFile", method = { RequestMethod.POST } )
    @ResponseBody
    public ResultBean<BatchTestBean> upLoadFile(@RequestParam MultipartFile[] files
            , @ModelAttribute("BatchTestBean") BatchTestBean batchTestBean) {
        ResultBean<BatchTestBean> rb = new ResultBean<>();
        InputStream is =null;
        try {
            //导入
            MultipartFile mf=files[0];
            //导入jar包
            is = mf.getInputStream();
            batchTestBean.setCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));
            //此WorkbookFactory在POI-3.10版本中使用需要添加dom4j   POI是用来读写文件
            Workbook wb = WorkbookFactory.create(is);
            if (wb instanceof XSSFWorkbook) {
                XSSFWorkbook xWb = (XSSFWorkbook) wb;
                rb = getExcelInfo(batchTestBean,xWb);
            }else if(wb instanceof HSSFWorkbook){
                HSSFWorkbook hWb = (HSSFWorkbook) wb;
                rb = getExcelInfo(batchTestBean,hWb);
            }

        } catch (Exception e) {
            rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
        }finally{
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_FAILED_MESSAGE);
            }
        }
        return rb;
    }



    /**
    *执行新增具体步骤
    *getNumberOfSheets（）获得表格数据量   其实表格模板要求不重要，重要的是第一列样式除去第一行即可
    */
    private ResultBean<BatchTestBean> getExcelInfo(BatchTestBean batchTestBean, Workbook wb) {
        ResultBean<BatchTestBean> rb= new ResultBean<>();
        if( wb.getNumberOfSheets() < 1){
            rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            rb.setReturnMessage("Excel内容为空，请按照下载模板要求导入！");
            return rb;
        }
        // 获取Sheet的内容
        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        Row row;
        Cell cell;
        List<BatchTestDetailBean> list = new ArrayList<>();
        BatchTestDetailBean batchTestDetailBean;
        for (int rowNum = sheet.getFirstRowNum()+1; rowNum <= lastRowNum; rowNum++) {
            //依次获得每一行的rowNum
            row = sheet.getRow(rowNum);
            //获取第一类单元格的值
            cell = row.getCell(0);
            //你好
            String stringValue = this.getCellValue(cell);
            if(stringValue!=null&&""!=stringValue){
                //不为空
                batchTestDetailBean = new BatchTestDetailBean();
                batchTestDetailBean.setCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                //BatchTestCode和Code
                batchTestDetailBean.setBatchTestCode(batchTestBean.getCode());
                /* question */
                batchTestDetailBean.setQuestion(stringValue);
                batchTestDetailBean.setCreateDate(new Date());
                //存到list里面
                list.add(batchTestDetailBean);
            }
        }
        if(list.size() > 0){
            batchTestBean.setCreateDate(new Date());
            batchTestBean.setQuestionNum(list.size());
            //新增batchTestDetailBean
            if(batchTestService.addBatchTestDetail(list) > 0){
                //&#x65b0;&#x589e;batchTestBean
                batchTestService.insert(batchTestBean);
                rb.setReturnCode(SysConstant.SYS_RETURN_SUCCESS_CODE);
                rb.setReturnMessage(SysConstant.SYS_RETURN_SUCCESS_MESSAGE);
            }
        }else{
            rb.setReturnCode(SysConstant.SYS_RETURN_FAILED_CODE);
            rb.setReturnMessage("Excel内容为空，请按照下载模板要求导入！");
        }
        return rb;
    }


    public static String getCellValue(Cell cell) {
        String result;
        switch(cell.getCellType()) {
            case 0:
                SimpleDateFormat sdf;
                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                    sdf = null;
                    if(cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if(cell.getCellStyle().getDataFormat() == 58) {
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    if(temp.equals("General")) {
                        format.applyPattern("#");
                    }
                    result = format.format(value);
                }
                break;
            case 1:
                result = cell.getRichStringCellValue().toString();
                break;
            case 2:
            default:
                result = "";
                break;
            case 3:
                result = "";
        }

        return result;
    }



}
