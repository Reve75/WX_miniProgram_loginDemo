// pages/list/list.js
const app=getApp()
Page({
  data:{
    listData:[],
    activeIndex:0,
    toView:"a0",
    scrollTop:100,
    screenWidth:667,
    showModalStatu:false,
    currentType:0,//当前分类
    currentIndex:0,//当前分类下序号
    sizeIndex: 0,//杯型分类序号
    sugarIndex: 0,//甜度分类序号
    temIndex: 0,//温度分类序号
    sugar: ['正常糖', '少糖', '半糖'],
    tem: ['正常冰', '少冰', '去冰'],
    size: ['常规', '珍珠', '西米露'],
    cartList: [],//购物车
    sumMonney: 0,//总金额
    cupNumber: 0,//总杯数
    scrollH: 1000,
    showCart: false,//是否显示购物车
    loading: false,
    cartMap: {},//购物车map
    model: 0,//1是预约模式  0是到店模式
    appointTime: "",
    scrollArr: [],
    sizeBox: [],
    sizeEx: 0

  },
  /**生命周期函数 */
  Onload:function (options) {
    console.log(options.model)
    console.log(options.appointTime)
    if (options.model == 1){
      this.setData({
        model:1,
        appointTime:options.appointTime
      })
    }
    var that = this;
    this.getList()
    },
    getList() {
      
    }





})

  