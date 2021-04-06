package com.yangtongxue.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class WXUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String openid;
    private String session_key;
    private String nickName;
    private Integer gender;
    private String country;
    private String province;
    private String city;
    private String avatarUrl;
    private Date addTime;
}
