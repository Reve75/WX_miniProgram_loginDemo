var app = getApp();
Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUseGetUserProfile: false,
  },
  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  

  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res.userInfo)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
        wx.request({
          url: 'http://localhost:8080/saveInfo',
          method:'POST',
          header:{
            'Content-Type':'application/json'
          },
          data:{
            userInfo:res.userInfo,
            code:app.globalData.code
          },
          success:res=>{
            console.log("UserInfo message had sent to the server")
          },
          fail:err=>{
            console.log("WXMNPROGRAM can not send the Info")
          }
        })
      }
    })
  }
})