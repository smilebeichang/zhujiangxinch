package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.dto.StudentDto;
import net.wanho.pojo.Score;
import net.wanho.pojo.StuClass;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
public interface StudentServiceI {
    List<Student> findAll();

    PageInfo<Student> findAllByPage(Integer pageNum);

    void delete(Integer sid);

    Student queryById(Integer sid);

    List<StuClass> queryClass();

    List<Score> queryScore();

    void insert(Student student);

    void update(Student student);
}
