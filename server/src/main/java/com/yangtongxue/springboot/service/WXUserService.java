package com.yangtongxue.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangtongxue.springboot.domain.WXUser;
import com.yangtongxue.springboot.mapper.WXUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface WXUserService extends IService<WXUser> {
    /*Service层调用方法*/
    void saveWXUser(WXUser wxuser);

    /*调用mapper的Select openID方法*/
    boolean selectOpenId(String openid);

}
