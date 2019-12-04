package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.dto.StudentDto;
import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Score;
import net.wanho.pojo.StuClass;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
@Service
public class StudentServiceImpl implements StudentServiceI {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public PageInfo<Student> findAllByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Student> students = studentMapper.findAll();
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        return pageInfo;
    }

    @Override
    public void delete(Integer sid) {
        studentMapper.deleteStudent(sid);
        studentMapper.deleteStudentScore(sid);
    }

    @Override
    public Student queryById(Integer sid) {
        Student student = studentMapper.queryById(sid);
        return student;
    }

    @Override
    public List<StuClass> queryClass() {
        List<StuClass> stuClasses = studentMapper.queryClass();
        System.out.println(stuClasses);
        return stuClasses;
    }

    @Override
    public List<Score> queryScore() {
        List<Score> scores = studentMapper.queryScore();
        return scores;
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }


    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

}
