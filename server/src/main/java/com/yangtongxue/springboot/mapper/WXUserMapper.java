package com.yangtongxue.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangtongxue.springboot.domain.WXUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WXUserMapper extends BaseMapper<WXUser> {
    /*保存用户信息到数据库*/
    @Insert("insert into wx_login(nickName,gender,city,province,country,avatarUrl,openid,session_key,addTime)" +
            "values(#{nickName},#{gender},#{city},#{province},#{country},#{avatarUrl},#{openid},#{session_key}," +
            "#{addTime})")
    void saveWXUser(WXUser wxuser);

    /*判断openId是否存在*/
    @Select("select * from wx_login where openid = #{openid}")
    boolean selectOpenId(String openid);
}
