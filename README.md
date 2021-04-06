#Login Demo Document

####思路：获取小程序前端的code以及userInfo发送到服务器后台，服务器对数据进行解析判断是否需要插入到数据库

####注意：微信小程序getUserInfo有所变动，现在getUserInfo获取到的数据为匿名信息，需该用getUserProfile

####实现步骤
    1、用户登录小程序界面，app.js会调用wx.login将code加载到全局变量(globalData)中，
          由于程序没有使用加载授权方式，所以需要用户点击授权获取昵称button才会触发，
          触发button后，小程序会发送code以及userInfo到后台服务器。
    2、后台服务器接受到code以及userInfo后，需解析code用于构建URL用来发送网络请求(参考小程序文档服务端的code2Session)来获取openId以及session_key，
         由于session_key并不是一个固定值，所以需要对openid进行查询。判断是否需要insert userInfo 到数据库
        
    ######后续仍在优化中
         
