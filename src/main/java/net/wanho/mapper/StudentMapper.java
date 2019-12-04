package net.wanho.mapper;

import net.wanho.dto.StudentDto;
import net.wanho.pojo.Score;
import net.wanho.pojo.StuClass;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
public interface StudentMapper {
    List<Student> findAll();

    void deleteStudent(Integer sid);

    void deleteStudentScore(Integer sid);

    Student queryById(Integer sid);

    List<StuClass> queryClass();

    List<Score> queryScore();

    void insert(Student student);

    void update(Student student);
}
