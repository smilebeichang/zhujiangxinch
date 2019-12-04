package net.wanho.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Data
public class StuClass {
    private Integer classId;
    private String className;
    private List<Student> students;
}
