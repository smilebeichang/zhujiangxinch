package net.wanho.dto;

import lombok.Data;
import net.wanho.pojo.Student;

/**
 * Created by Administrator on 2019/7/27.
 */
@Data
public class StudentDto extends Student {
    private String scoreName;
    private String className;
}
