package com.yangtongxue.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangtongxue.springboot.domain.WXUser;
import com.yangtongxue.springboot.mapper.WXUserMapper;
import com.yangtongxue.springboot.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXUserServiceImpl extends ServiceImpl<WXUserMapper, WXUser> implements WXUserService {

    @Autowired
    private WXUserMapper wxUserMapper;

    @Override
    public void saveWXUser(WXUser wxuser) {
        wxUserMapper.saveWXUser(wxuser);
    }

    @Override
    public int selectOpenId(String openid) {
        return wxUserMapper.selectOpenId(openid);
    }
}
