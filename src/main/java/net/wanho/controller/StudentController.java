package net.wanho.controller;

import com.github.pagehelper.PageInfo;
import net.wanho.dto.StudentDto;
import net.wanho.pojo.Score;
import net.wanho.pojo.StuClass;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/29.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentServiceI studentServiceI;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Student> findAll(){
        return studentServiceI.findAll();
    }

    @RequestMapping("findAllByPage")
    public String  findAllByPage(@RequestParam(defaultValue = "1")Integer pageNum,Map map){

        PageInfo<Student> pageInfo = studentServiceI.findAllByPage(pageNum);
        map.put("pageInfo",pageInfo);
        System.out.println("======时间戳+当当前时间=======");
        System.out.println(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳s
        System.out.println(date);

        return "student";
    }

    @RequestMapping("delete")
    public String delete(Integer sid){
        studentServiceI.delete(sid);
        /*重定向：加/*/
        return "redirect:findAllByPage";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(Integer sid,Map map){

        Student student = studentServiceI.queryById(sid);
        List<StuClass> stuClasses = studentServiceI.queryClass();
        System.out.println(stuClasses);
        List<Score> score = studentServiceI.queryScore();
        map.put("st",student);
        map.put("stuClasses",stuClasses);
        map.put("score",score);
        System.out.println("========toUpdate:  "+sid);
        return "update";
    }



    @RequestMapping("toInsert")
    public String toInsert(){
        return "insert";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Student student){
        studentServiceI.insert(student);
        System.out.println(student);

        return "redirect:findAllByPage";
    }

    @RequestMapping("update")
    public String update(Student student){
        studentServiceI.update(student);
        return "redirect:findAllByPage";
    }

}
