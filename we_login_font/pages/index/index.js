Page({
data:{
  img_urls:['/images/index1.jpg','/images/index2.jpg','/images/index3.jpg'],
  indicatorDots:true,
  vertical:false,
  autoplay:true,
  interval:6000,
  duration:500,

  },

onLoad:function(options) {
  var that = this;
  wx.request({

    header:{
      'Content-Type':'json'
    },
    success:function(res) {
      console.log(res)
    }
  })
},

//发送异步请求不再是WEB 那套AJAX
//没有跨域
//请求的地址必须在管理后台添加白名单
//域名必须备案，服务端必须采用HTTPS
})