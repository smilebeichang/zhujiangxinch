package net.wanho.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Data
public class Score {
    private Integer scoreId;
    private String scoreName;
    private List<Student> students;

}
