package net.wanho.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: Mr.songbeichang
 * @create: 2020-02-08 11:12
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoBean implements Serializable {

    private static final long serialVersionUID = -6509656654099701456L;
    private String userName;
    private String userGender;
    private String userAge;
    private String userStatus;
    private String userCity;
    private String userCode;
}


