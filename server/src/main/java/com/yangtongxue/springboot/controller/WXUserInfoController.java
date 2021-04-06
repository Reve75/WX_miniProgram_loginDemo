package com.yangtongxue.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangtongxue.springboot.domain.WXUser;
import com.yangtongxue.springboot.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
public class WXUserInfoController {
    @Autowired
    private WXUserService wxUserService;

    @PostMapping("/saveInfo")
    @ResponseBody
    /*
    * 该构造函数为主函数，用于梳理主流程
    * */
    public String saveUserInfo(@RequestBody Map<String,Object> demo){
        //解析传入的参数
        String key = (String)demo.get("code");
        Map<String,Object> userInfo = (Map<String, Object>)demo.get("userInfo");


        //解析openID以及session_key
        JSONObject json1 = JSONObject.parseObject(sendNet(key));
        String openid = json1.getString("openid");
        String session_key = json1.getString("session_key");

        if (selectOpenid(openid)==1){
            System.out.println("用户已经存在，无须添加");
        }
        else{
            insertInfo(openid,session_key,userInfo);
            System.out.println("用户信息添加成功");
        }
        //进行保存测试
        return "ok";
    }

    /*
    * 判断openId是否存在从而选择是否进行Insert
    * */
    public int selectOpenid(String openid){
        int count = wxUserService.selectOpenId(openid);
        return count;
    }


    /*
    * 插入数据构造函数
    * */
    public void insertInfo(String openid,String session_key,Map<String,Object>userInfo){
        //日期转换，注意addTime的类型，不要转String
        Date d1 = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(d1);

        //insert，这里没有用到mybatis-plus的功能，基本上SSM都可以用这个方法
        WXUser wxUser = new WXUser();
        wxUser.setOpenid(openid);
        wxUser.setSession_key(session_key);
        wxUser.setNickName((String)userInfo.get("nickName"));
        wxUser.setGender((Integer)userInfo.get("gender") );
        wxUser.setCity((String)userInfo.get("city"));
        wxUser.setProvince((String)userInfo.get("province"));
        wxUser.setCountry((String)userInfo.get("country"));
        wxUser.setAvatarUrl((String)userInfo.get("avatarUrl"));
        wxUser.setAddTime(d1);
        wxUserService.saveWXUser(wxUser);
    }


    /*
    * 创建构造函数用于发送网络请求
    * */
    public String sendNet(String code){
        try{
            //构建请求地址
            String str = "https://api.weixin.qq.com/sns/jscode2session?" +
                    "appid=请用你的appID，不要用我的appID" +
                    "&secret=请用你的appSecret，不要用我的appSecret" +
                    "&js_code=" +code+
                    "&grant_type=authorization_code";
            URL url = new URL(str);

            //请求微信服务器
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setRequestMethod("POST");

            //成功状态
            if(conn.getResponseCode()==200){
                //用getInputStream方法获得服务器输入流
                InputStream in  = conn.getInputStream();

                //获取服务器返回数据，将数据转化成字符串
                ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
                byte []buff = new byte[100];
                int rc = 0;
                while((rc=in.read(buff,0,100))>0){
                    swapStream.write(buff,0,rc);
                }
                byte[] byteData = swapStream.toByteArray();
                String return_data = new String(byteData,"UTF-8");
                in.close();
                return return_data;
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        return "";
    }
}
