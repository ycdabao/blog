package com.imodou.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
public class User {
    private Long userId;
    private String userIp;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProfilePhoto;
    private Date userRegistrationTime;
    private Date userBirthday;
    private String userTelephoneNumber;
    private String userNickname;
}
