package com.fanmo.thirdpartyplatform.utils;

public class MenuUtil {
	public static Menu getMenu(){
		Menu menu = new Menu();
		
		//设置第一个一级菜单的第一个二级菜单
//		ViewButton button11 = new ViewButton();
//		button11.setName("智能体检");
//		button11.setType("view");
//		button11.setUrl("https://sz.pharmdata100.com/");
		//button11.setUrl("https://mp.weixin.qq.com/s/M9HNeIecbwzwUwdaUNcKUA");
		//设置第一个一级菜单的第二个二级菜单
		MiniProButton button12 = new MiniProButton();
		button12.setName("安全用药");
		button12.setType("miniprogram");
		button12.setUrl("http://mp.weixin.qq.com");
		button12.setPagepath("pages/seekingMedicine/seekingMedicine");
		button12.setAppid("wxd2e723b25ce857f3");
		/*ClickButton button12 = new ClickButton();
		button12.setName("安全用药");
		button12.setType("click");
		button12.setKey("22");*/
		//设置第一个一级菜单的第三个二级菜单
		ViewButton button13 = new ViewButton();
		button13.setName("妇科频道");
		button13.setType("view");
		button13.setUrl("https://mp.weixin.qq.com/s/eHLEN-TgF17LPI0lOnOKNQ");
		//设置第一个一级菜单的第四个二级菜单
		ViewButton button14 = new ViewButton();
		button14.setName("健康资讯");
		button14.setType("view");
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzI2NjE3NDM3Mw==#wechat_redirect"); //智联e药师
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzU2MTg2ODIxNg==#wechat_redirect");//君安
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=Mzg4MzA1MDUxMA==#wechat_redirect"); //好康
		
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzU1NTc2NzA2Ng==#wechat_redirect"); //健华
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=Mzg2ODI1MTMwMw==#wechat_redirect"); //仁爱
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzU0NzAwODg4Nw==#wechat_redirect");   //惠民
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzUzMTkwNzEzOQ==#wechat_redirect");   //kangxingfu
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=Mzg3ODA1Nzg0MA==#wechat_redirect");  //御康
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzU5MDk3MzgxOA==#wechat_redirect"); //taisheng
		//button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzkxNzAwMzI4OQ==#wechat_redirect");   //春林
		button14.setUrl("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzI2NDkwODI0Ng==#wechat_redirect");  //惠民健康药房

//		ViewButton button14 = new ViewButton();
//		button14.setName("妇科频道");
//		button14.setType("view");
//		button14.setUrl("http://55962984.m.weimob.com/weisite/channel?pid=55962984&bid=57162309&wechatid=fromUsername&categoryid=2202759&wxref=mp.weixin.qq.com&channel=menu");
		//设置第二个一级菜单的第一个二级菜单 
//		MiniProButton button21 = new MiniProButton();
//		button21.setName("网上药店");
//		button21.setType("miniprogram");
//		button21.setUrl("http://mp.weixin.qq.com");
//		button21.setAppid("wxd2e723b25ce857f3");
//		//button21.setAppid("wxe38e5abe2ea3e134");
//		button21.setPagepath("pages/index/index");
		
		/*********君安*************/
		ClickButton button21 = new ClickButton();
		button21.setName("网上药店");
		button21.setType("click");
		button21.setKey("31");

//		MiniProButton button21 = new MiniProButton();
//		button21.setName("网上药店");
//		button21.setType("miniprogram");
//		button21.setUrl("http://mp.weixin.qq.com");
//		button21.setPagepath("pages/index/index");
//		button21.setAppid("wxbcef86ac3af4693f");
		/*********君安*************/
		
		
		/*ClickButton button21=new ClickButton();
		button21.setName("小程序");
		button21.setType("click");
		button21.setKey("22");*/
		//设置第二个一级菜单的第二个二级菜单
		ViewButton button22 = new ViewButton();
		button22.setName("稀缺药登记");
		button22.setType("view");
		button22.setUrl("https://sz.pharmdata100.com/gongzhonghao/xinteyao/#/");
		/*ClickButton button22=new ClickButton();
		button22.setName("新特药");
		button22.setType("click");
		button22.setKey("22");*/
		//设置第二个一级菜单的第三个二级菜单
//		MiniProButton button23 = new MiniProButton();
//		button23.setName("药师咨询");
//		button23.setType("miniprogram");
//		button23.setUrl("http://mp.weixin.qq.com");
//		button23.setAppid("wxd2e723b25ce857f3");
//		button23.setPagepath("pages/apothecarylist/apothecarylist");
		
		/*********君安*************/
		ClickButton button23 = new ClickButton();
		button23.setName("药师咨询");
		button23.setType("click");
		button23.setKey("31");
		/*********君安*************/
		
		/*ClickButton button23 = new ClickButton();
		button23.setName("寻医问药");
		button23.setType("click");
		button23.setKey("22");*/
		//设置第二个一级菜单的第四个二级菜单
		ViewButton button24 = new ViewButton();
		button24.setName("寻医问药");
		button24.setType("view");
		button24.setUrl("https://sz.pharmdata100.com/gongzhonghao/xunyiwenyao/");
		//设置第二个一级菜单的第五个二级菜单
//		ViewButton button25 = new ViewButton();
//		button25.setName("妇科手册");
//		button25.setType("view");
//		button25.setUrl("https://mp.weixin.qq.com/s/eHLEN-TgF17LPI0lOnOKNQ");

		
		//设置第三个一级菜单的第一个二级菜单
		/*ViewButton button31 = new ViewButton();
		button31.setName("我的消息");
		button31.setType("view");
		button31.setUrl("http://www.baidu.com");*/
		
		ViewButton button31 = new ViewButton();
		button31.setName("智能体检");
		button31.setType("view");
		button31.setUrl("https://sz.pharmdata100.com/");
		
		ClickButton button32 = new ClickButton();
		button32.setName("我的体重");
		button32.setType("click");
		button32.setKey("13");
		
		ClickButton button33=new ClickButton();
		button33.setName("我的消息");
		button33.setType("click");
		button33.setKey("31");
		//设置第三个一级菜单的第二个二级菜单
		ViewButton button34 = new ViewButton();
		button34.setName("会员中心");
		button34.setType("view");
		button34.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6a0290ecf70a53d&redirect_uri=https%3a%2f%2fsz.pharmdata100.com%2fSSMSC%2fSharedWeightMachine%2foauth&response_type=code&scope=snsapi_userinfo&state=123&connect_redirect=1#wechat_redirect");
		//button34.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe87a2b14d66bdad2&redirect_uri=https%3a%2f%2fsz.pharmdata100.com%2fSSMSC%2fSharedWeightMachine%2foauth&response_type=code&scope=snsapi_userinfo&state=123&connect_redirect=1#wechat_redirect");
		//button34.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2355b55f914cc997&redirect_uri=pages/index/index&response_type=code&scope=snsapi_userinfo&state=ptgg_wechatOrgId#wechat_redirect");


		//button32.setUrl("https://sz.pharmdata100.com/gongzhonghao/member_test/#/");
		/*ClickButton button32=new ClickButton();
		button32.setName("会员中心");
		button32.setType("click");
		button32.setKey("32");*/
		//设置第三个一级菜单的第三个二级菜单
		/*ViewButton button33 = new ViewButton();
		button33.setName("我的医生");
		button33.setType("view");

		button33.setUrl("http://www.baidu.com");*/
		/*ClickButton button33=new ClickButton();
		button33.setName("我的医生");
		button33.setType("click");
		button33.setKey("33");*/
		//设置第三个一级菜单的第四个二级菜单
		/*ViewButton button34 = new ViewButton();
		button34.setName("我的药师");
		button34.setType("view");
		button34.setUrl("http://www.baidu.com");*/
		/*ClickButton button34=new ClickButton();
		button34.setName("我的药师");
		button34.setType("click");
		button34.setKey("34");*/
		
		
		//封装第第一个一级菜单
		ViewButton button1 = new ViewButton();
		button1.setName("健康资讯"); //将11/12两个button作为二级菜单封装第一个一级菜单
		/*button1.setName("最新资讯"); //将11/12两个button作为二级菜单封装第一个一级菜单
		button1.setType("view");
		button1.setKey("10");
		button1.setUrl("https://mp.weixin.qq.com/s/BX-LY3tOQAl4dE5diglzYA");*/
		button1.setSub_button(new Button[]{button12,button13,button14});
		//封装第二个一级菜单
		MiniProButton button2 = new MiniProButton();
		button2.setName("网上药店"); //将21/22/23button作为二级菜单封装第二个二级菜单
		/*button2.setType("miniprogram");
		button2.setUrl("http://mp.weixin.qq.com");
		button2.setAppid("wx70bc45229d2359a1");
		button2.setPagepath("pages/index/index");*/
		button2.setSub_button(new Button[]{button21,button22,button23,button24});
		//封装第三个一级菜单
		ClickButton button3 = new ClickButton();
		button3.setName("会员服务"); //将31323334button作为二级菜单封装第三个二级菜单
		/*button3.setName("个人中心"); //将31323334button作为二级菜单封装第三个二级菜单
		button3.setType("click");
		button3.setKey("22");*/
		button3.setSub_button(new Button[]{button31,button32,button33,button34});
		//封装菜单
		menu.setButton(new Button[]{button1,button2,button3});
		return menu;
	}
}
